package br.com.bank.service.usecase;

import br.com.bank.external.ProducerMessage;
import br.com.bank.model.Customer;
import br.com.bank.repository.CustomerRepository;
import br.com.bank.service.CustomerUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerUseCaseImpl implements CustomerUseCase {

    private final ProducerMessage producerMessage;
    private final CustomerRepository customerRepository;

    @Override
    public String createCustomer(Customer customer) {
        Optional<Customer> customerDocument = customerRepository.findByDocument(customer.getDocument());
            if (customerDocument.isPresent()) return "customer already exists";

            this.customerRepository.save(customer);
            return "customer created successfully";
    }

    @Override
    public String sendRequest(String document) {
        Optional<Customer> customer = this.customerRepository.findByDocument(document);
        try {
            Customer entity = customer.orElseThrow();
            int req = entity.getRequests();
            entity.setRequests(req + 1);
            this.customerRepository.save(entity);
            this.producerMessage.publish(document);
        } catch (Exception ex){
            return "customer not found";
        }

        return "Card requested successfully";
    }
}
