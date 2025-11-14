package Model;

/**
 * Classe que representa um cliente do sistema. Armazena nome completo,
 * nome de usuário e senha, sendo utilizada em operações de login e cadastro.
 * 
 * author uniflchau
 */
public class Cliente {

    /** Nome completo do cliente. */
    private String nome;

    /** Nome de usuário utilizado para login. */
    private String usuario;

    /** Senha do cliente. */
    private String senha;

    /**
     * Construtor completo.
     * Permite criar um cliente já informando nome, usuário e senha.
     *
     * @param nome nome completo do cliente
     * @param usuario nome de usuário utilizado no login
     * @param senha senha do cliente
     */
    public Cliente(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     * Construtor vazio (padrão).
     * Útil para criar o objeto e preencher os dados
     * posteriormente usando os setters.
     */
    public Cliente() {
    }

    /**
     * Retorna o nome completo do cliente.
     *
     * @return nome do cliente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome completo do cliente.
     *
     * @param nome novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome de usuário do cliente (login).
     *
     * @return usuário
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define o nome de usuário do cliente.
     *
     * @param usuario novo nome de usuário
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Retorna a senha do cliente.
     *
     * @return senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha do cliente.
     *
     * @param senha nova senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
