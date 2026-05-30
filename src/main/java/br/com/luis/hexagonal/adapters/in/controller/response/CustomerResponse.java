package br.com.luis.hexagonal.adapters.in.controller.response;

import br.com.luis.hexagonal.adapters.out.client.response.AddressResponse;
import lombok.Data;

@Data
public class CustomerResponse {
    
    private String nome;

    private AddressResponse address;

    private String cpf;

    private Boolean isValidCpf;
}
