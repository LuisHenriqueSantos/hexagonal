package br.com.luis.hexagonal.adapters.out.repository.mapper;

import br.com.luis.hexagonal.adapters.out.repository.entity.CustomerEntity;
import br.com.luis.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerEntityMapper {
    
    CustomerEntity toCustomerEntity(Customer customer);
}
