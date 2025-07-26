package br.com.bank.service;

import br.com.bank.model.Customer;

public interface CustomerUseCase {
    void createCustomer(Customer customer);

    String sendRequest(String document) throws InterruptedException;
}
