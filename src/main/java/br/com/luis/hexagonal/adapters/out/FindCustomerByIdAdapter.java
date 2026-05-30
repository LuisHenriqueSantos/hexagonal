package br.com.luis.hexagonal.adapters.out;

import br.com.luis.hexagonal.adapters.out.repository.CustomerRepository;
import br.com.luis.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import br.com.luis.hexagonal.application.core.domain.Customer;
import br.com.luis.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> find(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(entity -> customerEntityMapper.toCustomer(entity));  
    }
}
