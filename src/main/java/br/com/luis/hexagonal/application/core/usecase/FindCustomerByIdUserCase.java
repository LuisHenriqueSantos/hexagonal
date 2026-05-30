package br.com.luis.hexagonal.application.core.usecase;

import br.com.luis.hexagonal.application.core.domain.Customer;
import br.com.luis.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUserCase {
    
    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUserCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    public Customer find(String id){
        return findCustomerByIdOutputPort.find(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
