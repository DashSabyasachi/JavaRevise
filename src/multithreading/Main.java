package multithreading;

public class Main {
public static void main(String[] args) {
//	1-what is multithreading
//	  Multithreading means executing multiple threads concurrently within a single program.
//	  
//	2-what is thread
//	  A thread is a lightweight unit of a process.
//
//	3-how to create a thread
//	  1-extending thread class
	    class MyThread extends Thread {

	    public void run() {
	        System.out.println("Thread is running");
	    }

	    public static void main(String[] args) {
	        MyThread t = new MyThread();
	        t.start();
	    }
	}
	  
//	  2-implementing runnable interface
	    class MyTask implements Runnable {

	    public void run() {
	        System.out.println("Thread is running");
	    }

	    public static void main(String[] args) {
	        MyTask task = new MyTask();

	        Thread t = new Thread(task);
	        t.start();
	    }
	}

//	4-difference between thread and runnable
//	  Thread is a class that represents a thread, while Runnable is an interface that represents a task that can be executed by a thread.
//	5-thread state
//	  new,running,runnable,waiting,blocked,terminate
//
//	  new: Thread object is created, but start() has not been called.  Thread t = new Thread();
//
//	  runable: t.start(); the thread enters the RUNNABLE state.
//
//	  running: In simple terms, when the scheduler gives CPU time to a runnable thread, we call it running.
//
//	  waiting: "Wait until thread x finishes."
//
//	  blocked: A thread becomes BLOCKED when it is waiting to acquire a lock that another thread currently holds.
//
//	  Terminated: When the run() method finishes, the thread is TERMINATED.
//
//	6-what is start() and run()
//	  t.start();  // creates new thread
//	  t.run();    // normal method call, NO new thread
//
//	7-new state
//	  Thread t = new Thread(); but not start()
//	8-runnable state
//	  After calling start(), the thread enters the RUNNABLE state.
//	  Runnable means the thread is ready to run or is currently running, depending on JVM/OS scheduling.
//	9-running state
//	  
//	10-sleep()
//	   sleep() pauses the currently executing thread for a specified time.
	   class MyTask extends Thread {

	    public void run() {
	        for (int i = 1; i <= 5; i++) {
	            System.out.println(i);

	            try {
	                Thread.sleep(1000); // pause for 1 second
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public static void main(String[] args) {
	        MyTask t = new MyTask();
	        t.start();
	    }
	}

//	11-join()
//	   join() makes one thread wait for another thread to finish.
	   package com.example;

	public class Joinn extends Thread {
		public void run() {
	        for (int i = 1; i <= 3; i++) {
	            System.out.println("Child Thread: " + i);

	            try {
	                Thread.sleep(1000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
	    }
		
		public static void main(String[] args) {

	        Joinn t = new Joinn();

	        t.start();

	        try {
	            t.join(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Main thread finished");
	    }
	}


//	12-yeild()
//	   yield() gives a hint to the thread scheduler that the current thread is willing to give other threads a chance to execute.
    package com.example;

	public class Yeilddd extends Thread{
		public void run() {
	        for (int i = 1; i <= 5; i++) {
	            System.out.println(Thread.currentThread().getName() + " : " + i);

	            if (i == 2) {
	                Thread.yield();
	            }
	        }
	    }
		public static void main(String[] args) {

	        Yeilddd t1 = new Yeilddd();
	        Yeilddd t2 = new Yeilddd();

	        t1.setName("Thread-1");
	        t2.setName("Thread-2");

	        t1.start();
	        t2.start();
	    }
	}
//	13-sleep()                             wait()
//	   Used for time-based pause | Used for inter-thread communication
//	   Does NOT release lock     | Releases the object's monitor lock
//
//	14-thread scheduler
//	   The thread scheduler decides which runnable thread gets CPU time.  t.setPriority();
//
//	15-Deamon thread
//	   A daemon thread is a thread that runs in the background to perform supporting tasks for user threads.
//	   Garbage Collection — JVM's garbage collector runs as a background service.
//	   Background monitoring — monitoring application activity or resources.
//	   Background cleanup — cleaning temporary or unused resources.
//
//	16-green thread model
//	   A green thread is a lightweight thread managed and scheduled by the JVM instead of directly by the operating system.
//	17-what is synchronization
//	   Synchronization is a mechanism in Java that prevents multiple threads from accessing a shared resource simultaneously
//	18- what is lock
//	    A lock is a mechanism that ensures only one thread at a time can access a synchronized
//	18-types of lock
//	   Class-level Lock
//	   Used by a static synchronized method.
//	   if there is 2 object: both use the same class-level lock when calling the static synchronized method.
//	   Object-level Lock
//	   Used by a non-static synchronized method.
//	   if there is 2 object: they can potentially be locked independently.
//	19-inter thread communication
//	   Inter-thread communication means threads communicate with each other to coordinate their work.
//	   wait() : causes the current thread to release the object's lock and enter the WAITING state until another thread calls notify() or notifyAll() on the same object.
//	   notify() : Wakes one waiting thread
//	   notifyall() : Wakes all waiting threads
	  class Test extends Thread {

	    public void run() {
	        synchronized (this) {
	            try {
	                System.out.println("Waiting...");
	                wait();
	                System.out.println("Resumed!");
	            } catch (InterruptedException e) {
	                System.out.println(e);
	            }
	        }
	    }

	    public static void main(String[] args) {

	        Test t = new Test();

	        t.start();

	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            System.out.println(e);
	        }

	        synchronized (t) {
	            t.notify();
	        }
	    }
	}
//	20-Deadlock
//	   Deadlock occurs when two or more threads wait forever for locks held by each other.
//	21-starvation
//	   Starvation occurs when a thread continuously fails to get the CPU or required resource because other threads keep getting preference.
}
}
