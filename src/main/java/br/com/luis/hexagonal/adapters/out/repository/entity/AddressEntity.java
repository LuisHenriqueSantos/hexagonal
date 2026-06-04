package br.com.luis.hexagonal.adapters.out.repository.entity;

import lombok.Data;

@Data
public class AddressEntity {

    private String street;

    private String cidade;

    private String uf;
}
