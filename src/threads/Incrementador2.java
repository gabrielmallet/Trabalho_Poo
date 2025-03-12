package threads;

public class Incrementador2 extends Thread{
    private Contador contador;
    public Incrementador2(Contador contador){
        this.contador = contador;
    }

    public void run(){
        contador.incrementar();
    }
}
