package br.com.luis.hexagonal.application.core.usecase;

import br.com.luis.hexagonal.application.core.domain.Customer;
import br.com.luis.hexagonal.application.ports.in.FindCustomerInportPort;
import br.com.luis.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.luis.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase {
    
    private final FindCustomerInportPort findCustomerInportPort;
    
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    
    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerInportPort findCustomerInportPort,
                                 FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, 
                                 UpdateCustomerOutputPort updateCustomerOutputPort
    ) {
        this.findCustomerInportPort = findCustomerInportPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    public void update (Customer customer, String zipCode){
        findCustomerInportPort.find(customer.getId());
        var addres = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(addres);
        updateCustomerOutputPort.update(customer);
    }
}
