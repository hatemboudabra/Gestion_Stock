package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Adresse;
import com.bezkoder.springjwt.payload.request.AdresseRequest;
import com.bezkoder.springjwt.repository.AdresseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdresseServiceImpl implements AdresseService {
    @Autowired
    AdresseRepo adresseRepo;
    @Override
    public void addAdresse(AdresseRequest adresseRequest) {
    Adresse adresse=new Adresse();
    adresse.setLatitude(adresseRequest.getLatitude());
    adresse.setLongi(adresseRequest.getLongi());
    adresse.setReal_adresse(adresseRequest.getReal_adresse());
    adresseRepo.save(adresse);
    }

    @Override
    public Adresse getadresse(Long id) {
        return adresseRepo.findById(id).get();
    }

    @Override
    public List<Adresse> getallAdresse() {
        return adresseRepo.findAll();
    }
}
