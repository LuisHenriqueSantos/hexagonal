package br.com.luis.hexagonal.config;

import br.com.luis.hexagonal.adapters.out.FindCustomerByIdAdapter;
import br.com.luis.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {
    
    @Bean
    public FindCustomerByIdUserCase findCustomerByIdUserCase(FindCustomerByIdAdapter findCustomerByIdAdapter){
        return new FindCustomerByIdUserCase(findCustomerByIdAdapter);
    }
}
