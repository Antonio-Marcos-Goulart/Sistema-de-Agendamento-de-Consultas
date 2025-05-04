package com.antonio.SistemadeAgendamentodeConsultas;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class Paciente extends Pessoa{

    private String convenio;
    private Boolean usoMedicacaoContinua;
    private String problemaDeSaude;

    public Paciente(int id, String nome, String cpf, String telefone, LocalDate dataNascimento, LocalDate dataDeCadastro, String endereco, byte statusCadastro, DateTimeFormatter dataFormatada, DateTimeFormatter dataFormatadaComHora, String convenio, Boolean usoMedicacaoContinua, String problemaDeSaude) {
        super(id, nome, cpf, telefone, dataNascimento, dataDeCadastro, endereco, statusCadastro, dataFormatada, dataFormatadaComHora);
        this.convenio = convenio;
        this.usoMedicacaoContinua = usoMedicacaoContinua;
        this.problemaDeSaude = problemaDeSaude;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Boolean getUsoMedicacaoContinua() {
        return usoMedicacaoContinua;
    }

    public void setUsoMedicacaoContinua(Boolean usoMedicacaoContinua) {
        this.usoMedicacaoContinua = usoMedicacaoContinua;
    }

    public String getProblemaDeSaude() {
        return problemaDeSaude;
    }

    public void setProblemaDeSaude(String problemaDeSaude) {
        this.problemaDeSaude = problemaDeSaude;
    }
}
