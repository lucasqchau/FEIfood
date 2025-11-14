/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author rchau
 */
public class Alimento {
    private int idItens;
    private String descItem;
    private String tipoItem;
    private double precoItem;

    //Getters e Setters
    public int getIdItens() {
        return idItens;
    }

    public void setIdItens(int idItens) {
        this.idItens = idItens;
    }

    public String getDescItem() {
        return descItem;
    }

    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    public double getPrecoItem() {
        return precoItem;
    }

    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    /**
     * Retorna o preço final do item.
     * Implementação padrão: retorna apenas o preço base (sem nenhuma regra extra).
     * Subclasses (como Bebida, por exemplo) podem sobrescrever este método
     * para aplicar impostos, taxas ou descontos específicos.
     */
    public double getPrecoFinal() {
        return getPrecoItem();
    }
}
