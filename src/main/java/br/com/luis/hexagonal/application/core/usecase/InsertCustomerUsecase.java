package br.com.luis.hexagonal.application.core.usecase;

import br.com.luis.hexagonal.application.core.domain.Customer;
import br.com.luis.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import br.com.luis.hexagonal.application.ports.out.InsertCustomerOutputPort;
import br.com.luis.hexagonal.application.ports.in.InsertCustomerInputPort;
import br.com.luis.hexagonal.application.ports.out.SendCpfForValidationOutPutPort;

public class InsertCustomerUsecase implements InsertCustomerInputPort{
    
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;
    
    private final SendCpfForValidationOutPutPort sendCpfForValidationOutPutPort;
    
    public InsertCustomerUsecase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, 
            InsertCustomerOutputPort insertCustomerOutputPort,
            SendCpfForValidationOutPutPort sendCpfForValidationOutPutPort
    ){
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutPutPort = sendCpfForValidationOutPutPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutPutPort.send(customer.getCpf());
    }
}
