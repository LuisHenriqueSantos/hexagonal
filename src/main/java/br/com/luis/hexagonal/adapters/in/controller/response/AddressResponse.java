package br.com.luis.hexagonal.adapters.in.controller.response;

import lombok.Data;

@Data
public class AddressResponse {

    private String street;

    private String cidade;

    private String uf;
}
