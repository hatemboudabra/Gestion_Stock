package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepo extends JpaRepository<Categorie,Long> {
}

