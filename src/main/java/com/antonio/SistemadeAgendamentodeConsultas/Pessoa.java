package com.antonio.SistemadeAgendamentodeConsultas;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {

    protected int id;
    protected String nome;
    protected String cpf;
    protected String telefone;
    protected LocalDate dataNascimento;
    protected LocalDate dataDeCadastro;
    protected String endereco;
    protected byte statusCadastro;
    public DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public DateTimeFormatter dataFormatadaComHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String cpf, String telefone, LocalDate dataNascimento, LocalDate dataDeCadastro, String endereco, byte statusCadastro, DateTimeFormatter dataFormatada, DateTimeFormatter dataFormatadaComHora) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.dataDeCadastro = dataDeCadastro;
        this.endereco = endereco;
        this.statusCadastro = statusCadastro;
        this.dataFormatada = dataFormatada;
        this.dataFormatadaComHora = dataFormatadaComHora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        if (!dataDeCadastro.equals(LocalDate.now())){
            throw new IllegalArgumentException("Data inválida!");
        }
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public byte getStatusCadastro() {
        return statusCadastro;
    }

    public void setStatusCadastro(byte statusCadastro) {
        if (String.valueOf(statusCadastro).matches("[0-1]")){
            throw new IllegalArgumentException("Valor não permitido: " + statusCadastro);
        }
        this.statusCadastro = statusCadastro;
    }


    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nCPF: " + cpf +
                "\nTelefone: " + telefone +
                "\nData de nascimento: " + dataNascimento.format(dataFormatada) +
                "\nEndereço: " + endereco +
                "\nData de cadastro: " + dataDeCadastro.format(dataFormatadaComHora) +
                "\nStatus: " + (statusCadastro == 1 ? "Ativo" : "Inativo"); // Usa o operador ternário para exibir "Ativo" se o status for 1, ou "Inativo" se for diferente
    }
}
