package br.com.luis.hexagonal.application.ports.out;

public interface DeleteCustomerByIdOutputPort {
    
    void delete(String id);
}
