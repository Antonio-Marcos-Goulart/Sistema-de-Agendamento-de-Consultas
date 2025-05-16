package com.antonio.SistemadeAgendamentodeConsultas.conexaoBancoDeDados;

import java.sql.Connection;
import java.sql.SQLException;

public class ClassTesteConexao {
    public static void main(String[] args) {
        try {
            Connection conn = ConexaoBanco.conectar();
            if (conn != null){
                System.out.println("Conectado ao banco de dados!");
            }
        }catch (SQLException e){
            System.out.println("Falha na conexão: " + e.getMessage());
        }
    }
}
