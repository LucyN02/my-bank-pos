package br.com.bank.model;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@Table(name = "tb_customers")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String band;
    private String name;
    private int limits;
}
