package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Adresse;
import com.bezkoder.springjwt.payload.request.AdresseRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AdresseService {
    void addAdresse(AdresseRequest adresseRequest);
    Adresse getadresse(Long id );
    List<Adresse> getallAdresse();

}
