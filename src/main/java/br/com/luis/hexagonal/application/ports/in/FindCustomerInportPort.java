package br.com.luis.hexagonal.application.ports.in;

import br.com.luis.hexagonal.application.core.domain.Customer;

public interface FindCustomerInportPort {
    
    Customer findById(String id);
    
}
