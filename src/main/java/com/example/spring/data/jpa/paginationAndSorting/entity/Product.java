package com.example.spring.data.jpa.paginationAndSorting.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter

@NoArgsConstructor
@ToString

public class Product {
    @Id
    @GeneratedValue

    private int id;
    private String name;
    private int quantity;
    private long price;

    public Product(int id, String name, int quantity, long price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}
