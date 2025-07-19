package br.com.bank.controller.api;

import br.com.bank.controller.request.CustomerRequest;
import br.com.bank.model.Customer;
import br.com.bank.service.CustomerUseCase;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private final CustomerUseCase customerUseCase;

    public CustomerController(CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @PostMapping
    public String create(@RequestBody CustomerRequest customerRequest) {
        return createCustomer(customerRequest);
    }

    @GetMapping("/request-card/{document}")
    public String requestCard(@PathVariable String document)   {
            return this.customerUseCase.sendRequest(document);
    }
    
    private String createCustomer(CustomerRequest customerRequest) {
        return this.customerUseCase.createCustomer(Customer.builder()
                        .email(customerRequest.getEmail())
                        .document(customerRequest.getDocument())
                .build());
    }
}
