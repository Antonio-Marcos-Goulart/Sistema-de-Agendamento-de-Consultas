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
    protected String email;
    protected LocalDate dataNascimento;
    protected LocalDate dataDeCadastro;
    protected String endereco;
    protected byte statusCadastro;


    public DateTimeFormatter dataFormatada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public DateTimeFormatter dataFormatadaComHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Pessoa() {
    }

    public Pessoa(int id, String nome, String cpf, String telefone, String email, LocalDate dataNascimento, LocalDate dataDeCadastro, String endereco, byte statusCadastro, DateTimeFormatter dataFormatada, DateTimeFormatter dataFormatadaComHora) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.dataDeCadastro = LocalDate.now();
        this.endereco = endereco;
        this.statusCadastro = 1;
        this.dataFormatada = dataFormatada;
        this.dataFormatadaComHora = dataFormatadaComHora;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().length() < 2) {
            throw new IllegalArgumentException("Nome inválido. Deve ter pelo menos 2 caracteres."); // Garante que o nome não seja null ou menor que 2 letras
        }
        this.nome = nome.trim();
    }

    public void setCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF inválido. Deve conter 11 dígitos numéricos."); // Valida se o CPF tem exatamente 11 números
        }
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || !telefone.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("Telefone inválido. Deve conter 10 ou 11 dígitos."); // Aceita telefones com ou sem DDD
        }
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[\\w\\.-]+@[\\w\\.-]+\\.\\w{2,}$")) {
            throw new IllegalArgumentException("Email inválido."); //Verifica se o email possui um formato válido com @ e domínio
        }
        this.email = email;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }
        this.dataNascimento = dataNascimento;
    }

    public abstract String getDataCadastro();

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        if (dataDeCadastro == null || dataDeCadastro.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data inválida!"); // Garante que a data seja a atual
        }
        this.dataDeCadastro = dataDeCadastro;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio."); // Evita endereço nulo ou em branco
        }
        this.endereco = endereco.trim();
    }

    public byte getStatus() {
        return 1;
    }

    public void setStatusCadastro(byte statusCadastro) {
        if (statusCadastro != 0 && statusCadastro != 1) {
            throw new IllegalArgumentException("Status de cadastro deve ser 0 (inativo) ou 1 (ativo)."); // Só permite 0 ou 1
        }
        this.statusCadastro = statusCadastro;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nNome: " + nome +
                "\nCPF: " + cpf +
                "\nTelefone: " + telefone +
                "\nE-mail: " + email +
                "\nData de nascimento: " + dataNascimento.format(dataFormatada) +
                "\nEndereço: " + endereco +
                "\nData de cadastro: " + dataDeCadastro.format(dataFormatadaComHora) +
                "\nStatus: " + (statusCadastro == 1 ? "Ativo" : "Inativo"); // Usa o operador ternário para exibir "Ativo" se o status for 1, ou "Inativo" se for diferente
    }
}
