package com.antonio.SistemadeAgendamentodeConsultas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

@MappedSuperclass
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id automatico
    @Column(name = "id")
    protected int id;

    @NotBlank(message = "Nome não pode ser vazio") // Valida que o campo não é nulo ou vazio
    @Column(name = "nome", nullable = false, length = 200) // Mapeia a coluna no banco
    protected String nome;

    @NotBlank(message = "CPF não pode ser vazio")
    @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    protected String cpf;

    @NotBlank(message = "Telefone não pode ser vazio")
    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter 10 ou 11 dígitos")
    @Column(name = "telefone", nullable = false, length = 11)
    protected String telefone;

    @Email(message = "E-mail inválido") // Valida formato de e-mail
    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @NotNull(message = "Data de nascimento é obrigatória")
    @Column(name = "data_nascimento", nullable = false)
    protected LocalDate dataNascimento;

    @NotNull(message = "Data de cadastro é obrigatória")
    @Column(name = "data_cadastro", nullable = false, updatable = false)
    // updatable = false: não poderá ser alterada após inserção
    protected LocalDate dataDeCadastro;

    @NotBlank(message = "Endereço não pode ser vazio")
    @Column(name = "endereco", nullable = false, length = 255)
    protected String endereco;

    @Column(name = "status_cadastro", nullable = false)
    protected byte statusCadastro;

    public Pessoa(int id, String nome, String cpf, String telefone, String email, LocalDate dataNascimento, LocalDate dataDeCadastro, String endereco, byte statusCadastro) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.dataDeCadastro = dataDeCadastro;
        this.endereco = endereco;
        this.statusCadastro = statusCadastro;
    }

    public Pessoa() {
        this.dataDeCadastro = LocalDate.now();
        this.statusCadastro = 1; // padrão, cadastro ativo
    }

    // Getters e Setters com validação simples
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo");
        }

        if (nome.length() > 255) { // Limite arbitrário, ajuste conforme necessidade
            throw new IllegalArgumentException("Nome não pode ter mais que 255 caracteres");
        }
        // Verificar se contém apenas caracteres válidos
        if (!nome.matches("[a-zA-ZÀ-ÿ\\s.-]+")) {
            throw new IllegalArgumentException("Nome contém caractere inválido. Permitido apenas letras, espaços, pontos e hífens.");
        }
        this.nome = nome.trim();
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos");
        }
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || !telefone.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("Telefone deve conter 10 ou 11 dígitos");
        }
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            this.email = null; // se nada for adicionado, fica null no banco
            return;
        }

        if (!email.matches("^\\S+@\\S+\\.\\S+$")) {
            throw new IllegalArgumentException("E-mail inválido");
        }

        this.email = email.trim();
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(LocalDate dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio");
        }
        this.endereco = endereco.trim();
    }

    public byte getStatusCadastro() {
        return statusCadastro;
    }

    public void setStatusCadastro(byte statusCadastro) {
        this.statusCadastro = statusCadastro;
    }
}

