package br.com.luis.hexagonal.application.ports.out;

import br.com.luis.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {
    
    void update(Customer customer);
}
