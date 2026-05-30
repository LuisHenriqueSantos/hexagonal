package br.com.luis.hexagonal.adapters.in.controller;

import br.com.luis.hexagonal.adapters.in.controller.mapper.CustomerMapper;
import br.com.luis.hexagonal.adapters.in.controller.request.CustomerRequest;
import br.com.luis.hexagonal.adapters.in.controller.response.CustomerResponse;
import br.com.luis.hexagonal.application.ports.in.FindCustomerInportPort;
import br.com.luis.hexagonal.application.ports.in.InsertCustomerInputPort;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/vi/customers")
public class CustomerController {
     
    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;
    
    @Autowired
    private FindCustomerInportPort findCustomerInportPort;
    
    @Autowired
    private CustomerMapper customerMapper;
    
    @PostMapping
    public ResponseEntity<Void> insert(
            @Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("{/id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable final String id){
        var customer = findCustomerInportPort.findById(id);
        var customerResponse = customerMapper.toCustomerResponse(customer);
        return ResponseEntity.ok().body(customerResponse);
    }
}
