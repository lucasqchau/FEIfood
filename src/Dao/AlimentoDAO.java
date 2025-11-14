package Dao;

import Model.Alimento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO responsável por acessar a tabela de itens de alimento no banco de dados.
 * Permite listar todos os itens cadastrados e buscar alimentos por filtros de
 * descrição e tipo.
 * 
 * Utiliza a classe Conexao para estabelecer a conexão com o banco.
 * 
 * @author rchau
 */
public class AlimentoDAO {

    /**
     * Lista todos os alimentos cadastrados na tabela tb_itens.
     *
     * @return lista de objetos Alimento encontrados no banco de dados.
     */
    public List<Alimento> listar() {
        List<Alimento> lista = new ArrayList<>();
        String sql = 
             "SELECT id_itens, desc_item, tipo_item, preco_item FROM tb_itens";

        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Alimento alimento = new Alimento();
                alimento.setIdItens(rs.getInt("id_itens"));
                alimento.setDescItem(rs.getString("desc_item"));
                alimento.setTipoItem(rs.getString("tipo_item"));
                alimento.setPrecoItem(rs.getDouble("preco_item"));
                lista.add(alimento);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar itens: " + e.getMessage());
        }

        return lista;
    }

    /**
     * Busca alimentos filtrando por descrição e tipo.
     *
     * @param descricao texto que será filtrado no campo desc_item (pode ser parcial)
     * @param tipo tipo específico de item a ser filtrado; caso seja "Todos",
     *             nenhum filtro de tipo será aplicado
     *
     * @return lista de alimentos encontrados com base nos filtros informados.
     */
    public List<Alimento> buscar(String descricao, String tipo) {

        List<Alimento> lista = new ArrayList<>();

        StringBuilder sql = new StringBuilder(
            "SELECT id_itens, desc_item, tipo_item, preco_item FROM tb_itens WHERE 1=1"
        );

        if (descricao != null && !descricao.isEmpty()) {
            sql.append(" AND LOWER(desc_item) LIKE LOWER(?)");
        }

        if (tipo != null && !tipo.equals("Todos")) {
            sql.append(" AND tipo_item = ?");
        }

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            int index = 1;

            if (descricao != null && !descricao.isEmpty()) {
                stmt.setString(index++, "%" + descricao + "%");
            }

            if (tipo != null && !tipo.equals("Todos")) {
                stmt.setString(index++, tipo);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Alimento alimento = new Alimento();
                alimento.setIdItens(rs.getInt("id_itens"));
                alimento.setDescItem(rs.getString("desc_item"));
                alimento.setTipoItem(rs.getString("tipo_item"));
                alimento.setPrecoItem(rs.getDouble("preco_item"));
                lista.add(alimento);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao buscar itens: " + e.getMessage());
        }

        return lista;
    }
}
