package com.java.multithread;

public class Main {
	public static void main(String[] args) {
//		MyThread myThread = new MyThread();// thread instantiation
//		myThread.start(); //starting of the thread
//		myThread.run();
		
//		for (int i = 0; i < 10; i++) {
//			System.out.println("Main Thread");//executed by main thread
//		}
		
//		NewThread newThread = new NewThread();
//		newThread.start();
//		System.out.println("Main Thread");
		
//		Case1:
//		NewRunnable newRunnable = new NewRunnable();
//		Thread thread = new Thread(newRunnable);// target runnable
//		thread.start();
//		
//		for(int i=0;i<10;i++) {
//			System.out.println("Main Thread");// executed by the main thread			
//		}

		//Case 2:
//		NewRunnable newRunnable = new NewRunnable();
//		Thread thread1 = new Thread();
//		Thread thread = new Thread(newRunnable);// target runnable
//		thread1.start();// new thread will be created which is responsible for the execution of thread class run() method, which has empty implementation
//		thread1.run(); // no new thread will be created and thread class run will be executed just like a normal method call.
//		thread.start(); // new thread will be created  which is responsible for the execution of newRunnable class run() method.
//		thread.run();   // new thread won't be created and my runnable run method will be executed just like a normal method call.
//		newRunnable.start(); // we will get compile time error saying myRunnable class doesn't have start capability in location class newRunnable
//		newRunnable.run(); // no new thread will be created and newRunnable run method will be executed like normal method call.
		
		
//		NewRunnable myThread = new NewRunnable();
//		Thread thread2 = new Thread(myThread);
//		thread2.start();
//		System.out.println("Main Thread");
		
		
//		for(int i=0;i<10;i++) {
//			System.out.println("Main Thread");// executed by the main thread			
//		}
		
		
		System.out.println(Thread.currentThread().getName());
		MyNewThread myNewThread = new MyNewThread();
		System.out.println(myNewThread.getName());
		MyNewThread myNewThread1 = new MyNewThread();
		System.out.println(myNewThread1.getName());
		Thread.currentThread().setName("Harry Potter");
		System.out.println(Thread.currentThread().getName());
	}

}
