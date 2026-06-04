package br.com.luis.hexagonal.config;

import br.com.luis.hexagonal.adapters.out.FindAddresByZipCodeAdapter;
import br.com.luis.hexagonal.adapters.out.FindCustomerByIdAdapter;
import br.com.luis.hexagonal.adapters.out.UpdateCustomerAdapter;
import br.com.luis.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import br.com.luis.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {
    
    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(
            FindCustomerByIdUserCase findCustomerByIdUserCase,
            FindAddresByZipCodeAdapter findAddresByZipCodeAdapter,
            UpdateCustomerAdapter updateCustomerAdapter
    ){
        return new UpdateCustomerUseCase(findCustomerByIdUserCase, findAddresByZipCodeAdapter, updateCustomerAdapter);
    }
}
