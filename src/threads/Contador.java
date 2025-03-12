package threads;
import java.util.concurrent.locks.ReentrantLock;

public class Contador {
    private int valor = 0;
    private final ReentrantLock lock = new ReentrantLock();
    public void incrementar(){
        lock.lock();
        try{
            valor++;
            System.out.println(valor);
        } finally{
            lock.unlock();
        }

    }
}
