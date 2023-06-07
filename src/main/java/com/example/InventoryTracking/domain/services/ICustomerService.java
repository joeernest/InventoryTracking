package com.example.InventoryTracking.domain.services;

import com.example.InventoryTracking.domain.pojo.CustomerPojo;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<CustomerPojo> getAll();

    Optional<CustomerPojo> getCustomerPojo(Long id);

    CustomerPojo save(CustomerPojo newCustomerPojo);

    boolean delete(Long id);
}
