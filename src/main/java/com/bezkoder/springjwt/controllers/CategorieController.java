package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Categorie;
import com.bezkoder.springjwt.services.CategorieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/categorie")
@Tag(name = "Categorie")
public class CategorieController {
    @Autowired
    CategorieService categorieService;
    @Operation(description = "AddCategorie")
    @PostMapping(path = "/addCatt")
     public void addCatt(@RequestBody String name){
        categorieService.addcategorie(name);
    }
    @Operation(description = "updateCategorie")
    @PutMapping(path = "/updateCat")
    public void updateCat(@RequestBody long id, String name){categorieService.updateCategorie(id,name);}
    @Operation(description = "AllCategorie")
    @GetMapping(path = "/getallCat")
    List<Categorie> getallCat(){
        return categorieService.getAllCategorie();
    }
}
