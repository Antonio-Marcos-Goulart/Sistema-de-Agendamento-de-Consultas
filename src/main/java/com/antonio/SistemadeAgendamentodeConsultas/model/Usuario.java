package com.antonio.SistemadeAgendamentodeConsultas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "usuarios") // Nome da tabela no banco
@Data // Lombok para getters, setters, toString etc.
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private String senha;

//    // Método para criptografar a senha antes de salvar no banco
//    public void setSenha(String senha) {
//        this.senha = new BCryptPasswordEncoder().encode(senha);
//    }
//
//    // Método para verificar a senha durante o login (não armazena senha, apenas valida)
//    public boolean validarSenha(String senha) {
//        return new BCryptPasswordEncoder().matches(senha, this.senha);
//    }
}