package sample;

public class ThreadTest2 {
    public static void main(String[] args) throws InterruptedException {
        Thread1 t = new Thread1();
        t.run(); 
        //t.start();
        for (int i = 0; i < 100; i++) {
            System.out.println("main:"+i);
        }
    }
}

class Thread1 extends Thread{
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread-----:"+i);
        }
    }
}
