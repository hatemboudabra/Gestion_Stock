package com.bezkoder.springjwt.controllers;

import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import com.bezkoder.springjwt.services.AdminServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
@Tag(name = "Admin")
public class AdminController {
    @Autowired
    AdminServices adminServices;
    @Operation(description = "getAllUsers")
    @GetMapping(path = "/getAllUsers")
    List<User> getAllUsers(){
    return adminServices.getall();
}
    @Operation(description = "UpdateUser")
    @PostMapping(path = "/updateUser/{id}")
    void UpdatUser(@PathVariable Long id, @RequestBody String role){
    adminServices.UpdateROle(id,role);
}
    @Operation(description = "getRole")
    @GetMapping(path = "/getAllRole")
    List<Role> getAllRole(){
    return adminServices.getAllROles();
}
}
