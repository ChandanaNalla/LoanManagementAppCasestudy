package com.casestudy.loanapp.search.microservice.service;
import java.util.List;
import java.util.Optional;

import com.casestudy.loanapp.search.microservice.entity.LoanInformation;

public interface SearchService {
	// get all the loans
	public Iterable<LoanInformation> findAll();
	
	// Search by Loan number
	public Optional<LoanInformation> findById(int loanId);
	
	// Search by Loan Amount
	public Optional<List<LoanInformation>> findByAmount(double amount);
	
	// Search by Borrower name
	public Optional<List<LoanInformation>> findByBorrowerName(String borrowerName);
	
	// Search by Borrower name
	public LoanInformation save(LoanInformation loanInfo);


	//Search by Borrower name and number
		public Optional<List<LoanInformation>> findByBorrowerNameAndId(String borrowerName,int loanId);
		
		//search by Borrower amount and number
		public Optional<List<LoanInformation>> findByAmountAndId(double amount,int loanId);
		
		//search by Borrower name and amount
		public Optional<List<LoanInformation>> findByBorrowerNameAndAmount(String borrowerName,double amount);
		
	
}
