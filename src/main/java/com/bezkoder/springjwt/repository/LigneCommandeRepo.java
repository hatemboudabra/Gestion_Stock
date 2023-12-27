package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Categorie;
import com.bezkoder.springjwt.models.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneCommandeRepo extends JpaRepository<LigneCommande,Long> {
}
