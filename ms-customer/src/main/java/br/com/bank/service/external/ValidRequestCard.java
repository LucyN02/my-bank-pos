package br.com.bank.service.external;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@Data
public class ValidRequestCard {

    public String message;

    @Bean
    public String message() {
        return this.message;
    }
}
