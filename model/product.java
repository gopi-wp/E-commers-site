package com.example.ecommerce.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String category;
  private String name;
  private Double price;
  private Integer discount;
  private String image;
  // getters/setters, constructors
}
