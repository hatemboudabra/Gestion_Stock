package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@Table( name = "Produit")
public class Produit  implements  Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private float prix;
    private String description;
    private String photo;
    //association
    @ManyToOne
    private Categorie categorie;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    List<LigneCommande> ligneCommandes=new ArrayList<>();
    @OneToMany
    List<Document> documentList=new ArrayList<>();

}
