package com.bezkoder.springjwt.payload.request;

import com.bezkoder.springjwt.models.Categorie;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitRequest {
    private String libelle;
    private float prix;
    private String description;
    private String photo;
    private Long idCategorie;
   private List<Long> iddocument;
}
