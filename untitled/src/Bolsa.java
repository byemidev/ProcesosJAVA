import java.util.Random;
import java.util.Scanner;

class Bolsa {
    private double precioAccion = 100.0; // Precio inicial
    private final Object lock = new Object(); // Objeto para sincronización

    public void subirPrecio() {
        synchronized (lock) {
            double porcentaje = (new Random().nextDouble() * 0.02) + 0.03; // Entre 3% y 5%
            precioAccion += precioAccion * porcentaje;
            System.out.println("Subida de precio: " + porcentaje * 100 + "%");
        }
    }

    public void bajarPrecio() {
        synchronized (lock) {
            double porcentaje = (new Random().nextDouble() * 0.02) + 0.03; // Entre 3% y 5%
            precioAccion -= precioAccion * porcentaje;
            System.out.println("Bajada de precio: " + porcentaje * 100 + "%");
        }
    }

    public double consultarPrecio() {
        synchronized (lock) {
            return precioAccion;
        }
    }

    public void comprarAccion() {
        synchronized (lock) {
            System.out.println("Compra realizada a $" + precioAccion);
        }
    }
}

class Comprador implements Runnable {
    private Bolsa bolsa;
    private float saldo;
    private Scanner scanner = new Scanner(System.in);

    public Comprador(Bolsa bolsa) {
        this.bolsa = bolsa;
        this.saldo = 1000.00f;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Presione Enter para comprar una acción...");
            scanner.nextLine();
            bolsa.comprarAccion();
        }
    }

    private void restarCompra(){
        //TODO deberia congelar el valor de la compra para saber cuanto tengo en mi saldo real
    }

    private void sumarGanancias(){
        //TODO si la he comprado por un precio mas bajo le sumo las ganancias a mi saldo
    }

    private void restarPerdidas(){
        //TODO si la ha comprado por un precio mas alto resto lo que he perdido a mi saldo
    }
}

class Subidor implements Runnable
{
    private Bolsa bolsa;
    public Subidor(Bolsa bolsa) {
        this.bolsa = bolsa;
    }
    @Override
    public void run() {
        while (true) {
            bolsa.subirPrecio();
            try {
                Thread.sleep(3000); // Esperar 2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Bajador implements Runnable
{
    private Bolsa bolsa;
    public Bajador(Bolsa bolsa) {
        this.bolsa = bolsa;
    }
    @Override
    public void run() {
        while (true) {
            bolsa.subirPrecio();
            try {
                Thread.sleep(3000); // Esperar 2 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

