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

    //Lista todos os alimentos cadastrados na tabela tb_itens.
    public List<Alimento> listar() {
        // Lista que será retornada com os resultados da consulta
        List<Alimento> lista = new ArrayList<>();
        // Comando SQL para buscar todos os itens
        String sql = 
             "SELECT id_itens, desc_item, tipo_item, preco_item FROM tb_itens";
        
        // try-with-resources: garante que Connection, PreparedStatement e ResultSet
        // serão fechados automaticamente ao final do bloco
        try (Connection conn = Conexao.conectar();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            // Percorre cada linha retornada pela consulta
            while (rs.next()) {
                Alimento alimento = new Alimento();
                alimento.setIdItens(rs.getInt("id_itens"));// ID do item
                alimento.setDescItem(rs.getString("desc_item"));// Descrição
                alimento.setTipoItem(rs.getString("tipo_item"));// Tipo (Comida/Bebida etc.)
                alimento.setPrecoItem(rs.getDouble("preco_item"));// Preço base
                lista.add(alimento);// Adiciona na lista
            }

        } catch (SQLException e) {
            // Em caso de erro, imprime mensagem no console
            System.err.println("Erro ao listar itens: " + e.getMessage());
        }
        // Retorna a lista (pode estar vazia se não houver itens ou se falhar)
        return lista;
    }

    //Busca alimentos filtrando por descrição e tipo.
    public List<Alimento> buscar(String descricao, String tipo) {
        List<Alimento> lista = new ArrayList<>();
        // Monta o SQL de forma dinâmica, começando com uma condição sempre verdadeira (1=1)
        StringBuilder sql = new StringBuilder
        ("SELECT id_itens, desc_item, tipo_item, preco_item FROM tb_itens "
                + "WHERE 1=1");

        // Se foi informada uma descrição, adiciona filtro com LIKE
        if (descricao != null && !descricao.isEmpty()) {
            sql.append(" AND LOWER(desc_item) LIKE LOWER(?)");
        }
        // Se foi informado um tipo diferente de "Todos", adiciona filtro de tipo
        if (tipo != null && !tipo.equals("Todos")) {
            sql.append(" AND tipo_item = ?");
        }

        // try-with-resources para garantir fechamento de recursos    
        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql.toString())) {

            int index = 1;// Índice para preencher os parâmetros do PreparedStatement

            // Se tiver descrição, preenche o primeiro parâmetro com o texto usando LIKE
            if (descricao != null && !descricao.isEmpty()) {
                stmt.setString(index++, "%" + descricao + "%");
            }
            // Se tiver tipo específico (diferente de "Todos"), preenche o próximo parâmetro
            if (tipo != null && !tipo.equals("Todos")) {
                stmt.setString(index++, tipo);
            }
            // Executa a consulta
            ResultSet rs = stmt.executeQuery();

            // Monta a lista de resultados
            while (rs.next()) {
                Alimento alimento = new Alimento();
                alimento.setIdItens(rs.getInt("id_itens"));
                alimento.setDescItem(rs.getString("desc_item"));
                alimento.setTipoItem(rs.getString("tipo_item"));
                alimento.setPrecoItem(rs.getDouble("preco_item"));
                lista.add(alimento);
            }

        } catch (SQLException e) {
            // Em caso de erro, exibe mensagem no console
            System.err.println("Erro ao buscar itens: " + e.getMessage());
        }

        return lista;
    }
}

