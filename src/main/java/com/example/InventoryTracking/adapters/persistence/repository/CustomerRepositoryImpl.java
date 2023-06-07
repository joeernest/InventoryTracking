package com.example.InventoryTracking.adapters.persistence.repository;

import com.example.InventoryTracking.domain.pojo.CustomerPojo;
import com.example.InventoryTracking.domain.repository.ICustomerRepository;
import com.example.InventoryTracking.domain.entity.CustomerEntity;
import com.example.InventoryTracking.adapters.persistence.mapper.ICustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CustomerRepositoryImpl implements ICustomerRepository {

    @Autowired
    private final ICustomerJpaRepository customerJpaRepository;
    @Autowired
    private final ICustomerMapper customerMapper;

    @Autowired
    public CustomerRepositoryImpl(ICustomerJpaRepository customerRepository, ICustomerMapper customerMapper) {
        this.customerJpaRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerPojo> getAll() {
        return customerMapper.toCustomerPojoList(customerJpaRepository.findAll());
    }

    @Override
    public Optional<CustomerPojo> getCustomer(Long id) {
        return customerJpaRepository.findById(id)
                .map(customerMapper::toCustomerPojo);
    }

    @Override
    public CustomerPojo save(CustomerPojo newCustomerPojo) {
        CustomerEntity customerEntity = customerMapper.toCustomerEntity(newCustomerPojo);
        return customerMapper.toCustomerPojo(customerJpaRepository.save(customerEntity));
    }

    @Override
    public void delete(Long id) {
        customerJpaRepository.deleteById(id);
    }
}
