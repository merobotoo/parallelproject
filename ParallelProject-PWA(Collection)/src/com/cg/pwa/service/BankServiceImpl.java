package com.cg.pwa.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.pwa.dao.BankDaoImpl;
import com.cg.pwa.dao.BankDaoInterface;
import com.cg.pwa.dto.Customer;
import com.cg.pwa.exception.CustomerAccountException;

public class BankServiceImpl implements BankServiceInterface 
{

	BankDaoInterface bankDao=new BankDaoImpl();
	
	@Override
	public void createAccount(Customer customer) 
	{
		bankDao.createAccount(customer);
	}

	@Override
	public void deposit(String custMobile, double amount) 
	{
		bankDao.deposit(custMobile, amount);
	}

	@Override
	public void withdraw(String custMobile, double amount) 
	{
		bankDao.withdraw(custMobile, amount);
	}

	@Override
	public double checkBalance(String custMobile)
	{
		return bankDao.checkBalance(custMobile);
	}

	@Override
	public void fundTransfer(String sender, String reciever, double amount) 
	{
		bankDao.fundTransfer(sender, reciever, amount);
		
	}

	@Override
	public boolean validateAccount(String custMobile)
			throws CustomerAccountException 
	{
		return bankDao.validateAccount(custMobile);
	}

	@Override
	public boolean validateName(String custName)
			throws CustomerAccountException 
	{
		if(custName == null)
			throw new CustomerAccountException("Null value found");
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{1,10}");
		Matcher m = p.matcher(custName); 
		if(!m.matches())
			System.out.println("Invalid Name.. Name should start with "
					+ "capital letter");
		return m.matches();
		
	}

	@Override
	public boolean validateAge(float custAge) throws 
		CustomerAccountException 
	{
		try{
				if(custAge == 0)
					throw new CustomerAccountException("Age cannot be  null");
				else if(custAge >100)
					throw new CustomerAccountException("Age cannot be  greater "
							+ "than 100");
				else if(custAge < 0)
					throw new CustomerAccountException("Age cannot be a "
							+ "negative");
				else if(custAge >17)
					return true;
				
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
			return false;
	}

	@Override
	public boolean validateMoileNo(String custMobile)
			throws CustomerAccountException 
	{
		try
		{
			if(custMobile == null)
				throw new CustomerAccountException("Null value found");
			Pattern p = Pattern.compile("[6789][0-9]{9}");
			Matcher m = p.matcher(custMobile);
			if(!m.matches())
				System.out.println("Mobile Number is Invalid... Please enter valid Mobile Number...");
			return m.matches();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean validateAmount(double custamount)
			throws CustomerAccountException 
	{
		if(custamount == 0)
			throw new CustomerAccountException("Null value found exception...");
		String am = String.valueOf(custamount);
		if(!am.matches("\\d{3,9}\\.\\d{0,4}"))
		{
			System.out.println("Invalid Amount Minimum transaction "
					+ "amount should be 100 ");
		}
		return (am.matches("\\d{3,9}\\.\\d{0,4}"));
	}

	
}
