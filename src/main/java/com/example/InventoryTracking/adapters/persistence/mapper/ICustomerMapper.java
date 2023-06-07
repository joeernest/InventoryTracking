package com.example.InventoryTracking.adapters.persistence.mapper;

import com.example.InventoryTracking.domain.entity.CustomerEntity;
import com.example.InventoryTracking.domain.pojo.CustomerPojo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Transform objets Customer to CustomerPojo and CustomerEntity
 */

@Mapper(componentModel = "spring")
@Component
public interface ICustomerMapper {

    /**
     * Transform a CustomerEntity to CustomerPojo
     * @param customerEntity Entity to transform
     * @return toCustomerPojo
     */
    @Mapping(source = "id", target = "id")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "email", target = "email")
    CustomerPojo toCustomerPojo(CustomerEntity customerEntity);

    /**
     * Transform a CustomerPojo to CustomerEntity
     * @param toCustomerPojo Pojo to transform
     * @return toCustomerEntity
     */
    @InheritInverseConfiguration
    CustomerEntity toCustomerEntity(CustomerPojo toCustomerPojo);

    List<CustomerPojo> toCustomerPojoList(List<CustomerEntity> customersEntityList);
}
