package br.com.luis.hexagonal.adapters.out.client.mapper;

import br.com.luis.hexagonal.adapters.out.client.response.AddressResponse;
import br.com.luis.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    
    Address toAddress(AddressResponse addressResponse);
    
}
