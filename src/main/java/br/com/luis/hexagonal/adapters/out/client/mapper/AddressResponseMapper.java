package br.com.luis.hexagonal.adapters.out.client.mapper;

import br.com.luis.hexagonal.adapters.out.client.response.AddressResponse;
import br.com.luis.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {
    
    default Address toAddress(AddressResponse addressResponse) {
        if (addressResponse == null) {
            return null;
        }

        var address = new Address();
        address.setStreet(addressResponse.getStreet());
        address.setCidade(firstNonNull(addressResponse.getCidade(), addressResponse.getCity()));
        address.setUf(firstNonNull(addressResponse.getUf(), addressResponse.getEstado(), addressResponse.getState()));
        return address;
    }

    private String firstNonNull(String first, String second) {
        return first != null ? first : second;
    }

    private String firstNonNull(String first, String second, String third) {
        var value = firstNonNull(first, second);
        return value != null ? value : third;
    }
    
}
