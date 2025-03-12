package threads;


public class Incrementador1 extends Thread{
    private Contador contador;
    public Incrementador1(Contador contador){
        this.contador = contador;
    }

    public void run(){
        contador.incrementar();
    }
}
