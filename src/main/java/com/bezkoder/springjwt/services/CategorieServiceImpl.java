package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Categorie;
import com.bezkoder.springjwt.repository.CategorieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategorieServiceImpl implements CategorieService {
    @Autowired
    CategorieRepo categorieRepo;
    @Override
    public void addcategorie(String nomCategorie) {

    Categorie categorie=new Categorie();
    categorie.setNomCategorie(nomCategorie);
    categorieRepo.save(categorie);
    }

    @Override
    public void updateCategorie(Long id,String nomCategorie) {
        Categorie categorie= categorieRepo.findById(id).get();
        categorie.setNomCategorie(nomCategorie);
        categorieRepo.save(categorie);

    }

    @Override
    public Categorie getCategorie(Long id) {
        return categorieRepo.findById(id).get();
    }

    @Override
    public List<Categorie> getAllCategorie() {
        return categorieRepo.findAll();
    }
}
