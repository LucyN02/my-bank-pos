package br.com.bank.controller.request;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CardRequest {
    private String name;
    private String flag;
    private BigDecimal card_limit;
}
