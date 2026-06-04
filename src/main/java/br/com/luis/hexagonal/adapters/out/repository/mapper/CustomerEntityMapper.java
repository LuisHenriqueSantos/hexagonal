package br.com.luis.hexagonal.adapters.out.repository.mapper;

import br.com.luis.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.luis.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    
    @Mapping(target = "addressEntity", source = "address")
    @Mapping(target = "isValidCpf", source = "validCpf")
    CustomerEntity toCustomerEntity(Customer customer);
    
    @Mapping(target = "address", source = "addressEntity")
    @Mapping(target = "validCpf", source = "isValidCpf")
    Customer toCustomer(CustomerEntity customerEntity);
}
