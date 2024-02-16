package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.LigneCommande;
import com.bezkoder.springjwt.payload.request.LigneCommandeRequest;
import com.bezkoder.springjwt.services.LigneCommandeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/ligneC")
@Tag(name = "LigneCommande")
public class LigneCommandeController {
    @Autowired
    LigneCommandeService ligneCommandeService;
    @Operation(description = "AddLigne")
    @PostMapping(path = "/addligne")
    public void addligne(@RequestBody LigneCommandeRequest ligneCommandeRequest){ligneCommandeService.addLigne(ligneCommandeRequest);}
    @Operation(description = "UpdateLigne")
    @PutMapping(path = "/updateligne")
    public void updateligne(@RequestBody long id, LigneCommandeRequest ligneCommandeRequest){ligneCommandeService.update(id,ligneCommandeRequest);}

    @Operation(description = "GetallLigne")
    @GetMapping(path = "/getalllinge")
    List<LigneCommande> getalllinge(){return ligneCommandeService.getAll();}
}
