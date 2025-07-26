package br.com.bank.service.external.producer;
public interface ProducerMessage {
    void publish(String document);
}
