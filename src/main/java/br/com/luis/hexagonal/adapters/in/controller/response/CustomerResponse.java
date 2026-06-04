package br.com.luis.hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class CustomerResponse {
    
    private String nome;

    private AddressResponse address;

    private String cpf;

    private Boolean isValidCpf;
}
