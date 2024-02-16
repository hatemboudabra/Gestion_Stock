package com.bezkoder.springjwt.payload.request;

import com.bezkoder.springjwt.models.Type;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureRequest {
    private Date date_facture;
    private float remise;
    private String type;
    private Long idcommande;
}
