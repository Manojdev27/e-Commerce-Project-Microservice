package com.techmahindra.interviewservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



//@RestController
public class PaymentController {

////	1. get api paymentId as parameter and payment name as a query parameter
////	2. post api payment details as a request
////	3. put api save and update the payment details
////	4. delete api will be accepting payment id as a path parameter
//	
//	@Autowired
//	private PaymentRepository paymentRepository;
//	
//	@PostMapping("/payment")
//	public Payment newPaymnet(@RequestBody Payment newPaymnet) {
//		
//		return paymentRepository.save(payment);
//	}
//	
//	@PutMapping("/{id}/payment")
//	public Payment updatePayment(@PathVariable int id,@RequestBody Payment newPayment) {
//		
//		return paymentRepository.save(payment);
//	}
//	
//	@DeleteMapping("/{id}")
//	private int deletePayment(@PathVariable int id) {
//		return paymentRepository.deleteById(id);
//	}
//	
//	@GetMapping("/{id}")
//	public Optional<Payment> getPayment(@PathVariable int id, String name){
//		
//	}
	
public static void main(String[] args) {
	

//1.filter 
//2. sorted it by name and type 
//
//payments.stream().filter(x->x>10000).collect(Collectors.groupingBy(x->x.getName),Collectors.groupingBy(x->x.getpaymentType))


}
	
}
	
