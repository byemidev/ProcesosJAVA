package cocina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cocina extends Thread{
    private HashMap<String, Integer> comanda;
    private ArrayList<Cocinero> cocineros =  new  ArrayList<Cocinero>();
    Cocina(HashMap<String, Integer> platos)
    {
        this.comanda= platos;
    }
    public void run()
    {
        //reparto platos de la comanda a los cocineros
        System.out.println("Estoy asignando los platos a los  cocineros");
        repartirPlatos(comanda);

        for(Cocinero cocinero : cocineros){
            cocinero.start();
        }
        //bucle infinito, realmente asigno platos a un numero infinito de cocineros por que nunca estoy ejecutando cocina
    }


    //metodo para asignar platos a los cocineros desde Cocina
    public void repartirPlatos(HashMap<String, Integer> platosComanda){

        boolean selector = true;
        //asigno un plato aleatoreamente a mi cocinero

        if(Math.random()>0.5){
            selector = false;
        }
        for(Cocinero cocinero : this.cocineros){
            for(Map.Entry<String, Integer> plato : platosComanda.entrySet()){
                if(selector){
                    cocinero.platosAsignados.put(plato.getKey(), plato.getValue());
                    System.out.println("te ha tocado hacer este plato");
                }else {
                    System.out.println("no te toca hacer este plato");
                }
            }
        }
    }
}
