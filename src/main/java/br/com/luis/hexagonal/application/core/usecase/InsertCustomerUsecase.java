package br.com.luis.hexagonal.application.core.usecase;

import br.com.luis.hexagonal.application.core.domain.Customer;
import br.com.luis.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.luis.hexagonal.application.ports.out.InsertCustomerOutputPort;
import br.com.luis.hexagonal.application.ports.in.InsertCustomerInputPort;

public class InsertCustomerUsecase implements InsertCustomerInputPort{
    
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;
    
    public InsertCustomerUsecase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, 
            InsertCustomerOutputPort insertCustomerOutputPort
    ){
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }
}
