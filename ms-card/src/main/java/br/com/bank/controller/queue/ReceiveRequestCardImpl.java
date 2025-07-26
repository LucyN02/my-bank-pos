package br.com.bank.controller.queue;

import br.com.bank.service.external.producer.ProducerMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Random;

@AllArgsConstructor
@Slf4j
@Component
public class ReceiveRequestCardImpl implements  ReceiveRequestCard{
    
    private final ProducerMessage producerMessage;

    @Override
    @RabbitListener(queues = "requestCard")
    public void listen(String message) {
        Random random = new Random();

        if (random.nextInt(101) % 2 == 0) {
            producerMessage.publishSuccess(message);
        } else {
           producerMessage.publishFailed(message);
        }
    }
}
