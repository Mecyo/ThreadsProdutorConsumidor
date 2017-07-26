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
    Semaphore sem;

    public Filosofo(String nomeFilosofo, Garfo garfoEsquerda, Garfo garfoDireita) {
        nome = nomeFilosofo;
        this.garfoEsquerda = garfoEsquerda;
        this.garfoDireita = garfoDireita;
    }
    
    public void run() {
        this.pensar();
        this.comer();
        this.esperar();
    }
    
    public void pensar() {
        System.out.println(nome + " pensando com os garfos: DIREITA = " + garfoDireita.getNome(this) + " e ESQUERDA = " + garfoEsquerda.getNome(this));
    }
    
    public void esperar() {
        System.out.println(nome + " esperando com os garfos: DIREITA = " + garfoDireita.getNome(this) + " e ESQUERDA = " + garfoEsquerda.getNome(this));
    }
    
    public void comer() {
        if(garfoDireita.getNome(this) != null && garfoEsquerda.getNome(this) != null)
            System.out.println(nome + " comendo com os garfos: DIREITA = " + garfoDireita.getNome(this) + " e ESQUERDA = " + garfoEsquerda.getNome(this));
        else if(garfoDireita.getNome(this) == null && garfoEsquerda.getNome(this) == null)
            System.out.println("O " + nome + " não está segurando nenhum garfo!");
        else
            System.out.println(garfoDireita.getNome(this) == null ? "O " + nome + " está segurando apenas o garfo: ESQUERDA = " + garfoEsquerda.getNome(this) : "O " + nome + " está segurando apenas o garfo: DIREITA = " + garfoDireita.getNome(this));
    }

    public void setSem(Semaphore sem) {
        this.sem = sem;
    }
    
}
