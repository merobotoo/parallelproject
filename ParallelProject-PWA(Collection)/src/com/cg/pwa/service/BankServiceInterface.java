package com.cg.pwa.service;

import com.cg.pwa.dto.Customer;
import com.cg.pwa.exception.CustomerAccountException;

public interface BankServiceInterface 
{
	public void createAccount(Customer customer);
	public void deposit(String custMobile, double custamount);
	public void withdraw(String custMobile, double custamount);
	public double checkBalance(String custMobile);
	public void fundTransfer(String sender, String reciever, double custamount);
	public boolean validateAccount(String custMobile) throws CustomerAccountException;
	public boolean validateName(String custName) throws CustomerAccountException;
	public boolean validateAge(float custAge) throws CustomerAccountException;
	public boolean validateMoileNo(String custMobile) throws CustomerAccountException;
	public boolean validateAmount(double custamount) throws CustomerAccountException;
}
