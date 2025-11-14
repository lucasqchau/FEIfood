package Model;

/**
 * Classe que representa um item de alimento presente no sistema.
 * Cada alimento possui um ID, descrição, tipo (como comida, bebida, etc.)
 * e um preço base. A classe também fornece um método para recuperar o preço
 * final, permitindo que subclasses sobrescrevam a lógica conforme necessário.
 * 
 * author rchau
 */
public class Alimento {

    /** Identificador único do item no banco. */
    private int idItens;

    /** Descrição do item (nome, título, etc.). */
    private String descItem;

    /** Tipo do item (ex.: Comida, Bebida, Bebida Alcoólica, etc.). */
    private String tipoItem;

    /** Preço base do item. */
    private double precoItem;

    // --------------------------------------------------------------
    // Getters e Setters
    // --------------------------------------------------------------

    /**
     * Retorna o ID do item.
     * 
     * @return identificador do item
     */
    public int getIdItens() {
        return idItens;
    }

    /**
     * Define o ID do item.
     * 
     * @param idItens novo identificador do item
     */
    public void setIdItens(int idItens) {
        this.idItens = idItens;
    }

    /**
     * Retorna a descrição do item.
     * 
     * @return descrição do item
     */
    public String getDescItem() {
        return descItem;
    }

    /**
     * Define a descrição do item.
     * 
     * @param descItem nova descrição do item
     */
    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }

    /**
     * Retorna o tipo do item (ex.: Comida, Bebida).
     * 
     * @return tipo do item
     */
    public String getTipoItem() {
        return tipoItem;
    }

    /**
     * Define o tipo do item.
     * 
     * @param tipoItem novo tipo do item
     */
    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }

    /**
     * Retorna o preço base do item.
     * 
     * @return preço base
     */
    public double getPrecoItem() {
        return precoItem;
    }

    /**
     * Define o preço base do item.
     * 
     * @param precoItem novo preço do item
     */
    public void setPrecoItem(double precoItem) {
        this.precoItem = precoItem;
    }

    /**
     * Retorna o preço final do item.
     * Por padrão, retorna apenas o preço base. Subclasses podem sobrescrever
     * esta lógica para aplicar taxas, descontos ou regras específicas.
     *
     * @return preço final calculado
     */
    public double getPrecoFinal() {
        return getPrecoItem();
    }
}
