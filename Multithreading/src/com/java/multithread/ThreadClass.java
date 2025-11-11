package com.java.multithread;

public class ThreadClass extends Thread{

	public void run() {
		System.out.println("run method executed by Thread: "+Thread.currentThread().getName());
	}

}
