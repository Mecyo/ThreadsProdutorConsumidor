package threads;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ads
 */
public class Producer extends Thread {

    Programa a;
    Semaphore sem;
    String nome;

    int contador;

    public Producer(String nomeP, Programa x, Semaphore semaphore) {

        nome = nomeP;
        sem = semaphore;
        a = x;
        contador = 0;
    }

    public void run() {

        while (true) {
            sem.down();
            contador++;
            a.buffer.add(contador);
            sem.up();
            a.itemCount++;
            System.out.println(nome + ": produziu o item " + contador + ";");
        }

    }

}
