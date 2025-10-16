package com.example.ecommerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ecommerce.model.Product;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCategory(String category);
  List<Product> findByNameContainingIgnoreCase(String name);
}
