package com.bezkoder.springjwt.payload.request;

import java.util.Date;
import java.util.Set;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignupRequest {
  @NotBlank
  @Size(min = 3, max = 20)
  private String username;
  @NotBlank
  @Size(max = 50)
  @Email
  private String email;
  private Set<String> role;
  @NotBlank
  @Size(min = 6, max = 40)
  private String password;
  @NotBlank
  private String firstname;
  @NotBlank
  private String lastename;
  @NotBlank
  private String cin;

  @NotBlank
  private String phone;

}
