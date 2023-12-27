package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Facture;
import com.bezkoder.springjwt.payload.request.FactureRequest;
import com.google.zxing.WriterException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface FactureService {
    void addFacture(FactureRequest factureRequest);
    Facture getFacture(Long id);
    List<Facture> getAllFacture();

    byte[] generateQRCode(Long id) throws WriterException, IOException;


    byte[] generateBarcode(Long id) throws WriterException, IOException;

}
