package threads;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ads
 */
public class Consumer extends Thread {

    String nome;
    Programa a;
    Semaphore sem;

    public Consumer(String nomeP, Programa x, Semaphore semaphore) {

        nome = nomeP;
        sem = semaphore;
        a = x;
    }

    public void run() {

        while (true) {
            int item;
            sem.down();
            if(!a.buffer.isEmpty()) {
                item = (Integer) a.buffer.get(0);
                a.buffer.remove(0);
                a.itemCount--;
                System.out.println(nome + ": consumiu o item " + item + ";");
            }
            sem.up();
        }
    }
}
