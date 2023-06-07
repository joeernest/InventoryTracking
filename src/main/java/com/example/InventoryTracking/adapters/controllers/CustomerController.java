package com.example.InventoryTracking.adapters.controllers;

import com.example.InventoryTracking.domain.pojo.CustomerPojo;
import com.example.InventoryTracking.domain.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @GetMapping
    public ResponseEntity<List<CustomerPojo>> getAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CustomerPojo> getCustomerPojo(@PathVariable Long id) {
        return ResponseEntity.of(customerService.getCustomerPojo(id));
    }

    @PostMapping
    public ResponseEntity<CustomerPojo> addCustomer(@RequestBody CustomerPojo customerPojo) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(customerService.save(customerPojo));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerPojo> updateCustomer(@RequestBody CustomerPojo customerPojo) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(customerService.save(customerPojo));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable Long id){
        return new ResponseEntity<>(this.customerService.delete(id) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }


}
