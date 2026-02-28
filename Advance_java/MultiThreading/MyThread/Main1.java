package thread;

public class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
    }
}

class Main1 {
    public static void main(String[] args) throws Exception{
        MyThread myThread = new MyThread();
//        myThread.run();
        myThread.setName("Ps");
        myThread.start();
        myThread.join();
        System.out.println("main");
    }
}
