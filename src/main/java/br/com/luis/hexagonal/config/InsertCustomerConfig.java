package br.com.luis.hexagonal.config;

import br.com.luis.hexagonal.adapters.out.FindAddresByZipCodeAdapter;
import br.com.luis.hexagonal.adapters.out.InsertCustomerAdapter;
import br.com.luis.hexagonal.adapters.out.SendCpfValidationAdapter;
import br.com.luis.hexagonal.application.core.usecase.InsertCustomerUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {
    
    @Bean
    public InsertCustomerUsecase insertCustomerUsecase(
            FindAddresByZipCodeAdapter findAddresByZipCodeAdapter,
            InsertCustomerAdapter insertCustomerAdapter, 
            SendCpfValidationAdapter sendCpfValidationAdapter
    ) {
      return new InsertCustomerUsecase(findAddresByZipCodeAdapter, insertCustomerAdapter, sendCpfValidationAdapter);          
    }
}
