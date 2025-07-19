package br.com.bank.external;
public interface ProducerMessage {
    void publish(String document);
}
