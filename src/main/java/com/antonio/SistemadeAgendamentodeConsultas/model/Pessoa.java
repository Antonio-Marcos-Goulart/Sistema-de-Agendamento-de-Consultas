package com.antonio.SistemadeAgendamentodeConsultas.model;

import com.antonio.SistemadeAgendamentodeConsultas.enums.SituacaoAgendamento;
import com.antonio.SistemadeAgendamentodeConsultas.enums.SituacaoCadastro;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public abstract class Pessoa { 

    @NotBlank(message = "Nome não pode ser vazio")
    @Column(name = "nome", nullable = false, length = 200)
    protected String nome;

    @NotBlank(message = "CPF não pode ser vazio")
   // @CPF(message = "CPF inválido") // validar cpf com probelma
    @Column(name = "cpf", nullable = false, unique = true, length = 11)
    protected String cpf;

    @NotBlank(message = "Telefone não pode ser vazio")
    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter 10 ou 11 dígitos")
    @Column(name = "telefone", nullable = true, length = 11)
    protected String telefone;

    @Email(message = "E-mail inválido") // Valida formato de e-mail
    @Column(name = "email", nullable = false, unique = true)
    protected String email;

    @NotNull(message = "Data de nascimento é obrigatória")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @PastOrPresent(message = "Data de nascimento deve ser no passado ou presente")
    @Column(name = "data_nascimento", nullable = false)
    protected LocalDate dataNascimento;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "data_cadastro", nullable = false, updatable = false) // updatable = false: não poderá ser alterada após inserção
    protected LocalDate dataDeCadastro = LocalDate.now();

    @NotNull(message = "Status do cadastro não pode ser nulo")
    @Enumerated(EnumType.STRING) // @Enumerated(EnumType.STRING) = armazena o nome do enum como string no banco de dados
    @Column(name = "status_cadastro", nullable = false)
    private SituacaoCadastro situacaoCadastro;

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo");
        }
        if (nome.length() > 150) { // Limite arbitrário, ajuste conforme necessidade
            throw new IllegalArgumentException("Nome não pode ter mais que 150 caracteres");
        }
        if (!nome.matches("[a-zA-ZÀ-ÿ\\s.-]+")) { // Permite letras, espaços, pontos e hífens

            throw new IllegalArgumentException("Nome contém caractere inválido. Permitido apenas letras, espaços, pontos e hífens.");
        }
        this.nome = nome.trim();
    }

    public void setCpf(String cpf) {
        if (cpf == null || !cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter exatamente 11 dígitos numéricos");
        }
        this.cpf = cpf;
    }

    public void setTelefone(String telefone) {
        if (telefone == null || !telefone.matches("\\d{10,11}")) {
            throw new IllegalArgumentException("Telefone deve conter 10 ou 11 dígitos");
        }
        this.telefone = telefone;
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

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida");
        }
        this.dataNascimento = dataNascimento;
    }

//    public void setDataDeCadastro(LocalDate dataDeCadastro) {
//        if (dataDeCadastro == null || dataDeCadastro.isAfter(LocalDate.now())) {
//            throw new IllegalArgumentException("Data de cadastro inválida");
//        }
//        this.dataDeCadastro = dataDeCadastro;
//    }

    @Embedded
    private Endereco endereco;

    public void setEndereco(Endereco endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("Endereço não pode ser vazio");
        }
        this.endereco = endereco;
    }
}

