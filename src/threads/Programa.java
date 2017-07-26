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
            int j;
            for (int i = 0; i < 5; i++) {
                j = i +1;
                garfos.add(new Garfo("Garfo-" + j));
            }
            
            for (int i = 0; i < garfos.size(); i++) {
                int proximo = i + 1;
                int k = proximo;
                if(i == garfos.size() - 1)
                    proximo = 0;
                
                Filosofo filo = new Filosofo("Filosofo-" + k, garfos.get(i), garfos.get(proximo));
                filo.setSem(sem2);
                filosofos.add(filo);
                garfos.get(i).setAtivo(filo);
                /*filosofos.get(i).pensar();
                filosofos.get(i).esperar();
                filosofos.get(i).comer();*/
            }
            
            
            while(true) {
                
                for (int i = 0; i < filosofos.size(); i++) {
                    filosofos.get(i).run();
                }
                
                
            }
            
        }
    
    
}
