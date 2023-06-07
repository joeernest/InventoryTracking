package com.example.InventoryTracking.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity Customer
 */
@Entity
@Getter @Setter
@Table(name = "customer", uniqueConstraints = @UniqueConstraint(name = "email_unique", columnNames = "email"))
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
