package br.com.luis.hexagonal.adapters.in.controller.mapper;

import br.com.luis.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.luis.hexagonal.application.core.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValid", ignore = true)
    Customer toCustomer(CustomerRequest customerRequest);
    
}
