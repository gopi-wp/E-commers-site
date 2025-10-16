package com.example.ecommerce.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @GetMapping("/me")
  public Object me(@AuthenticationPrincipal UserDetails user) {
    if (user == null) return Map.of("authenticated", false);
    return Map.of("authenticated", true, "username", user.getUsername());
  }
}
