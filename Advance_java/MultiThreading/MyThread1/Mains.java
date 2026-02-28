package thread;

public class MyThread1 implements Runnable{
    @Override
    public void run() {
        System.out.println("Hello from Runnable");
    }
}
class Mains {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        Thread t1 = new Thread(myThread1);
        t1.start();
    }
}
