package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Categorie;
import com.bezkoder.springjwt.models.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepo extends JpaRepository<Commande,Long> {
}
