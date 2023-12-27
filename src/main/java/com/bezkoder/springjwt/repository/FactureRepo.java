package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Categorie;
import com.bezkoder.springjwt.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepo extends JpaRepository<Facture,Long> {
}
