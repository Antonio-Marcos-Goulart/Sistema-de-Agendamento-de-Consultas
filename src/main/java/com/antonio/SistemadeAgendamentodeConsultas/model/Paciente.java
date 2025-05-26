package com.antonio.SistemadeAgendamentodeConsultas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "paciente")
public class Paciente extends Pessoa{

    @Column(name = "prontuario", nullable = false, unique = true)
    private String prontuario;

    public Paciente() {
        super();
    }

    public Paciente(int id, String nome, String cpf, String telefone, String email, LocalDate dataNascimento, LocalDate dataDeCadastro, String endereco, byte statusCadastro, String prontuario) {
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
