package br.com.bank.service.external.producer;

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

    @Override
    public void publishSuccess(String document) {
        Message message = new Message(document.getBytes());
        log.info("Publishing Success : Payload {} / Queue {}", document, "requestSuccess");
        this.rabbitTemplate.convertAndSend("requestSuccess",message);

    }

    @Override
    public void publishFailed(String document) {
        Message message = new Message(document.getBytes());
        log.info("Publishing Failed : Payload {} / Queue {}", document, "requestFailed");
        this.rabbitTemplate.convertAndSend("requestFailed",message);
    }
}
