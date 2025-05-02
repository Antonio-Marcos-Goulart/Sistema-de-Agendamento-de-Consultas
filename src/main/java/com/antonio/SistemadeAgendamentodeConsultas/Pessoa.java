package com.antonio.SistemadeAgendamentodeConsultas;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public abstract class Pessoa {

    protected int id;
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected LocalDate dataNascimento;
    protected String endereco;
    protected byte statusCadastro;
    public DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String cpf, String telefone, LocalDate dataNascimento, String endereco, byte statusCadastro, DateTimeFormatter dataFormatada) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.statusCadastro = 1;
        this.dataFormatada = dataFormatada;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nCPF: " + cpf +
                "\nTelefone: " + telefone +
                "\nData de nascimento: " + dataNascimento.format(dataFormatada) +
                "\nEndereço: " + endereco +
                "\nStatus: " + (statusCadastro == 1 ? "Ativo" : "Inativo"); // Usa o operador ternário para exibir "Ativo" se o status for 1, ou "Inativo" se for diferente

    }
}
