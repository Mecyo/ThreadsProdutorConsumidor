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
public class Filosofo extends Thread{
    
    String nome;
    Garfo garfoEsquerda;
    Garfo garfoDireita;

    public Filosofo(String nomeFilosofo, Garfo garfoEsquerda, Garfo garfoDireita) {
        nome = nomeFilosofo;
        this.garfoEsquerda = garfoEsquerda;
        this.garfoDireita = garfoDireita;
    }
    
    public void run() {
        
    }
    
    public String pensar() {
        return nome + " pensando com os garfos: DIREITA = " + garfoDireita.getNome(this) + " e ESQUERDA = " + garfoEsquerda.getNome(this);
    }
    
    public String esperar() {
        return nome + " esperando com os garfos: DIREITA = " + garfoDireita.getNome(this) + " e ESQUERDA = " + garfoEsquerda.getNome(this);
    }
    
    public String comer() {
        return nome + " comendo com os garfos: DIREITA = " + garfoDireita.getNome(this) + " e ESQUERDA = " + garfoEsquerda.getNome(this);
    }
    
    
}
