package com.bezkoder.springjwt.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table( name = "Adresse")
public class Adresse implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String longi;
    private String latitude;
    private String real_adresse;
@OneToOne()
    private User user;
}
