/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:postgresql://localhost:5432/FEIfood";
    private static final String USER = "postgres";
    private static final String PASSWORD = "2729112a";

    // Método de instância (mantido)
    public Connection getConnection() throws SQLException {
        Connection conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Conexao: " + conexao);
        return conexao;
    }

    // ✅ Novo método estático (igual ao segundo código)
    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conectado ao PostgreSQL!");
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
}
