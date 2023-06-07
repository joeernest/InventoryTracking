package com.example.InventoryTracking.adapters.persistence.repository;

import com.example.InventoryTracking.domain.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
}
