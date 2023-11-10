public class HiloTemporizador extends Thread {
    private String nombre; 
    private Dato dato; 

    public HiloTemporizador(){ //constructor de hilo 
        
    }
    public static run(){
        //Necesito que cada 30 segundos 
        int treinta = 30; 
        long timeMillis = System.currentTimeMillis();
        long timeSeconds = TimeUnit.MILLISECONDS.toSeconds(timeMillis);
        //if timeSeconds%30 == 0 han pasado 30. segundos ? 
        while(timeSeconds%30 != 0){
            if(acabado){
                break;
            }
            //estado = finalizado; 
            Thread.sleep(1000);
        }
    }
    
    
}
