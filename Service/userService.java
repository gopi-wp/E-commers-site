package com.example.ecommerce.service;
import org.springframework.stereotype.Service;
import com.example.ecommerce.repository.UserRepository;
import com.example.ecommerce.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import jakarta.annotation.PostConstruct;

@Service
public class UserService {
  private final UserRepository repo;
  private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

  public UserService(UserRepository repo) { this.repo = repo; }

  @PostConstruct
  public void init() {
    if (repo.findByUsername("admin").isEmpty()) {
      User u = new User();
      u.setUsername("admin");
      u.setPassword(encoder.encode("password")); // default password: password
      u.setRole("ROLE_ADMIN");
      repo.save(u);
    }
  }
}
