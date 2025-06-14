package br.com.bank.controller.request;


import br.com.bank.model.Customer;
import lombok.*;

@Getter
@Setter
public class CustomerRequest {

    private String email;
    private String document;
}
