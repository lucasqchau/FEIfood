package Controller;

import java.util.ArrayList;
import java.util.List;
import Model.Alimento;
import static feifood.Main.taxaAlcool;

/**
 * Controlador responsável por gerenciar os itens do pedido (carrinho).
 * Permite adicionar, remover e calcular o total dos itens selecionados pelo usuário.
 * 
 * Os itens são armazenados em uma lista estática, simulando um carrinho de compras
 * compartilhado pela aplicação.
 * 
 * @author rchau
 */
public class PedidoControle {

    /** Lista estática que armazena todos os itens do pedido (carrinho). */
    private static List<Alimento> itensPedido = new ArrayList<>();

    /**
     * Adiciona um item (Alimento) ao pedido.
     *
     * Regras:
     * - Se o item for do tipo "Bebida Alcoólica", aplica uma taxa extra
     *   multiplicando o preço pela constante taxaAlcool (vinda de feifood.Main).
     *
     * @param alimento item que será adicionado ao pedido
     */
    public static void adicionarItem(Alimento alimento) {
        if (alimento.getTipoItem().equals("Bebida Alcoólica")) {
            alimento.setPrecoItem(alimento.getPrecoItem() * taxaAlcool);
        }
        itensPedido.add(alimento);
    }

    /**
     * Retorna a lista atual de itens do pedido.
     *
     * @return lista de objetos Alimento presentes no pedido
     */
    public static List<Alimento> getItensPedido() {
        return itensPedido;
    }

    /**
     * Remove um item do pedido com base no índice fornecido.
     * Caso o índice seja inválido, nada é removido.
     *
     * @param index posição do item a ser removido na lista
     */
    public static void removerItem(int index) {
        if (index >= 0 && index < itensPedido.size()) {
            itensPedido.remove(index);
        }
    }

    /**
     * Calcula o valor total do pedido somando os preços dos itens.
     *
     * @return total acumulado dos preços dos itens do pedido
     */
    public static double calcularTotal() {
        double total = 0.0;
        for (Alimento a : itensPedido) {
            total += a.getPrecoItem();
        }
        return total;
    }
}
