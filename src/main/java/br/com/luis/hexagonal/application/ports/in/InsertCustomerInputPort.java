package br.com.luis.hexagonal.application.ports.in;

import br.com.luis.hexagonal.application.core.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}
