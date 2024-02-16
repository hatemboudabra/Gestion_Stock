package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Commande;
import com.bezkoder.springjwt.models.Produit;
import com.bezkoder.springjwt.payload.request.CommandeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommandeService {

    Commande addCommande(CommandeRequest commandeRequest);
    void updateCommande(Long id,Long idLigne);
    Commande getCommande(Long id);
    List<Commande> getAllCommande();

}
