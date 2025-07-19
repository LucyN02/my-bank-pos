package br.com.bank.service;

import br.com.bank.model.Card;
import br.com.bank.repository.CardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CardUseCase {

    private final CardRepository cardRepository;

    public void createCard(Card card) {
         this.cardRepository.save(card);
    }
}
