
public class SimulacionBolsa2 {
    public static void main(String[] args) {
        Bolsa bolsa = new Bolsa();
        Comprador comprador = new Comprador(bolsa);

        Bajador bajador=new Bajador(bolsa);
        Subidor subidor=new Subidor(bolsa);

        Thread hiloComprador=new Thread(comprador);
        Thread hiloBajador=new Thread(bajador);
        Thread hiloSubidor=new Thread(subidor);

        System.out.println("Precio inicial de la acción 100");
        hiloComprador.start();
        hiloSubidor.start();
        hiloBajador.start();
    }
}
