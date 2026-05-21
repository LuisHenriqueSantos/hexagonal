package br.com.luis.hexagonal.application.core.domain;

public class Address {
    
    private String street; 
    
    private String cidade; 
    
    private String uf;

    public Address(){}
    
    public Address(String street, String cidade, String uf){
        this.street = street;
        this.cidade = cidade; 
        this.uf = uf;
    }
    
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
