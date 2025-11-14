package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados PostgreSQL.
 * Realiza a conexão via JDBC e retorna um objeto Connection para uso nos DAOs.
 * 
 * Faz parte da camada de acesso a dados (DAO).
 * 
 * author uniflchau
 */
public class Conexao {

    /** URL de conexão com o banco PostgreSQL. */
    private static final String URL = "jdbc:postgresql://localhost:5432/FEIfood";

    /** Usuário do banco de dados. */
    private static final String USER = "postgres";

    /** Senha do usuário do banco de dados. */
    private static final String PASSWORD = "2729112a";

    /**
     * Realiza a conexão com o banco de dados PostgreSQL.
     *
     * @return uma Connection aberta caso a conexão seja bem-sucedida,
     *         ou null caso ocorra erro.
     */
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
