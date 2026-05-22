package br.com.luis.hexagonal.adapters.out.client.response;

import lombok.Data;

@Data
public class AdressResponse {
    
    private String street; 
    
    private String city;
    
    private String uf;
}
