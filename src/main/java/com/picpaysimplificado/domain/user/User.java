package com.picpaysimplificado.domain.user;

import com.picpaysimplificado.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;


import java.math.BigDecimal;

@Entity(name = "users") // Representar uma entidade na minha tabela no banco de dados.
@Table(name = "users") // Qual o nome da tabela que essa entidade está representando.
@Getter
@Setter
@NoArgsConstructor
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

    public User(UserDTO data){
        this.firstName = data.firstName();
        this.lastName = data.lastName();
        this.balance = data.balance();
        this.userType = data.userType();
        this.password = data.password();
        this.document = data.document();
        this.email = data.email();
    }
}
