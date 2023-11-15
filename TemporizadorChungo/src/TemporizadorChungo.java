import java.util.Scanner;


//TODO hacer una instancia de dato en los hilos,
//  ya que segun el valor de true o false del dato se comportaran cada uno de una forma distinta
public class TemporizadorChungo { //Aqui deberia haber un bucle finito hasta que el estado del dato sea true
    public static void main(String[] args) {
        Thread HiloPregunton  = new HiloPregunton();
        Thread HiloTemporizador = new HiloTemporizador();

        hiloTemporizador.start();
        if(!hiloTemporizador.interrupted()){
            try{hiloTemporizador.sleep(30000);}
            catch(){}
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
            int treinta = 30;
            while(true){//donde se deberia manejar las interrupciones
                try {
                    Thread.sleep(1000);
                    treinta--;
                    if(treinta < 1 ){
                        //Estado del dato = false
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                    break;
                }
            }
        }
    }

    //pregunton
    class HiloPregunton extends Thread{ //deberia poder evaluar en algun lugar el estado del hilo.
        static Boolean estado = false;
        private Dato dato;
        public void run(){//solo se deberia ejecutar durante los 30 segundos de espera del hilo temporizador.
            System.out.println("soy el hilo pregunton");

            //Scanner y estado
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
                estado = true;
            }

        }
    }
}
