package br.com.bank.config;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ConfigureMessageBrokerRabbitMQ {


    private final AmqpAdmin amqpAdmin;

    private Queue createQueueDocumentSuccess() {
        return new Queue("requestSuccess", true, false, false);
    }

    private Queue createQueueDocumentFail() {
        return new Queue("requestFailed", true, false, false);
    }

    private DirectExchange checkDocumentExchangeSuccess() {
        return new DirectExchange("exchangeSuccess");
    }

    private DirectExchange checkDocumentExchangeFail() {
        return new DirectExchange("exchangeFailed");
    }

    private Binding checkDocumentQueue(Queue queue, DirectExchange exchange) {
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE,
                exchange.getName(), queue.getName(),null);
    }

    @PostConstruct
    private void binding() {

        //success creation
        var document_success_queue = this.createQueueDocumentSuccess();
        var document_exchange_success= this.checkDocumentExchangeSuccess();

        // fail creation
        var document_fail_queue = this.createQueueDocumentFail();
        var document_exchange_fail = this.checkDocumentExchangeFail();


        //success binding
        var bindingExchangeToQueueDocumentSuccess = this.checkDocumentQueue(document_success_queue,document_exchange_success);
        this.amqpAdmin.declareQueue(document_success_queue);
        this.amqpAdmin.declareExchange(document_exchange_success);
        this.amqpAdmin.declareBinding(bindingExchangeToQueueDocumentSuccess);


        //fail binding
        var bindingExchangeToQueueDocumentFail = this.checkDocumentQueue(document_fail_queue,document_exchange_fail);
        this.amqpAdmin.declareQueue(document_fail_queue);
        this.amqpAdmin.declareExchange(document_exchange_fail);
        this.amqpAdmin.declareBinding(bindingExchangeToQueueDocumentFail);

    }
}
