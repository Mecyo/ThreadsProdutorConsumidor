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
        ArrayList<Filosofo> filosofos;
        ArrayList<Garfo>  garfos;
    
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
            /*Semaphore sem = new Semaphore(1);
            Semaphore sem1 = new Semaphore(1);
            Consumer c = new Consumer("Consumidor1", this, sem);
            Producer p = new Producer("Produtor1", this, sem);
            p.start();
            c.start();
            Consumer c1 = new Consumer("Consumidor2", this, sem);
            Producer p1 = new Producer("Produtor2", this, sem);
            p1.start();
            c1.start();*/
            
            Semaphore sem2 = new Semaphore(1);
            
            filosofos = new ArrayList<Filosofo>();
            garfos = new ArrayList<Garfo>();
            
            for (int i = 0; i < 5; i++) {
                garfos.add(new Garfo("Garfo-" + i + 1));
            }
            
            for (int i = 0; i < garfos.size(); i++) {
                int proximo = i + 1;
                if(i == garfos.size() - 1)
                    proximo = 0;
                    
                filosofos.add(new Filosofo("Filosofo-" + proximo, garfos.get(i), garfos.get(i)));
                filosofos.get(i).pensar();
                filosofos.get(i).esperar();
                filosofos.get(i).comer();
            }
            
        }
    
    
}
