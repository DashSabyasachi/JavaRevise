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
//class MyTask implements Runnable {
//
//    public void run() {
//        System.out.println("Task is running");
//    }
//}
//
//public class Demo {
//
//    public static void main(String[] args) {
//
//        MyTask task = new MyTask();
//
//        Thread t1 = new Thread(task);
//
//        t1.start();
//    }
//}



// //Lambda makes Runnable shorter
//public class Demo {
//
//    public static void main(String[] args) {
//
//        Runnable task = () -> {
//            System.out.println("Task is running");
//        };
//
//        Thread t1 = new Thread(task);
//
//        t1.start();
//    }
//}




// //sleep() — Pause a Thread
//public class Demo {
//
//    public static void main(String[] args) {
//
//        class MyThread extends Thread {
//
//            public void run() {
//
//                for (int i = 1; i <= 5; i++) {
//
//                    System.out.println(i);
//
//                    try {
//                        Thread.sleep(1000);
//                    }
//                    catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//
//        MyThread t1 = new MyThread();
//        t1.start();
//    }
//}


public class Demo {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {

            for(int i = 1; i <= 5; i++) {
                System.out.println(i);
            }
        });

        t1.start();

        t1.join();

        System.out.println("Main thread completed");
    }
}


























