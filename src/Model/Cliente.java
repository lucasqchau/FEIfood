/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author uniflchau
 */
public class Cliente {
    // Atributos do cliente: nome completo, nome de usuário (login) e senha
    private String nome, usuario, senha;
    
    /**
     * Construtor completo.
     * Permite criar um cliente já informando nome, usuário e senha.
     */
    public Cliente(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    /**
     * Construtor vazio (padrão).
     * Útil quando você quer criar o objeto primeiro
     * e depois preencher os dados com os setters.
     */
    public Cliente() {
    }

    //Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
