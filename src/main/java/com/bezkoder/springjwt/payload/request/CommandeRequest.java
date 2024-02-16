package com.bezkoder.springjwt.payload.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeRequest {
    private Date date_creation;
    private String etatcommande;
    private Long idUser;
    private Long idLigneCommande;
}
