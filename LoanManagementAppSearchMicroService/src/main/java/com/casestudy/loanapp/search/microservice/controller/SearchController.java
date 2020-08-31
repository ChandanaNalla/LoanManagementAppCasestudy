package com.casestudy.loanapp.search.microservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.loanapp.search.microservice.entity.LoanInformation;
import com.casestudy.loanapp.search.microservice.exception.LoanNotFoundException;
import com.casestudy.loanapp.search.microservice.service.SearchServiceImpl;


@RestController
@RequestMapping("/search")
public class SearchController {
	
	// default constructor
	public SearchController() {
	}
	
	@Autowired
	private SearchServiceImpl searchService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	List<LoanInformation> loanList = new ArrayList<LoanInformation>();
	
	Iterable<LoanInformation> loanIterator;
	
	// Search Loan by loan number
    @GetMapping("/loan")
	public List<LoanInformation> findAll() {
    	
    	loanIterator = searchService.findAll();
    	
    	loanIterator.forEach(loanList::add);
			
		return loanList;
			
	}
		
	// Search Loan by loan number
	@GetMapping("/loan/{id}")
	public LoanInformation findById(@PathVariable("id") int loanId) {
		
		Optional<LoanInformation> loanInfo = searchService.findById(loanId);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the loan id " +loanId));
		 
		return loanInfo.get();
		
	}
	
	// Search Loan by loan amount
	@GetMapping("/loanByAmount/{amount}")
	public List<LoanInformation> findByAmount(@PathVariable("amount") double amount) {
		
        List<LoanInformation> loanList = null;
		
		Optional<List<LoanInformation>> loanInfo = searchService.findByAmount(amount);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found wiht the loan amount " +amount));
		
		for(LoanInformation loan : loanInfo.get()) {
			
			loanList= Arrays.asList(loan);	
		}		
		return loanList;		
	}
	
	// Search Loan by borrower name
	@GetMapping("/loanByBorrowerName/{borrowerName}")
	public List<LoanInformation> findByBorrowerName(@PathVariable("borrowerName") String borrowerName) {
			
        List<LoanInformation> loanList = null;
		
		Optional<List<LoanInformation>> loanInfo = searchService.findByBorrowerName(borrowerName);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the borrower name " +borrowerName));
		
		for(LoanInformation loan : loanInfo.get()) {
			
			loanList= Arrays.asList(loan);	
		}		
		return loanList;
			
	}
	
	// create a new loan resource
	@PostMapping("/loan")
	public LoanInformation createLoan(@RequestBody LoanInformation loanInfo) {
		
		return searchService.save(loanInfo);
	}
	
	//Search Loan by borrower name and amount
	@GetMapping("/loanByNameAndAmount/{borrowerName}/{amount}")
	public List<LoanInformation> findByBorrowerNameAndAmount(@PathVariable("borrowerName") String borrowerName,
			@PathVariable("amount") double amount){
		
		List<LoanInformation> loanList=null;
		
		Optional<List<LoanInformation>> loanInfo=searchService.findByBorrowerNameAndAmount(borrowerName, amount);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with the borrower name and amount"
				+borrowerName+","+amount));
		
		for(LoanInformation loan :loanInfo.get()) {
			loanList=Arrays.asList(loan);
		}
		return loanList;
	}
	//Search Loan by borrower name and number
	@GetMapping("/loanByNameAndId/{borrowerName}/{id}")
	public List<LoanInformation> findByBorrowerNameAndId(@PathVariable("borrowerName") String borrowerName,
			@PathVariable("id") int loanId){
		
		List<LoanInformation> loanList=null;
		
		Optional<List<LoanInformation>> loanInfo=searchService.findByBorrowerNameAndId(borrowerName, loanId);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with borrower name and id" 
				+borrowerName+","+loanId));
		
		for(LoanInformation loan :loanInfo.get()) {
			loanList=Arrays.asList(loan);
		}
		return loanList;
	}
	//search by loan amount and number
	@GetMapping("/loanByAmountAndId/{amount}/{id}")
	public List<LoanInformation> findByAmountAndId(@PathVariable("amount") double amount,
			@PathVariable("id") int loanId){
		
		List<LoanInformation> loanList=null;
		
		Optional<List<LoanInformation>> loanInfo=searchService.findByAmountAndId(amount, loanId);
		
		loanInfo.orElseThrow(() -> new LoanNotFoundException("Loan not found with amount and id"
				+amount+","+loanId));
		
		for(LoanInformation loan :loanInfo.get()) {
			loanList=Arrays.asList(loan);
		}
		return loanList;
	}
	
	
}
