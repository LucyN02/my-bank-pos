package br.com.bank.service.external.producer;

public interface ProducerMessage {
    void publishSuccess(String document);
    void publishFailed(String document);
}
