//Classe responsavel por fazer de fato as querys no nosso banco de dados

package com.picpaysimplificado.repositories;

import com.picpaysimplificado.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//JpaRepositoy recebe dois tipos, o primeiro é a entidade(A tabela que irá ser manipulada) e o segundo tipo é o tipo da chave primaria da tabela(Neste caso é um Long).
public interface UserRepository extends JpaRepository<User, Long> {
    // Declarando o metodo que vai buscar os usuarios pelo documento.
    Optional<User> findUserByDocument(String document); // Esse Optional<User> é o retorno (Podendo ou não retornar um usuario)
    Optional<User> findUserById(Long id);
}
