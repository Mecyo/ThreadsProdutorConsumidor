package threads;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ads
 */
import java.util.ArrayList;

public class Programa {
    
        int itemCount;
        ArrayList buffer;
    
        Programa () {
            itemCount = 0;
            buffer = new ArrayList(); 
        }
    
        int compartilhada;
    
        public static void main(String[] args) {
               Programa t = new Programa();
               t.run();
        } 
        
        public void run() {
            Semaphore sem = new Semaphore(1);
            Semaphore sem1 = new Semaphore(1);
            Consumer c = new Consumer("Consumidor1", this, sem);
            Producer p = new Producer("Produtor1", this, sem);
            p.start();
            c.start();
            Consumer c1 = new Consumer("Consumidor2", this, sem);
            Producer p1 = new Producer("Produtor2", this, sem);
            p1.start();
            c1.start();
        }
    
    
}
