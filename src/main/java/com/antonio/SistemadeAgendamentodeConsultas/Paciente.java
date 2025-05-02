package com.antonio.SistemadeAgendamentodeConsultas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Paciente extends Pessoa{

    private String convenio;
    private Boolean usoMedicacaoContinua;
    private String problemaDeSaude;

    public Paciente(int id, String nome, String cpf, String telefone, LocalDate dataNascimento, String endereco, byte statusCadastro, DateTimeFormatter dataFormatada, String convenio, Boolean usoMedicacaoContinua, String problemaDeSaude) {
        super(id, nome, cpf, telefone, dataNascimento, endereco, statusCadastro, dataFormatada);
        this.convenio = convenio;
        this.usoMedicacaoContinua = usoMedicacaoContinua;
        this.problemaDeSaude = problemaDeSaude;
    }
}
