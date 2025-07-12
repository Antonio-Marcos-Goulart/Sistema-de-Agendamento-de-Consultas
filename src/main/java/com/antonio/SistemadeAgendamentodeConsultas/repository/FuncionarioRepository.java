package com.antonio.SistemadeAgendamentodeConsultas.repository;

import com.antonio.SistemadeAgendamentodeConsultas.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository <Funcionario, Long> {
    List<Funcionario> findByCpfContainingIgnoreCase(String cpf);
    List<Funcionario> findByNomeContainingIgnoreCase(String nome);
    Optional<Funcionario> findById(Long id);
}
