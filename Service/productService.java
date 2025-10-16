package com.example.ecommerce.service;
import org.springframework.stereotype.Service;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.model.Product;

import java.util.List;

@Service
public class ProductService {
  private final ProductRepository repo;
  public ProductService(ProductRepository repo) { this.repo = repo; }

  public List<Product> getAll() { return repo.findAll(); }
  public List<Product> getByCategory(String cat) { return repo.findByCategory(cat); }
  public Product getById(Long id) { return repo.findById(id).orElse(null); }
}
