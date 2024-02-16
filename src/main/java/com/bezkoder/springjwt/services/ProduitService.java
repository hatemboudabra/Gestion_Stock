package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Produit;
import com.bezkoder.springjwt.payload.request.ProduitRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProduitService {
    void addProd(ProduitRequest produitRequest);
    void updateProd(Long id,ProduitRequest produitRequest);
    Produit getpod(Long id);
    List<Produit> getAllProd();
}
