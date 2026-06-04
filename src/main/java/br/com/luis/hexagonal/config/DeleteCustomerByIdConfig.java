package br.com.luis.hexagonal.config;

import br.com.luis.hexagonal.adapters.out.DeleteCustomerByIdAdapter;
import br.com.luis.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase;
import br.com.luis.hexagonal.application.core.usecase.FindCustomerByIdUserCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteCustomerByIdConfig {
    
    @Bean
    public DeleteCustomerByIdUseCase deleteCustomerByIdUseCase(
            FindCustomerByIdUserCase findCustomerByIdUserCase,
            DeleteCustomerByIdAdapter deleteCustomerByIdAdapter
    ){
        return new DeleteCustomerByIdUseCase(findCustomerByIdUserCase, deleteCustomerByIdAdapter);
    }
}
