package com.example.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_item")
public class CartItem {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long productId;
  private String username;
  private Integer quantity = 1;
  // getters/setters
}
