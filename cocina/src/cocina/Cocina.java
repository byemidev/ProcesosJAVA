package cocina;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cocina extends Thread{
    private HashMap<String, Integer> comanda;

    private ArrayList<Cocinero> cocineros = new ArrayList<Cocinero>(){
        //cocinero 1
        //cocinero 2
        //cocinero 3
    };
    Cocina(HashMap<String, Integer> platos, ArrayList<Cocinero> cocineros)
    {
        this.comanda= platos;
        this.cocineros = cocineros;
    }
    public void run()
    {
        //reparto platos de la comanda a los cocineros
        repartirPlatos(cocineros, comanda);
    }


    //metodo para asignar platos a los cocineros desde Cocina
    public void repartirPlatos(ArrayList<Cocinero> cocineros, HashMap<String, Integer> platosComanda){

        Boolean selector = true;
        HashMap<String, Integer> platos = platosComanda;

        //asigno un plato aleatoreamente a mi cocinero

        if(Math.random()>0.5f){
            selector = false;
        }
        for(Cocinero cocinero : cocineros){
            for(Map.Entry<String, Integer> plato : platos.entrySet()){
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
