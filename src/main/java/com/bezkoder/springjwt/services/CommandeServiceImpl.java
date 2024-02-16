package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Commande;
import com.bezkoder.springjwt.models.LigneCommande;
import com.bezkoder.springjwt.models.Produit;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.payload.request.CommandeRequest;
import com.bezkoder.springjwt.repository.CommandeRepo;
import com.bezkoder.springjwt.repository.LigneCommandeRepo;
import com.bezkoder.springjwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommandeServiceImpl implements CommandeService {
    @Autowired
    CommandeRepo commandeRepo;
    @Autowired
    UserRepository userRepository;
    @Autowired
    LigneCommandeRepo ligneCommandeRepo;

    @Override
    public Commande addCommande(CommandeRequest commandeRequest) {
        Commande commande =new Commande();
        commande.setDate_creation(commandeRequest.getDate_creation());
        User user=userRepository.findById(commandeRequest.getIdUser()).get();
        commande.setUser(user);
       commande=commandeRepo.save(commande);
       user.getCommandes().add(commande);
       userRepository.save(user);
return commande;
    }

    @Override
    public void updateCommande(Long id,Long idLigne) {
        Commande commande=commandeRepo.findById(id).get();
        LigneCommande ligneCommande= ligneCommandeRepo.findById(idLigne).get();
        commande.setMontantHTL(commande.getMontantTTCL()-(ligneCommande.getMontantTTCC()*ligneCommande.getQuantiteC()));
        commande.setMontantHTL(commande.getMontantHTL()-(ligneCommande.getMontantHTC()*ligneCommande.getQuantiteC()));
        commande.getLigneCommandes().remove(ligneCommande);
        commandeRepo.save(commande);
    }

    @Override
    public Commande getCommande(Long id) {
        return commandeRepo.findById(id).get();
    }

    @Override
    public List<Commande> getAllCommande() {
        return commandeRepo.findAll();
    }
}
