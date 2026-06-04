package br.com.luis.hexagonal.adapters.in.consumer;

import br.com.luis.hexagonal.adapters.in.consumer.mapper.CustomerMessageMepper;
import br.com.luis.hexagonal.adapters.in.consumer.message.CustomerMessage;
import br.com.luis.hexagonal.application.ports.in.UpdateCustomerInportPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidateCpfCunsumer {
    
    @Autowired
    private UpdateCustomerInportPort updateCustomerInportPort;
    
    @Autowired
    private CustomerMessageMepper customerMessageMepper;
    
    @KafkaListener(topics = "tp-cpf-validated", groupId = "henrique")
    public void receive(CustomerMessage customerMessage){
        var customer = customerMessageMepper.toCustomer(customerMessage);
        updateCustomerInportPort.update(customer, customerMessage.getZipCode());
    }
}
