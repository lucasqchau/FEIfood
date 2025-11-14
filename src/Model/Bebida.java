/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rchau
 */
public class Bebida extends Alimento {
    // Indica se a bebida é alcoólica (true) ou não (false)
    private final boolean alcoolica;

    public Bebida(String descricao, double preco, boolean alcoolica) {
        super(); // chama o construtor vazio de Alimento
        // Preenche os atributos herdados de Alimento
        this.setDescItem(descricao);// Define a descrição da bebida
        this.setTipoItem("Bebida");// Define a descrição da bebida
        this.setPrecoItem(preco);// Define o preço base da bebida
        // Define se a bebida é alcoólica ou não (atributo próprio da classe Bebida)
        this.alcoolica = alcoolica;
    }

    public boolean isAlcoolica() {
        return alcoolica;
    }

    /**
     * Retorna o preço final da bebida.
     * Regra de negócio:
     * - Se a bebida for alcoólica, aplica 15% de imposto sobre o preço base.
     * - Se não for alcoólica, retorna apenas o preço base.
     */
    @Override
    public double getPrecoFinal() {
        double base = getPrecoItem();// preço base herdado de Alimento
        // 15% de imposto somente se for alcoólica
        return alcoolica ? base * 1.15 : base;
    }
}
