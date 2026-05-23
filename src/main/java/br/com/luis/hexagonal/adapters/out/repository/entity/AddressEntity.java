package br.com.luis.hexagonal.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "address")
public class AddressEntity {

    private String street;

    private String cidade;

    private String uf;
}
