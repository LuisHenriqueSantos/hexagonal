package br.com.luis.hexagonal.adapters.out;

import br.com.luis.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import br.com.luis.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import br.com.luis.hexagonal.application.core.domain.Address;
import br.com.luis.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddresByZipCodeAdapter implements FindAddressByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;
    
    @Override
    public Address find(String zipCode) {
        var addresResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addresResponse);
    }
}
