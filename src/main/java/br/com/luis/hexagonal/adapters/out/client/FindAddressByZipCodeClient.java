package br.com.luis.hexagonal.adapters.out.client;

import br.com.luis.hexagonal.adapters.out.client.response.AdressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${arantes.client.address.url}"
)
public interface FindAddressByZipCodeClient {
    
    @GetMapping("/{zipCode}")
    AdressResponse find(@PathVariable("zipCode") String zipCode);
}
