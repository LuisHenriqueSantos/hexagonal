package br.com.luis.hexagonal.application.core.usecase;

import br.com.luis.hexagonal.application.ports.in.FindCustomerInportPort;
import br.com.luis.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase {
    
    private final FindCustomerInportPort findCustomerInportPort;
    
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerInportPort findCustomerInportPort, 
                                     DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort
    ) {
        this.findCustomerInportPort = findCustomerInportPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }


    public void delete(String id){
        findCustomerInportPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
