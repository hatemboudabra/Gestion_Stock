package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Commande;
import com.bezkoder.springjwt.models.Facture;
import com.bezkoder.springjwt.payload.request.FactureRequest;
import com.bezkoder.springjwt.repository.CommandeRepo;
import com.bezkoder.springjwt.repository.FactureRepo;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.zxing.WriterException;
import com.google.zxing.BarcodeFormat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FactureServiceImpl implements FactureService {

    private final  FactureRepo factureRepo;
    @Autowired
    CommandeRepo commandeRepo;

    public FactureServiceImpl(FactureRepo factureRepo) {
        this.factureRepo = factureRepo;
    }

    @Override
    public void addFacture(FactureRequest factureRequest) {
        Facture facture = new Facture();
        facture.setDate_facture(factureRequest.getDate_facture());
        facture.setRemise(factureRequest.getRemise());
        Commande commande = commandeRepo.findById(factureRequest.getIdcommande()).get();
        facture.setCommande(commande);
        facture = factureRepo.save(facture);
        commande.setFacture(facture);
        commandeRepo.save(commande);
    }

    @Override
    public Facture getFacture(Long id) {
        return factureRepo.findById(id).get();
    }

    @Override
    public List<Facture> getAllFacture() {
        return factureRepo.findAll();
    }
    private byte[] generateQRCodeBytes(String data) throws WriterException, IOException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(data, com.google.zxing.BarcodeFormat.QR_CODE, 300, 300);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        return outputStream.toByteArray();
    }
    public byte[] generateQRCode(Long id) throws WriterException, IOException {
        byte[] result;
        Optional<Facture> optionalFacture = factureRepo.findById(id);
        if (optionalFacture.isPresent()) {
            Facture facture = optionalFacture.get();
            String factureData = "Facture ID: " + facture.getId() + " ,Date_facture: " + facture.getDate_facture() + ",Remise: "
                    + facture.getRemise() + ",type: " + facture.getType();
            result = generateQRCodeBytes(factureData);
        } else {
            throw new IllegalArgumentException("Facture not found");
        }
        return result;
    }

    public byte[] generateBarcode(Long id) throws WriterException, IOException {
        Optional<Facture> optionalFacture = factureRepo.findById(id);

        if (optionalFacture.isPresent()) {
           Facture facture = optionalFacture.get();
            String factureData = "Facture ID: " + facture.getId() + ",Date_facture: " + facture.getDate_facture() + ",Remise: "
                    + facture.getRemise() + ",type: " +facture.getType();
            return generateBarcodeBytes(factureData);
        } else {
            throw new IllegalArgumentException("Facture not found");
        }
    }

    private byte[] generateBarcodeBytes(String data) throws WriterException, IOException {
        com.google.zxing.Writer writer = new com.google.zxing.MultiFormatWriter();
        BitMatrix bitMatrix = writer.encode(data, BarcodeFormat.CODE_128, 300, 100);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
        return outputStream.toByteArray();
    }


}
