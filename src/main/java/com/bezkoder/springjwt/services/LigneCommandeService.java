package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.LigneCommande;
import com.bezkoder.springjwt.payload.request.LigneCommandeRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LigneCommandeService {
    void addLigne(LigneCommandeRequest ligneCommandeRequest);
    void update(Long id,LigneCommandeRequest ligneCommandeRequest);
    LigneCommande getligne(Long id);
    List<LigneCommande> getAll();
}
