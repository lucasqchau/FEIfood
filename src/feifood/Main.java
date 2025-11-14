package feifood;

import View.Login;

/**
 * Classe principal do sistema FEIfood.
 * Responsável por iniciar a aplicação exibindo a tela de Login.
 * Também define constantes globais utilizadas por outras partes do sistema,
 * como a taxa adicional aplicada a bebidas alcoólicas.
 *
 * author uniflchau
 */
public class Main {

    /**
     * Taxa aplicada sobre o preço de bebidas alcoólicas.
     * Valor padrão: 1.15 (correspondente a 15% de acréscimo).
     */
    public static final double taxaAlcool = 1.15;

    /**
     * Método principal que inicializa a aplicação FEIfood.
     * Exibe a tela de login para que o usuário possa acessar o sistema.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        Login tela1 = new Login();
        tela1.setVisible(true);
    }
}
