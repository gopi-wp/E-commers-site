package com.example.ecommerce.controller;
import org.springframework.web.bind.annotation.*;
import com.example.ecommerce.service.ProductService;
import com.example.ecommerce.model.Product;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
  private final ProductService svc;
  public ProductController(ProductService svc) { this.svc = svc; }

  @GetMapping
  public List<Product> all() { return svc.getAll(); }

  @GetMapping("/category/{cat}")
  public List<Product> byCategory(@PathVariable String cat) { return svc.getByCategory(cat); }

  @GetMapping("/{id}")
  public Product get(@PathVariable Long id) { return svc.getById(id); }
}
