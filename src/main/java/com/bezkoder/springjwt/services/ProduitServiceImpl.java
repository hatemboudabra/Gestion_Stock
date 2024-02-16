package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Categorie;
import com.bezkoder.springjwt.models.Document;
import com.bezkoder.springjwt.models.Produit;
import com.bezkoder.springjwt.payload.request.ProduitRequest;
import com.bezkoder.springjwt.repository.CategorieRepo;
import com.bezkoder.springjwt.repository.DocumentRepo;
import com.bezkoder.springjwt.repository.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    ProduitRepo produitRepo;
    @Autowired
    CategorieRepo categorieRepo;
    @Autowired
    DocumentRepo documentRepo;
    @Override
    public void addProd(ProduitRequest produitRequest) {
        Produit produit=new Produit();
        produit.setLibelle(produitRequest.getLibelle());
        produit.setDescription(produitRequest.getDescription());
        produit.setPrix(produitRequest.getPrix());
        Categorie categorie=categorieRepo.findById(produitRequest.getIdCategorie()).get();
        produit.setCategorie(categorie);
        produit=produitRepo.save(produit);
        for (Long i: produitRequest.getIddocument()
             ) {
            Document document=documentRepo.findById(i).get();
            document.setProduit(produit);
            document=documentRepo.save(document);
            produit.getDocumentList().add(document);


        }
        produit=produitRepo.save(produit);
        categorie.getProduitList().add(produit);
        categorieRepo.save(categorie);



    }

    @Override
    public void updateProd(Long id ,ProduitRequest produitRequest) {
        Produit produit=produitRepo.findById(id).get();
        produit.setLibelle(produitRequest.getLibelle());
        produit.setPrix(produitRequest.getPrix());
        produit.setDescription(produitRequest.getDescription());
        produitRepo.save(produit);

    }

    @Override
    public Produit getpod(Long id) {
        return produitRepo.findById(id).get();
    }

    @Override
    public List<Produit> getAllProd() {
        return produitRepo.findAll();
    }
}
