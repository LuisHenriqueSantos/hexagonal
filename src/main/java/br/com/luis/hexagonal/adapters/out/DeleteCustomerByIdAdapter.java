package br.com.luis.hexagonal.adapters.out;

import br.com.luis.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.luis.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {
    
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);        
    }
}
