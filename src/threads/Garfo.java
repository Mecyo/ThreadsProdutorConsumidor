/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author aluno
 */
class Garfo {
    
    Filosofo ativo;
    String nome;

    public Garfo(String nome) {
        this.nome = nome;
    }

    public String getNome(Filosofo verifica) {
        if(ativo != null && ativo.equals(verifica))
            return nome;
        
        return null;
    }

    public void setAtivo(Filosofo ativo) {
        this.ativo = ativo;
    }
    
}
