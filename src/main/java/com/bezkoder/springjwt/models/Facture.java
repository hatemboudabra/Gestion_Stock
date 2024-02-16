package com.bezkoder.springjwt.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table( name = "Facture")
public class Facture implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date date_facture;
    private float tva;
    private float remise;
    private Type type;
    @OneToOne
    Document document;
    @OneToOne
    private Commande commande;


}
