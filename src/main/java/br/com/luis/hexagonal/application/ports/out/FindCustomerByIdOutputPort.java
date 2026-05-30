package br.com.luis.hexagonal.application.ports.out;

import br.com.luis.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {
    
    Optional<Customer> find(String id);
}
