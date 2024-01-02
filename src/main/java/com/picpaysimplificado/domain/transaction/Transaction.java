package com.picpaysimplificado.domain.transaction;

import com.picpaysimplificado.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne // Anotação para dizer que um usuario podem ter várias transações más uma transação so pode estar vinculada a um sender e a um receiver (Relação muitos para um).
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne // Anotação para dizer que um usuario podem ter várias transações más uma transação so pode estar vinculada a um sender e a um receiver (Relação muitos para um).
    @JoinColumn(name = "receiver_id")
    private User receiver;

    private LocalDateTime timestamp;

}
