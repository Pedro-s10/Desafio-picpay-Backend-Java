package com.picpaysimplificado.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;

@Entity(name = "users") // Representar uma entidade na minha tabela no banco de dados.
@Table(name = "users") // Qual o nome da tabela que essa entidade está representando.
@Getter
@Setter
@AllArgsConstructor // Criar um construtor que receba todos o parametros da classe.
@EqualsAndHashCode(of = "id") // Chave primaria desta entidade/tabela.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Forma como vai ser gerado os ID's nesse caso vai ser gerado de forma "Increment" (Não é a forma mas segura)
    private Long id;

    private String firstName;

    private String lastName;

    @Column(unique = true) // Anotação para dizer que esse dado é unico.
    private String document;

    @Column(unique = true) // Anotação para dizer que esse dado é unico.
    private String email;

    private String password;

    private BigDecimal balance; // Saldo do usuário.

    @Enumerated(EnumType.STRING)
    private UserType userType;
}
