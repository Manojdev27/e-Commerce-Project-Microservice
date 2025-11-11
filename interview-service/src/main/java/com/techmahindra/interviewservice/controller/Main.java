package com.techmahindra.interviewservice.controller;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		
		String newStr = "AAABBCCDDD";
		Map<Character, Long> countTheNumberOfrepeatedValuesInTheString = newStr.chars().mapToObj(c->(char)c)
		.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(countTheNumberOfrepeatedValuesInTheString);
		
		
		
		
	}

}
