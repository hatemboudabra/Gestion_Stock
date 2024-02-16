package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepo extends JpaRepository<Adresse,Long> {
}
