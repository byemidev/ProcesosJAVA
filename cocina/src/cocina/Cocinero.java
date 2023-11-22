package cocina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cocinero extends Thread{
    public HashMap<String, Integer> platosAsignados;

    Cocinero(HashMap<String, Integer> platos)
    {
        this.platosAsignados= platos;
    }
    public void run(){
       //cocino los platos
        cocinando();
    }

    public void cocinando(){
        for(Map.Entry<String, Integer> entrada : platosAsignados.entrySet()) {
            System.out.println("Cocinando plato "+entrada.getKey()+" tiempo "+entrada.getValue());
            try {
                Thread.sleep(entrada.getValue());
            } catch (InterruptedException e) {

                System.out.println("Plato sin terminar "+entrada.getKey());
                //salgo del hilo
                break;
            }
            System.out.println("Plato terminado"+entrada.getKey());

        }
    }
}
