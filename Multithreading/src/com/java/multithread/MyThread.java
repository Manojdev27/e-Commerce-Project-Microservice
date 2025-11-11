package com.java.multithread;


public class MyThread extends Thread{
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Child Thread");//executed by the child thread
		}
		
	}
	
		public void run(int i) {
			System.out.println("Overloaded Method");// overloaded method is called only explicitly but the jvm calls only without arguments.
		
	}

}
