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
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String document;
    private int request;
}
