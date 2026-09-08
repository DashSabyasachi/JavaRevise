package multithreading;


class MyThread extends Thread {

    public void run() {
        System.out.println("My thread is running");
    }
}


public class Demo {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();

        t1.start();
    }
}

