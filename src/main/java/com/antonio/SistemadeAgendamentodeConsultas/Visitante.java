package com.antonio.SistemadeAgendamentodeConsultas;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Visitante extends Pessoa{
    private String motivoDaVisita;
    private LocalDate dataDaVisita;

    public Visitante(int id, String nome, String cpf, String telefone, LocalDate dataNascimento, LocalDate dataDeCadastro, String endereco, byte statusCadastro, DateTimeFormatter dataFormatada, DateTimeFormatter dataFormatadaComHora, String motivoDaVisita, LocalDate dataDaVisita) {
        super(id, nome, cpf, telefone, dataNascimento, dataDeCadastro, endereco, statusCadastro, dataFormatada, dataFormatadaComHora);
        this.motivoDaVisita = motivoDaVisita;
        this.dataDaVisita = dataDaVisita;
    }

    public String getMotivoDaVisita() {
        return motivoDaVisita;
    }

    public void setMotivoDaVisita(String motivoDaVisita) {
        this.motivoDaVisita = motivoDaVisita;
    }

    public LocalDate getDataDaVisita() {
        return dataDaVisita;
    }

    public void setDataDaVisita(LocalDate dataDaVisita) {
        this.dataDaVisita = dataDaVisita;
    }
}
