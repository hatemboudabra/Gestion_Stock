package com.bezkoder.springjwt.payload.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LigneCommandeRequest {
    private int quantiteC;
    private Long idproduit;
    private Long idcommande;
}
