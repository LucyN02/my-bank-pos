package br.com.bank.controller.queue;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Slf4j
@Component
public class ReceiveRequestCardImpl implements  ReceiveRequestCard{

    @Override
    @RabbitListener(queues = "requestCard")
    public void listen(String message) {
        System.out.println(message);
    }
}
