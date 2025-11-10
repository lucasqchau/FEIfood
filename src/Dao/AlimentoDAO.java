/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import Model.Alimento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rchau
 */
public class AlimentoDAO {
    public List<Alimento> listar() {
        List<Alimento> lista = new ArrayList<>();
        String sql = "SELECT id_itens, desc_item, tipo_item, preco_item FROM tb_itens";

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

    // 🔹 BUSCAR POR DESCRIÇÃO E TIPO
    public List<Alimento> buscar(String descricao, String tipo) {
        List<Alimento> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT id_itens, desc_item, tipo_item, preco_item FROM tb_itens WHERE 1=1");

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

