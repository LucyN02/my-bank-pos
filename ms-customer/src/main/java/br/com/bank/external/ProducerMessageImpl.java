package br.com.bank.external;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class ProducerMessageImpl implements ProducerMessage {

    private final RabbitTemplate rabbitTemplate;

    public void publish(String document) {
        Message message = new Message(document.getBytes());
        log.info("Publishing : Payload {} / Queue {}", document, "requestCardTest");
        this.rabbitTemplate.send("requestCard",message);
        log.info("Published : Payload {} / Queue {} ", document, "requestCardTest");
    }

}
