package br.com.luis.hexagonal.adapters.out.client.response;

import lombok.Data;

@Data
public class AddressResponse {
    
    private String cep;

    private String street; 
    
    private String city;

    private String cidade;

    private String state;

    private String estado;
    
    private String uf;
}
