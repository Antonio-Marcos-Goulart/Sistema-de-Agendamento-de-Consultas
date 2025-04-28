package com.antonio.SistemadeAgendamentodeConsultas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {

    public DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    protected String nome;
    protected byte status;
    protected LocalDate dataCadastro;

    public Pessoa(byte status, LocalDate dataCadastro) {
        this.status = 1;
        this.dataCadastro = LocalDate.now();
    }

    public Pessoa(String nome, byte status, LocalDate dataCadastro) {
        this.nome = nome;
        this.status = 1;
        this.dataCadastro = LocalDate.now();
    }

    @Override
    public String toString(){
        return "Nome: " + nome +"\nData de cadastro: " + dataCadastro;
    }

    public DateTimeFormatter getDataFormatada() {
        return dataFormatada;
    }

    public void setDataFormatada(DateTimeFormatter dataFormatada) {
        this.dataFormatada = dataFormatada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}
