import java.util.Scanner;

public class TemporizadorChungo {
    public static void main(String[] args) {
        Thread HiloPregunton  = new HiloPregunton();
        Thread HiloTemporizador = new HiloTemporizador();

        hiloTemporizador.start();
        if(!hiloTemporizador.interrupted()){

        }

    }
    //dato
    class Dato {
        private Boolean estado = null;

        public Dato(){
            this.estado = false;
        }
        public Boolean getEstado(){
            return this.estado;
        }

        public void setEstado(Boolean estado){
            this.estado = estado;
        }
    }

    //temporizador
    class HiloTemporizador extends Thread {
        private String nombre;
        private Dato dato;

        public HiloTemporizador(){ //constructor de hilo

        }
        public void run(){
            while(true){//donde se deberia manejar las interrupciones
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                    break;
                }
            }
        }
    }

    //pregunton
    class HiloPregunton extends Thread{

        public void run(){//solo se deberia ejecutar durante los 30 segundos de espera del hilo temporizador.
            System.out.println("soy el hilo pregunton");
            Scanner sc = new Scanner(System.in);
            System.out.println("Dime quien cuantos balones de oro ha ganado Messi");
            char [] balones = {'1', '2', '3', '4', '5', '6', '7', '8'};
            for(char b : balones){
                System.out.println("\n" + b + "\n");
            }
            char respuesta = (char) sc.nextInt();

            if(!respuesta.equals('8')){
                System.out.println("no has acertado");
            }else {
                System.out.println("has acertado");
            }

        }
    }
}
