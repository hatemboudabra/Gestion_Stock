package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Categorie;
import com.bezkoder.springjwt.repository.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategorieService {
   void addcategorie( String nomCategorie);
   void updateCategorie(Long id, String nomCategorie);
   Categorie getCategorie(Long id);
   List<Categorie> getAllCategorie();

}
