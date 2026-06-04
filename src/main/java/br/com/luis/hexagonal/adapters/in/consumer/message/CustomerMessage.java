package br.com.luis.hexagonal.adapters.in.consumer.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerMessage {
    
    private String id;
    
    private String name; 
    
    private String zipCode;
    
    private String cpf; 
    
    private Boolean isValidCpf;
    
    public CustomerMessage(){}
    
//    public CustomerMessage(
//            String id, String name, String zipCode, String cpf, Boolean isValidCpf
//    ){
//        this.id = id;
//        this.name = name; 
//        this.zipCode = zipCode;
//        this.cpf = cpf; 
//        this.isValidCpf = isValidCpf;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public String getCpf() {
//        return cpf;
//    }
//
//    public void setCpf(String cpf) {
//        this.cpf = cpf;
//    }
//
//    public Boolean getValidCpf() {
//        return isValidCpf;
//    }
//
//    public void setValidCpf(Boolean validCpf) {
//        isValidCpf = validCpf;
//    }
}
