package br.com.luis.hexagonal.application.core.usecase;

import br.com.luis.hexagonal.application.ports.in.DeleteCustomerByIdInportPort;
import br.com.luis.hexagonal.application.ports.in.FindCustomerInportPort;
import br.com.luis.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInportPort {
    
    private final FindCustomerInportPort findCustomerInportPort;
    
    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerInportPort findCustomerInportPort, 
                                     DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort
    ) {
        this.findCustomerInportPort = findCustomerInportPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void delete(String id){
        findCustomerInportPort.find(id);
        deleteCustomerByIdOutputPort.delete(id);
    }
}
