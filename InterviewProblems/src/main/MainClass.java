package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MainClass {
	
	public static List<List<Integer>> subSets(int[] arr){
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for(int num:arr) {
			int size = result.size();
			for (int i = 0; i < size; i++) {
				List<Integer> subset = new ArrayList<>(result.get(i));
				subset.add(num);
				result.add(subset);
				
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] input = {1,2,3};
		List<List<Integer>> powerSet = subSets(input);
		System.out.println(powerSet);
		
		
	}

//	Implement a thread-safe Singleton pattern in Java. Ensure that the instance is created lazily and is efficient in a multi-threaded environment.
//	 
//	Given a set of distinct integers, find all possible subsets (the power set).
//	   Sample Input: {1, 2, 3}
//	   Sample Output: Output: [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
//	 
}
