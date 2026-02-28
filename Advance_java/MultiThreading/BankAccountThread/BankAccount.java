package thread;

class BankAccount {

    int balance = 1000;

    public synchronized void withdraw(int amount) throws InterruptedException {

        System.out.println(Thread.currentThread().getName() + " entered withdraw()");
        System.out.println(Thread.currentThread().getName() + " acquired LOCK on BankAccount");

        // Use WHILE (important)
        while (balance < amount) {
            System.out.println("Insufficient balance...");
            System.out.println(Thread.currentThread().getName() + " is going to WAIT");

            wait();  // releases lock

            System.out.println(Thread.currentThread().getName() + " got NOTIFIED and reacquired LOCK");
        }

        balance = balance - amount;
        System.out.println(Thread.currentThread().getName() + " completed withdrawal");
        System.out.println("Remaining balance = " + balance);
    }

    public synchronized void deposit(int amount) {

        System.out.println(Thread.currentThread().getName() + " entered deposit()");
        System.out.println(Thread.currentThread().getName() + " acquired LOCK on BankAccount");

        balance = balance + amount;
        System.out.println(Thread.currentThread().getName() + " deposited amount");
        System.out.println("Updated balance = " + balance);

        notify(); // wake one waiting thread
        System.out.println(Thread.currentThread().getName() + " sent notify signal");
        System.out.println(Thread.currentThread().getName() + " releasing LOCK");
    }
}

public class BankAccountThread {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        // Withdraw Thread
        Thread t1 = new Thread(() -> {
            try {
                account.withdraw(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Withdraw-Thread");

        // Deposit Thread
        Thread t2 = new Thread(() -> {
            account.deposit(1000);
        }, "Deposit-Thread");

        t1.start();
        t2.start();
    }
}
