package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Commande;
import com.bezkoder.springjwt.payload.request.CommandeRequest;
import com.bezkoder.springjwt.services.CommandeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/commande")
@Tag(name = "Commande")
public class CommandeController {
    @Autowired
    CommandeService commandeService;
    @Operation(description = "addCommande")
    @PostMapping(path = "/addCommande")
    public Commande addCommande(@RequestBody CommandeRequest commandeRequest) 
    throws Exception{ return commandeService.addCommande(commandeRequest);}
    @Operation(description = "updateCommande")
    @PutMapping(path = "/updateComm")
     public void updateCommande(@RequestBody long id, long idLigne){ commandeService.updateCommande(id,idLigne);}
    @Operation(description = "getCommande")
    @GetMapping(path = "/getallCommande")
    List<Commande> gettall(){
        return commandeService.getAllCommande();
    }
}
