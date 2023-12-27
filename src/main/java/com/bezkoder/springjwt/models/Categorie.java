package com.bezkoder.springjwt.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table( name = "Categorie")
public class Categorie implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
private String nomCategorie;
@OneToMany
    List<Produit> produitList=new ArrayList<>();

}
