package com.example.InventoryTracking.domain.repository;

import com.example.InventoryTracking.domain.pojo.CustomerPojo;

import java.util.List;
import java.util.Optional;

public interface ICustomerRepository {

    List<CustomerPojo> getAll();

    Optional<CustomerPojo> getCustomer(Long id);

    CustomerPojo save(CustomerPojo newCustomerPojo);

    void delete(Long id);
}
