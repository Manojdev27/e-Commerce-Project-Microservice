package com.java.multithread;

public class Test {
	
	public static void main(String[] args) {
		ThreadClass threadClass = new ThreadClass();
		threadClass.start();
		System.out.println("main method is executed by Thread: "+Thread.currentThread().getName());
	}

}
