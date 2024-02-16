package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Facture;
import com.bezkoder.springjwt.payload.request.FactureRequest;
import com.bezkoder.springjwt.services.FactureService;
import com.google.zxing.WriterException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/facture")
@Tag(name = "FactureController")
public class FactureController {
    @Autowired
    FactureService factureService;
    @Operation(description = "AddFacture")
    @PostMapping(path = "/addfacture")
    public void addFacture(@RequestBody FactureRequest factureRequest)
     {factureService.addFacture(factureRequest);}
    @Operation(description = "GetAllFacture")
    @GetMapping(path = "/getallfact")
    List<Facture> gettall(){
        return factureService.getAllFacture();
    }
    @GetMapping("/{id}/qrcode")
    public ResponseEntity<byte[]> generateQRCode(@PathVariable Long id) {
        try {
            byte[] qrCodeBytes = factureService.generateQRCode(id);
            return ResponseEntity.ok().header("Content-Type", "image/png").body(qrCodeBytes);
        } catch (IOException | com.google.zxing.WriterException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}/barcode")
    public ResponseEntity<byte[]> generateBarcode(@PathVariable Long id) {
        try {
            byte[] barcodeBytes = factureService.generateBarcode(id);
            return ResponseEntity.ok().header("Content-Type", "image/png").body(barcodeBytes);
        } catch (IOException | WriterException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
