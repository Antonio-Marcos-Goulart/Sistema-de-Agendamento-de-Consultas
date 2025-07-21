package com.antonio.SistemadeAgendamentodeConsultas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "paciente", schema = "agendamento")
public class Paciente extends Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O prontuário é obrigatório")
    @Column(name = "prontuario", nullable = false, unique = true)
    private String prontuario;

    @NotNull(message = "Data da consulta é obrigatório")
    @FutureOrPresent(message = "A data da consulta deve ser hoje ou futura")
    @Column(name = "data_consulta", nullable = false)
    private LocalDate dataConsulta;

    public Paciente() {
        super();
    }

    public Paciente(Long id, String nome, String cpf, String telefone, String email, LocalDate dataNascimento,
                    LocalDate dataDeCadastro, Endereco endereco, byte statusCadastro, String prontuario,
                    LocalDate dataConsulta) {
        super(nome, cpf, telefone, email, dataNascimento, dataDeCadastro, endereco, statusCadastro);
        this.id = id;
        this.prontuario = prontuario;
        this.dataConsulta = dataConsulta;
    }

}
