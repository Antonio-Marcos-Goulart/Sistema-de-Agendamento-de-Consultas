package com.antonio.SistemadeAgendamentodeConsultas.repository;

import com.antonio.SistemadeAgendamentodeConsultas.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
}
