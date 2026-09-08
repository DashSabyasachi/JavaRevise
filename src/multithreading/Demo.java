package multithreading;

// // Single thread
//class MyThread extends Thread {
//
//    public void run() {
//        System.out.println("My thread is running");
//    }
//}
//
//
//public class Demo {
//
//    public static void main(String[] args) {
//
//        MyThread t1 = new MyThread();
//
//        t1.start();
//    }
//}




// // Multiple thread
//class MyThread extends Thread {
//
//    public void run() {
//
//        for(int i = 1; i <= 5; i++) {
//            System.out.println(Thread.currentThread().getName()
//                    + " : " + i);
//        }
//    }
//}
//
//public class Demo {
//
//    public static void main(String[] args) {
//
//        MyThread t1 = new MyThread();
//        MyThread t2 = new MyThread();
//
//        t1.start();
//        t2.start();
//    }
//}


// //Runnable
class MyTask implements Runnable {

    public void run() {
        System.out.println("Task is running");
    }
}

public class Demo {

    public static void main(String[] args) {

        MyTask task = new MyTask();

        Thread t1 = new Thread(task);

        t1.start();
    }
}




























