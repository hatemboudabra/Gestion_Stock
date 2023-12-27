package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table( name = "Commande")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date date_creation;
    private float montantTTCL;
    private float montantHTL;
    private String etatcommande;
//Association
   @JsonIgnore
   @ManyToOne
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    User user;
    @OneToOne
    private Facture facture;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    List<LigneCommande> ligneCommandes= new ArrayList<>();
}
