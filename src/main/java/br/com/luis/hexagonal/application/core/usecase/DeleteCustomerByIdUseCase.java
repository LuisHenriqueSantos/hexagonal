package br.com.luis.hexagonal.application.core.usecase;

import br.com.luis.hexagonal.application.ports.in.FindCustomerInportPort;

public class DeleteCustomerByIdUseCase {
    
    private final FindCustomerInportPort findCustomerInportPort;
    
    private final DeleteCustomerByIdUseCase deleteCustomerByIdUseCase;

    public DeleteCustomerByIdUseCase(FindCustomerInportPort findCustomerInportPort,
                                     DeleteCustomerByIdUseCase deleteCustomerByIdUseCase
    ) {
        this.findCustomerInportPort = findCustomerInportPort;
        this.deleteCustomerByIdUseCase = deleteCustomerByIdUseCase;
    }


    public void delete(String id){
        findCustomerInportPort.find(id);
        deleteCustomerByIdUseCase.delete(id);
    }
}
