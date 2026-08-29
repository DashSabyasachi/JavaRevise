package multithreading;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		// ===================================================
		// 1. WHAT IS MULTITHREADING
		// Executing multiple threads concurrently in one program.
		// 2. WHAT IS A THREAD
		// A thread is a lightweight unit/sub-part of a process.
		// ===================================================


		// ===================================================
		// 3. HOW TO CREATE A THREAD
		// ===================================================
		System.out.println("---- 3. Creating threads ----");

		// Way 1: extending Thread
		MyThread t1 = new MyThread();
		t1.start();

		// Way 2: implementing Runnable (preferred)
		MyTask task = new MyTask();
		Thread t2 = new Thread(task);
		t2.start();

		t1.join();
		t2.join();
		System.out.println();


		// ===================================================
		// 4. THREAD vs RUNNABLE
		// Thread   -> a class representing an actual thread
		// Runnable -> an interface representing just "a task"
		// Prefer Runnable since Java has single inheritance,
		// so implementing Runnable leaves the class free to
		// extend something else.
		// ===================================================


		// ===================================================
		// 5-9. THREAD LIFE CYCLE + start() vs run()
		// NEW -> RUNNABLE -> RUNNING -> (WAITING/BLOCKED) -> TERMINATED
		// ===================================================
		System.out.println("---- 5-9. Thread lifecycle ----");
		Thread t3 = new Thread(new MyTask());
		System.out.println("State after creation (NEW): " + t3.getState());

		t3.start(); // moves to RUNNABLE, then RUNNING when scheduled
		System.out.println("State right after start(): " + t3.getState());

		t3.join(); // wait for it to finish
		System.out.println("State after run() completes (TERMINATED): " + t3.getState());

		// start() vs run():
		// t.start() -> creates a NEW thread, then run() executes on it
		// t.run()   -> just a normal method call, NO new thread created
		System.out.println();


		// ===================================================
		// 10. sleep()
		// Pauses the CURRENTLY EXECUTING thread; does NOT release any lock.
		// ===================================================
		System.out.println("---- 10. sleep() ----");
		Thread sleepThread = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println("Count: " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		sleepThread.start();
		sleepThread.join();
		System.out.println();


		// ===================================================
		// 11. join()
		// Makes the calling thread WAIT until another thread finishes.
		// ===================================================
		System.out.println("---- 11. join() ----");
		Thread childThread = new Thread(() -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println("Child Thread: " + i);
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		childThread.start();
		childThread.join(5000); // main waits up to 5 sec for it to finish
		System.out.println("Main resumes after child finished (join)");
		System.out.println();


		// ===================================================
		// 12. yield()
		// A HINT to the scheduler: "willing to let others run".
		// Not guaranteed to be honored.
		// ===================================================
		System.out.println("---- 12. yield() ----");
		Runnable yieldTask = () -> {
			for (int i = 1; i <= 3; i++) {
				System.out.println(Thread.currentThread().getName() + " : " + i);
				if (i == 2) {
					Thread.yield();
				}
			}
		};
		Thread y1 = new Thread(yieldTask, "Thread-A");
		Thread y2 = new Thread(yieldTask, "Thread-B");
		y1.start();
		y2.start();
		y1.join();
		y2.join();
		System.out.println();


		// ===================================================
		// 13. sleep() vs wait()
		// sleep() -> time-based pause, does NOT release lock, called on Thread
		// wait()  -> inter-thread communication, RELEASES lock, called on
		//            an Object inside synchronized block, resumed by notify()
		// ===================================================


		// ===================================================
		// 14. THREAD SCHEDULER
		// Decides which RUNNABLE thread gets CPU time.
		// We can only give a priority HINT via setPriority().
		// ===================================================
		System.out.println("---- 14. Thread priority ----");
		Thread p1 = new Thread(() ->
			System.out.println(Thread.currentThread().getName() + " priority: "
				+ Thread.currentThread().getPriority()), "High-Priority");
		Thread p2 = new Thread(() ->
			System.out.println(Thread.currentThread().getName() + " priority: "
				+ Thread.currentThread().getPriority()), "Low-Priority");

		p1.setPriority(Thread.MAX_PRIORITY); // 10
		p2.setPriority(Thread.MIN_PRIORITY); // 1
		p1.start();
		p2.start();
		p1.join();
		p2.join();
		System.out.println();


		// ===================================================
		// 15. DAEMON THREAD
		// Background helper thread (e.g. Garbage Collector).
		// JVM exits once all USER threads finish, killing daemons too.
		// ===================================================
		System.out.println("---- 15. Daemon thread ----");
		Thread daemon = new Thread(() -> {
			while (true) {
				System.out.println("Daemon working in background...");
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					break;
				}
			}
		});
		daemon.setDaemon(true); // must be set BEFORE start()
		daemon.start();
		Thread.sleep(1000); // let it print a few times
		System.out.println("Main moving on (daemon will die when JVM exits)");
		System.out.println();


		// ===================================================
		// 16. GREEN THREAD MODEL
		// Threads managed by the JVM in software instead of
		// directly by the OS. Old Java versions used this;
		// modern JVMs mostly use native OS threads.
		// (Conceptual only — no code needed.)
		// ===================================================


		// ===================================================
		// 17 & 18. SYNCHRONIZATION + LOCK
		// synchronized prevents multiple threads from touching
		// a shared resource at the same time.
		// ===================================================
		System.out.println("---- 17-18. synchronization ----");
		Counter counter = new Counter();
		Runnable incrementTask = () -> {
			for (int i = 0; i < 1000; i++) {
				counter.increment();
			}
		};
		Thread s1 = new Thread(incrementTask);
		Thread s2 = new Thread(incrementTask);
		s1.start();
		s2.start();
		s1.join();
		s2.join();
		// Without 'synchronized' on increment(), this could print
		// less than 2000 due to a race condition.
		System.out.println("Final count (should be 2000): " + counter.getCount());

		// Types of locks:
		// Class-level lock  -> used by "static synchronized" methods,
		//                      shared across ALL objects of the class.
		// Object-level lock -> used by non-static synchronized methods,
		//                      each object locked independently.
		System.out.println();


		// ===================================================
		// 19. INTER-THREAD COMMUNICATION (wait / notify / notifyAll)
		// wait()      -> releases lock, waits until notified
		// notify()    -> wakes ONE waiting thread
		// notifyAll() -> wakes ALL waiting threads
		// ===================================================
		System.out.println("---- 19. wait() / notify() ----");
		final Object lock = new Object();
		Thread waiter = new Thread(() -> {
			synchronized (lock) {
				try {
					System.out.println("Child: waiting...");
					lock.wait();
					System.out.println("Child: resumed!");
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
		});
		waiter.start();
		Thread.sleep(500); // let child reach wait() first
		synchronized (lock) {
			System.out.println("Main: notifying child...");
			lock.notify();
		}
		waiter.join();
		System.out.println();


		// ===================================================
		// 20. DEADLOCK
		// Two threads wait forever for locks held by each other.
		// (Left commented out — running it will hang the program!)
		// ===================================================
		System.out.println("---- 20. Deadlock (see method, not run by default) ----");
		// demonstrateDeadlock(); // uncomment to see it actually hang


		// ===================================================
		// 21. STARVATION
		// A thread keeps getting denied CPU/resources because
		// other (often higher-priority) threads keep getting
		// preference. Scheduler-dependent, so it's conceptual —
		// hard to reliably reproduce in a short demo.
		// ===================================================
		System.out.println("---- 21. Starvation: conceptual, no guaranteed demo ----");
	}


	// -------------------------------------------------------
	// Way 1: extending Thread class (point 3)
	// -------------------------------------------------------
	static class MyThread extends Thread {
		public void run() {
			System.out.println("MyThread running (extends Thread)");
		}
	}

	// -------------------------------------------------------
	// Way 2: implementing Runnable interface (point 3)
	// -------------------------------------------------------
	static class MyTask implements Runnable {
		public void run() {
			System.out.println("MyTask running (implements Runnable)");
		}
	}

	// -------------------------------------------------------
	// Shared counter for synchronization demo (points 17-18)
	// -------------------------------------------------------
	static class Counter {
		private int count = 0;

		public synchronized void increment() {
			count++;
		}

		public int getCount() {
			return count;
		}
	}

	// -------------------------------------------------------
	// Deadlock demo method (point 20) — NOT called by default
	// because it will hang the program forever, by design.
	// -------------------------------------------------------
	static void demonstrateDeadlock() {
		final Object lock1 = new Object();
		final Object lock2 = new Object();

		Thread d1 = new Thread(() -> {
			synchronized (lock1) {
				System.out.println("d1: locked lock1, waiting for lock2");
				try { Thread.sleep(100); } catch (InterruptedException e) {}
				synchronized (lock2) {
					System.out.println("d1: got lock2");
				}
			}
		});

		Thread d2 = new Thread(() -> {
			synchronized (lock2) {
				System.out.println("d2: locked lock2, waiting for lock1");
				try { Thread.sleep(100); } catch (InterruptedException e) {}
				synchronized (lock1) {
					System.out.println("d2: got lock1");
				}
			}
		});

		d1.start();
		d2.start();
	}
}