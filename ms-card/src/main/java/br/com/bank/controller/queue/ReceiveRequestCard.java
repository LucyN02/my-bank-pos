package br.com.bank.controller.queue;

public interface ReceiveRequestCard {
    void listen(String message);
}
