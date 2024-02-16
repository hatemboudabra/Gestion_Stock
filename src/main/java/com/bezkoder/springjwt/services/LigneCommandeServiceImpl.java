package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Commande;
import com.bezkoder.springjwt.models.LigneCommande;
import com.bezkoder.springjwt.models.Produit;
import com.bezkoder.springjwt.payload.request.LigneCommandeRequest;
import com.bezkoder.springjwt.repository.CommandeRepo;
import com.bezkoder.springjwt.repository.LigneCommandeRepo;
import com.bezkoder.springjwt.repository.ProduitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LigneCommandeServiceImpl implements LigneCommandeService {
    @Autowired
    LigneCommandeRepo ligneCommandeRepo;
    @Autowired
    ProduitRepo produitRepo;
    CommandeRepo commandeRepo;
    @Override
    public void addLigne(LigneCommandeRequest ligneCommandeRequest) {
        LigneCommande ligneCommande=new LigneCommande();
        ligneCommande.setQuantiteC(ligneCommandeRequest.getQuantiteC());

        Produit produit=produitRepo.findById(ligneCommandeRequest.getIdproduit()).get();
        Commande commande=commandeRepo.findById(ligneCommandeRequest.getIdcommande()).get();
        ligneCommande.setMontantTTCC(produit.getPrix()*(1+1/10));
        ligneCommande.setMontantHTC(produit.getPrix());
        ligneCommande.setCommande(commande);
        ligneCommande.setProduit(produit);

        ligneCommande=ligneCommandeRepo.save(ligneCommande);
        commande.getLigneCommandes().add(ligneCommande);
        commande.setMontantHTL(commande.getMontantTTCL()+(ligneCommande.getMontantTTCC()*ligneCommande.getQuantiteC()));
        commande.setMontantHTL(commande.getMontantHTL()+(ligneCommande.getMontantHTC()*ligneCommande.getQuantiteC()));
        commandeRepo.save(commande);
        produit.getLigneCommandes().add(ligneCommande);
        produitRepo.save(produit);

    }

    @Override
    public void update(Long id, LigneCommandeRequest ligneCommandeRequest) {
      LigneCommande ligneCommande=  ligneCommandeRepo.findById(id).get();
      Commande commande=commandeRepo.findById(ligneCommandeRequest.getIdcommande()).get();
      ligneCommande.setQuantiteC(ligneCommandeRequest.getQuantiteC());
        commande.setMontantHTL(commande.getMontantTTCL()+(ligneCommande.getMontantTTCC()*ligneCommande.getQuantiteC()));
        commande.setMontantHTL(commande.getMontantHTL()+(ligneCommande.getMontantHTC()*ligneCommande.getQuantiteC()));
ligneCommandeRepo.save(ligneCommande);
commandeRepo.save(commande);

    }

    @Override
    public LigneCommande getligne(Long id) {
        return ligneCommandeRepo.findById(id).get();
    }

    @Override
    public List<LigneCommande> getAll() {
        return ligneCommandeRepo.findAll();
    }
}
