package com.java.multithread;

public class NewRunnable implements Runnable{

	@Override
	public void run() {
	for (int i = 0; i <10;i++) {
		System.out.println("Child Method");// executed by the child thread
		
	}
		
	}

}
