package br.com.luis.hexagonal.adapters.in.controller;

import br.com.luis.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.luis.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.luis.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/vi/customers")
public class CustomerController {
     
    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;
    
    @Autowired
    private CustomerMapper customerMapper;
    
    @PostMapping
    public ResponseEntity<Void> insert(
            @Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }
}
