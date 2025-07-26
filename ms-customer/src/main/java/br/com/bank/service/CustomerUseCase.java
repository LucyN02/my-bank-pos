package br.com.bank.service;

import br.com.bank.model.Customer;

public interface CustomerUseCase {
    String createCustomer(Customer customer);

    String sendRequest(String document) throws InterruptedException;
}
