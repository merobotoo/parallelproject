package com.cg.pwa.dao;

import java.util.HashMap;
import java.util.Map;

import com.cg.pwa.dto.Customer;
import com.cg.pwa.exception.CustomerAccountException;

public class BankDaoImpl implements BankDaoInterface
{

Map<String,Customer> customerMap;
	
	public BankDaoImpl()
	{
		customerMap = new HashMap<>();
		customerMap.put("9764731441", new Customer("9764731441", "Gayatri", 22, 800));
		customerMap.put("9600144180", new Customer("9600144180", "Aakash", 51, 2300));
		customerMap.put("9765078805", new Customer("9765078805", "Apoorva", 18, 98700));
		customerMap.put("7096878090", new Customer("7096878090", "Santosh", 32, 2000));
		customerMap.put("7096871190", new Customer("7096871190", "Sayali", 28, 2000));
	}
	
	@Override
	public void createAccount(Customer customer) 
	{
		customerMap.put(customer.getCustMobile(),customer);
	}

	@Override
	public void deposit(String custMobile, double custamount) 
	{
		Customer customer = customerMap.get(custMobile);
		if(customer != null)
		{
			double updateAmount = customer.getCustInitialBalance();
			updateAmount += custamount;
			String custName = customer.getCustName();
			String custMobileNo = customer.getCustMobile();
			float custAge = customer.getCustAge();
			
			customer.setCustAge(custAge);
			customer.setCustInitialBalance(updateAmount);
			customer.setCustName(custName);
			customer.setCustMobile(custMobileNo);
		
			System.out.println("Amount deposited! New balance: "+ customer.getCustInitialBalance());
		}
		
	}

	@Override
	public void withdraw(String custMobile, double withdrawAmount) 
	{
		Customer customer = customerMap.get(custMobile);
		if(customer != null)
		{
			double amount = customer.getCustInitialBalance();	
			
			String name = customer.getCustName();
			String newMobileNo = customer.getCustMobile();
			float age = customer.getCustAge();
			
			if(amount - withdrawAmount > 500)
			{
				amount -= withdrawAmount;
				customer.setCustAge(age);
				customer.setCustInitialBalance(amount);
				customer.setCustName(name);
				customer.setCustMobile(newMobileNo);
				
				customerMap.put(newMobileNo, customer);
				System.out.println("New balance: "+ 
						amount);
				
			}
			else
			{
				System.out.println("Cannot withdraw! Minimum balance"
						+ "should be maintained 500");
			}
		}
		else
		{
			System.out.println("Mobile number not found");
		}
	}

	@Override
	public double checkBalance(String custMobile) 
	{
		Customer custCheckBalance = customerMap.get(custMobile);
		double amount = custCheckBalance.getCustInitialBalance();
		return amount;
	}

	@Override
	public void fundTransfer(String sender, String reciever, double custamount) 
	{
		String custName, custMobileNo;
		float custAge;
		
		Customer customerSender =  customerMap.get(sender);
		Customer customerReciever = customerMap.get(reciever);
		
		double reciever_Amount = customerReciever.getCustInitialBalance();
		double sender_Amount = customerSender.getCustInitialBalance();
		if(sender_Amount - custamount > 500)
		{
			reciever_Amount += custamount;
			sender_Amount -= custamount;
			custName = customerSender.getCustName();
			custMobileNo = customerSender.getCustMobile();
			custAge = customerSender.getCustAge();
		
			
			customerSender.setCustAge(custAge);
			customerSender.setCustInitialBalance(sender_Amount);
			customerSender.setCustMobile(custMobileNo);
			customerSender.setCustName(custName);
			
			customerMap.put(custMobileNo, customerSender);
			
			custName = customerReciever.getCustName();
			custMobileNo = customerReciever.getCustMobile();
			custAge = customerReciever.getCustAge();
			
			
			customerReciever.setCustAge(custAge);
			customerReciever.setCustInitialBalance(reciever_Amount);
			customerReciever.setCustMobile(custMobileNo);
			customerReciever.setCustName(custName);
			
			customerMap.put(custMobileNo, customerReciever);	
			System.out.println("Fund Transferred! new balance :"+sender_Amount);
		}
		else
		{
			System.out.println("Cannot transfer! Minimum balance of 100 should "
					+ "be maintained in Sender's account");
		}
		
		
	}

	@Override
	public boolean validateAccount(String custMobile)
			throws CustomerAccountException 
	{
		Customer customer = customerMap.get(custMobile);
		if(customer == null)
			return false;
		return true;
		
	}

}
