
			
package com.cg.pwa.ui;

import java.util.Scanner;

import com.cg.pwa.dto.Customer;
import com.cg.pwa.exception.CustomerAccountException;
import com.cg.pwa.service.BankServiceImpl;
import com.cg.pwa.service.BankServiceInterface;

public class TestCustomerClient 
{
	private static final String mobileNo = null;
	static Scanner sc=null;
	static BankServiceInterface bankSer=null;
	static String custName,custMobile;
	static float custAge;
	static double custamount;
	static Customer customer=null;
	private static String mobileNoReciever;
	
	public static void main(String[] args)
	{
		sc =new Scanner(System.in);
		bankSer=new BankServiceImpl();
		int choice=0;
		while(true)
		{
			System.out.println(" 1.CREATE ACCOUNT\n 2.DEPOSIT AMOUNT");
			System.out.println(" 3.SHOW BALANCE\n 4.WITHDRAW MONEY"); 
			System.out.println(" 5.TRANSFER FUND\n 6.EXIT ");
			System.out.println(" Enter your choice : ");
			choice=sc.nextInt();
			
			switch (choice) 
			{
				case 1:createAccount();break;
				case 2:deposit();break;
				case 3:checkBalance();break;
				case 4:withdraw();break;
				case 5:fundTransfer();break;
				default:System.exit(0);
			}
		}

	}

	private static void fundTransfer() 
	{
		
		String mobileNoOfR;
		System.out.println("Enter your mobile number : ");
		custMobile = sc.next();
		try {
			if(bankSer.validateMoileNo(custMobile))
			{
				if(bankSer.validateAccount(custMobile))
				{
					System.out.println("Enter the amount : ");
					custamount = sc.nextDouble();
					if(bankSer.validateAmount(custamount))
					{
						System.out.println("Enter receivers mobile number : ");
						mobileNoOfR = sc.next();
						if(bankSer.validateMoileNo(mobileNoOfR))
						{
							if(bankSer.validateAccount(mobileNoOfR))
							{
								if(!custMobile.equals(mobileNoOfR))
								{
									bankSer.fundTransfer(custMobile,mobileNoOfR, custamount);
								}
								else
								{	
									System.out.println("Sender and receiver mobile number cannot be same...");
								}
							}
							else
							{
								System.out.println("Account doesnt exist...");
							}
						}
						else
						{
							System.out.println("Account doesnt exist...");
						}
					}
					else
					{
						System.out.println("Account doesnt exist...");
					}
				}
			}
		} catch (CustomerAccountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void withdraw() 
	{
		System.out.println("Enter your mobile no. : ");
		custMobile = sc.next();
		try 
		{
			if(bankSer.validateMoileNo(custMobile))
			{
				System.out.println("Enter amount : ");
				custamount = sc.nextDouble();
				if(bankSer.validateAmount(custamount))
				{
					if(bankSer.validateAccount(custMobile))
					{
						System.out.println("Amount withdrawn..");
					}
				}
			}
		} 
		catch (CustomerAccountException e) 
		{
			e.printStackTrace();
		}
		customer = new Customer();
		bankSer.withdraw(custMobile, custamount);
	}

	private static void checkBalance() 
	{
		System.out.println("Enter the mobile number to check balance");
		custMobile = sc.next();
		try 
		{
			if(bankSer.validateMoileNo(custMobile))
			{
				if(bankSer.validateAccount(custMobile))
				{		
					System.out.println("Current Amount "+bankSer.checkBalance(custMobile));
				}
				else
				{
					System.out.println("Account doesnt exists!");
				}
			} 
		}
		catch (CustomerAccountException e) 
		{
			e.printStackTrace();
		}
	}

	private static void deposit() 
	{
		System.out.println("Enter your mobile no. : ");
		custMobile = sc.next();
		try {
				if(bankSer.validateMoileNo(custMobile))
				{
					System.out.println("Enter an amount : ");
					custamount = sc.nextDouble();
					if(bankSer.validateAmount(custamount))
					{
						if(!bankSer.validateAccount(custMobile))
						{
							System.out.println("Account not found... Check your "
									+ "mobile number");
						}
					}
				}
			} 
			catch (CustomerAccountException e) 
			{
				e.printStackTrace();
			}
		bankSer.deposit(custMobile, custamount);		
		
	}

	private static void createAccount() 
	{
		// TODO Auto-generated method stub
		System.out.println("Enter customer name : ");
		custName = sc.next();

		try 
		{
			if(bankSer.validateName(custName))
			{
				System.out.println("Enter mobile no. : ");
				custMobile = sc.next();

				if(bankSer.validateMoileNo(custMobile))
				{
					System.out.println("Enter age : ");
					custAge = sc.nextFloat();

					if(bankSer.validateAge(custAge))
					{
						System.out.println("Enter initial amount : ");
						custamount = sc.nextDouble();

						if(bankSer.validateAmount(custamount))
						{

							if(bankSer.validateAccount(custMobile))
							{
								System.out.println("Account already exists...");
							}
							else
							{	customer = new Customer();
								customer.setCustName(custName);
								customer.setCustMobile(custMobile);
								customer.setCustAge(custAge);
								customer.setCustInitialBalance(custamount);
								bankSer.createAccount(customer);		
								System.out.println("Customer is added....");
							}
						}
					}
				}
					
			}
			
		} 
		catch (CustomerAccountException e) 
		{
			e.printStackTrace();
		}
	}

}
