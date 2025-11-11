package com.java.multithread;

public class NewThread extends Thread {
	
	public void start() {
		super.start();// this runs the below run method which create a new thread which runs run() method
		System.out.println("Start Method");
	}
	
	public void run() {
		System.out.println("Run Method");
	}

}
