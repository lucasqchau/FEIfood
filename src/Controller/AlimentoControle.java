/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.AlimentoDAO;
import Model.Alimento;
import java.util.List;

/**
 *
 * @author rchau
 */
public class AlimentoControle {
    /**
     * Busca todos os alimentos cadastrados.
     * Esse método simplesmente delega a chamada para o AlimentoDAO.listar().
     */
    public List<Alimento> buscarTodos() {
        AlimentoDAO dao = new AlimentoDAO();// Cria uma instância do DAO
        return dao.listar();// Chama o método que lista todos os itens
    }
    /**
     * Busca alimentos filtrando por descrição e tipo.
     * Esse método é usado, por exemplo, na tela de Pedido para filtrar
     * a tabela conforme o usuário digita um texto e/ou escolhe um tipo.
     */
    public List<Alimento> buscar(String descricao, String tipo) {
        AlimentoDAO dao = new AlimentoDAO();// Cria a instância do DAO
        return dao.buscar(descricao, tipo);// Delegação da busca para o DAO
    }
}

