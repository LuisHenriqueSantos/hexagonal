package br.com.luis.hexagonal.application.ports.out;

import br.com.luis.hexagonal.application.core.domain.Address;

public interface FindAddressByZipCodeOutputPort {
    
    Address find(String zipCode);
    
}
