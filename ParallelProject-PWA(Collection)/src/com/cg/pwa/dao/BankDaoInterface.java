package com.cg.pwa.dao;

import com.cg.pwa.dto.Customer;
import com.cg.pwa.exception.CustomerAccountException;

public interface BankDaoInterface 
{
	public void createAccount(Customer customer);
	public void deposit(String custMobile, double custamount);
	public void withdraw(String custMobile, double withdrawAmount);
	public double checkBalance(String custMobile);
	public void fundTransfer(String sender, String reciever, double custamount);
	public boolean validateAccount(String custMobile) 
			throws CustomerAccountException;
}
