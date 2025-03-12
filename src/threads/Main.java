package threads;

public class Main {
    public static void main (String[] args){
        Contador contador = new Contador();

        MinhaThread minhathread = new MinhaThread();
        Thread incrementadornumero = new Thread(new IncrementadorNumero());
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread3 thread3 = new Thread3();
        Incrementador1 incrementador1 = new Incrementador1(contador); //Diferente do incrementadornumero, o incremetador1 e 2 fazem referencia ao exercício 4
        Incrementador2 incrementador2 = new Incrementador2(contador);
        RegistroHora registrohora = new RegistroHora();

        minhathread.start();
        incrementadornumero.start();
        thread1.start();
        thread2.start();
        thread3.start();
        incrementador1.start();
        incrementador2.start();
        registrohora.start();

    }
}


