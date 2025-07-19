package br.com.bank.controller.api;

import br.com.bank.controller.request.CardRequest;
import br.com.bank.model.Card;
import br.com.bank.model.Flags;
import br.com.bank.service.CardUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cards")
@AllArgsConstructor
public class CardController {

    private final CardUseCase cardUseCase;

    @PostMapping
    public void create(@RequestBody CardRequest  cardRequest) {
        this.cardUseCase.createCard(createCard(cardRequest));
    }

    private Card createCard(CardRequest cardRequest) {
        return (Card.builder()
                .name(cardRequest.getName())
                .flag(Flags.valueOf(cardRequest.getFlag()))
                .card_limits(cardRequest.getCard_limit())
                .build());
    }
}
