package com.antonio.SistemadeAgendamentodeConsultas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "paciente", schema = "agendamento")
public class Paciente extends Pessoa{

    @NotBlank(message = "O prontuário é obrigatório")
    @Column(name = "prontuario", nullable = false, unique = true)
    private String prontuario;

    @FutureOrPresent(message = "A data da consulta deve ser hoje ou futura")
    @NotNull(message = "Data da consulta é obrigatório")
    @Column(name = "data_consulta", nullable = false)
    private LocalDate dataConsulta;

    public Paciente() {
        super();
    }

    public Paciente(Long id, String nome, String cpf, String telefone, String email, LocalDate dataNascimento, LocalDate dataDeCadastro, String endereco, byte statusCadastro, String prontuario, LocalDate dataConsulta) {
        super(id, nome, cpf, telefone, email, dataNascimento, dataDeCadastro, endereco, statusCadastro);
        this.prontuario = prontuario;
        this.dataConsulta = dataConsulta;
    }

    public String getProntuario() {
        return prontuario;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public void setProntuario(String prontuario) {
        this.prontuario = prontuario;
    }
}
