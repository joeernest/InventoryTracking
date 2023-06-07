package com.example.InventoryTracking.domain.services;

import com.example.InventoryTracking.adapters.persistence.mapper.ICustomerMapper;
import com.example.InventoryTracking.domain.pojo.CustomerPojo;
import com.example.InventoryTracking.domain.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository customerRepository;

    @Override
    public List<CustomerPojo> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public Optional<CustomerPojo> getCustomerPojo(Long id) {
        return customerRepository.getCustomer(id);
    }

    @Override
    public CustomerPojo save(CustomerPojo newCustomerPojo) {
        return customerRepository.save(newCustomerPojo);
    }

    @Override
    public boolean delete(Long id) {
        try {
            customerRepository.delete(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
