/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.Alimento;
import static feifood.Main.taxaAlcool;
/**
 *
 * @author rchau
 */
public class PedidoControle {
    // Lista estática que armazena todos os itens do pedido (carrinho)
    private static List<Alimento> itensPedido = new ArrayList<>();
    
    /**
     * Adiciona um item (Alimento) ao pedido.
     *
     * Regras atuais:
     * - Se o item for do tipo "Bebida Alcoólica", aplica uma taxa extra
     *   multiplicando o preço pela constante taxaAlcool (vinda de feifood.Main).
     */
    public static void adicionarItem(Alimento alimento) {
        // Aplica taxa apenas para as bebidas alcoolicas
        if (alimento.getTipoItem().equals("Bebida Alcoólica")) {
            // Atualiza o preço do item, multiplicando pela taxa de álcool
            alimento.setPrecoItem(alimento.getPrecoItem() * taxaAlcool);
        }
        // Adiciona o item (já ajustado, se for o caso) na lista do pedido
        itensPedido.add(alimento);
    }
    //Retorna a lista de itens do pedido.
    public static List<Alimento> getItensPedido() {
        return itensPedido;
    }

     public static void removerItem(int index) {
        // Verifica se o índice é válido antes de tentar remover
        if (index >= 0 && index < itensPedido.size()) {
            itensPedido.remove(index);
        }
    }
     
    /**
     * Calcula o total do pedido.
     * Soma o preço base de cada item (getPrecoItem()).
     */
    public static double calcularTotal() {
        double total = 0.0;
        for (Alimento a : itensPedido) {
            total += a.getPrecoItem();
        }
        return total;
    }
}
