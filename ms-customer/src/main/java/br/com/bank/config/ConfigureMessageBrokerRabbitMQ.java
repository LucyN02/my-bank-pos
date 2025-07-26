package br.com.bank.config;

import jakarta.annotation.PostConstruct;
import lombok.Generated;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.stereotype.Component;


@Component
public class ConfigureMessageBrokerRabbitMQ {

    private final AmqpAdmin rabbitmq;

    private Queue createQueueRequestCard() {
        return new Queue("requestCard", true, false, false);
    }

    private DirectExchange checkRequestCardExchange() {
        return new DirectExchange("checkValidationRequestCardExchange");
    }
    private Binding allBinding(Queue queue, DirectExchange exchange) {
        return new Binding(queue.getName(), DestinationType.QUEUE, exchange.getName(), queue.getName(), null);
    }

    @PostConstruct
    private void binding() {
        Queue validation_request_card_queue = this.createQueueRequestCard();
        DirectExchange validation_request_card_exchange = this.checkRequestCardExchange();
        Binding bindingExchangeToValidationRequestCard = this.allBinding(validation_request_card_queue, validation_request_card_exchange);
        this.rabbitmq.declareQueue(validation_request_card_queue);
        this.rabbitmq.declareExchange(validation_request_card_exchange);
        this.rabbitmq.declareBinding(bindingExchangeToValidationRequestCard);
    }

    @Generated
    public ConfigureMessageBrokerRabbitMQ(AmqpAdmin rabbitmq) {
        this.rabbitmq = rabbitmq;
    }
}
