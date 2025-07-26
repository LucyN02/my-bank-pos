package br.com.bank.service.external.consumer;

import br.com.bank.service.external.ValidRequestCard;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class ConsumerMessageImpl implements ConsumerMessage{

    private final ValidRequestCard validRequestCard;

    @RabbitListener(queues = "requestSuccess")
    private String consumerSuccess(String message) {
        log.info("Received  Success : Payload {} / Queue {}", message, "requestSuccess");
        return validRequestCard.message = "Congratulations, your card has been requested.";

    }

    @RabbitListener(queues = "requestFailed")
    private String consumerFailed(String message) {
        log.info("Received Failed : Payload {} / Queue {}", message, "requestFailed");
       return validRequestCard.message = "Sorry, your card cannot be requested.";
    }

    @Override
    public String validRequest() {
        return validRequestCard.message;
    }
}
