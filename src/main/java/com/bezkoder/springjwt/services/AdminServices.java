package com.bezkoder.springjwt.services;

import com.bezkoder.springjwt.models.Role;
import com.bezkoder.springjwt.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminServices {
    List<User> getall();
    void UpdateROle(Long id,String role);
    List<Role> getAllROles();
}
