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
    public List<Alimento> buscarTodos() {
        AlimentoDAO dao = new AlimentoDAO();
        return dao.listar();
    }
    public List<Alimento> buscar(String descricao, String tipo) {
        AlimentoDAO dao = new AlimentoDAO();
        return dao.buscar(descricao, tipo);
    }
}

