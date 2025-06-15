package br.com.bank.service.usecase;

import br.com.bank.model.Customer;
import br.com.bank.repository.CustomerRepository;
import br.com.bank.service.CustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerUseCaseImpl implements CustomerUseCase {

    private final CustomerRepository customerRepository;

    @Override
    public void createCustomer(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public String sendRequest(String document) {
        Optional<Customer> customer = this.customerRepository.findByDocument(document);
        try {
            Customer entity = customer.orElseThrow();
            int req = entity.getRequests();
            entity.setRequests(req + 1);
            this.customerRepository.save(entity);
        } catch (Exception ex){
            return "customer not found";
        }

        return "Card requested successfully";
    }
}
