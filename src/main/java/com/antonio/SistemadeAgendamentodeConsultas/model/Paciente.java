package com.antonio.SistemadeAgendamentodeConsultas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table(name = "paciente")
public class Paciente extends Pessoa{

    @NotBlank(message = "O prontuário é obrigatório")
    @Column(name = "prontuario", nullable = false, unique = true)
    private String prontuario;

    public Paciente() {
        super();
    }

    public Paciente(Long id, String nome, String cpf, String telefone, String email, LocalDate dataNascimento, LocalDate dataDeCadastro, String endereco, byte statusCadastro, String prontuario) {
        super(id, nome, cpf, telefone, email, dataNascimento, dataDeCadastro, endereco, statusCadastro);
        this.prontuario = prontuario;
    }

    public String getProntuario() {
        return prontuario;
    }

    public void setProntuario(String prontuario) {
        if (prontuario == null || prontuario.trim().isEmpty()){
            throw new IllegalArgumentException("Prontuário não pode ser vazio ou nulo");
        }
        this.prontuario = prontuario;
    }
}
