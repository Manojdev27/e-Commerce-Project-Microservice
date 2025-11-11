package com.wipro.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NewMain {
	
	public static void main(String[] args) {
		List<String> fruitsList = new ArrayList<>();
		fruitsList.add("apple");
		fruitsList.add("banana");
		fruitsList.add("pineapple");
		System.out.println(fruitsList);
	    String LongestString =fruitsList.stream()
	    		.max(Comparator.comparing(String::length)).orElse("");
	    System.out.println("Longest String is:" +LongestString);
	    
//	    AAGGBHTTFF"
//	    o/p: A G B H T F, 6
//	    
//	    o/p: banana
	    
	   
	}

}
