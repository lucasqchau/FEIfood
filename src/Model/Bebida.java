package Model;

/**
 * Classe que representa uma bebida. Uma bebida é um tipo de Alimento
 * que pode ou não ser alcoólica. Caso seja alcoólica, o cálculo do
 * preço final pode aplicar regras específicas.
 *
 * author rchau
 */
public class Bebida extends Alimento {

    /** Indica se a bebida é alcoólica (true) ou não (false). */
    private final boolean alcoolica;

    /**
     * Construtor da classe Bebida.
     *
     * @param descricao descrição da bebida
     * @param preco preço base da bebida
     * @param alcoolica indica se a bebida contém álcool
     */
    public Bebida(String descricao, double preco, boolean alcoolica) {
        super(); 
        this.setDescItem(descricao);
        this.setTipoItem("Bebida");
        this.setPrecoItem(preco);
        this.alcoolica = alcoolica;
    }

    /**
     * Indica se a bebida é alcoólica.
     *
     * @return true se a bebida for alcoólica; false caso contrário
     */
    public boolean isAlcoolica() {
        return alcoolica;
    }

    /**
     * Retorna o preço final da bebida.
     * 
     * Regra de negócio:
     * - Bebidas alcoólicas recebem 15% de imposto sobre o preço base.
     * - Bebidas não alcoólicas mantêm o preço base.
     *
     * @return preço final calculado
     */
    @Override
    public double getPrecoFinal() {
        double base = getPrecoItem();
        return alcoolica ? base * 1.15 : base;
    }
}
