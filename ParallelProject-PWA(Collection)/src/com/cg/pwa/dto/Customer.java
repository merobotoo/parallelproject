package com.cg.pwa.dto;

public class Customer 
{
	private String custName;
	private String custMobile;
	private float custAge;
	private double custAmount;
	
	public String getCustName() 
	{
		return custName;
	}
	public void setCustName(String custName) 
	{
		this.custName = custName;
	}
	public String getCustMobile() 
	{
		return custMobile;
	}
	public void setCustMobile(String custMobile) 
	{
		this.custMobile = custMobile;
	}
	public float getCustAge() 
	{
		return custAge;
	}
	public void setCustAge(float custAge) 
	{
		this.custAge = custAge;
	}
	public double getCustInitialBalance() 
	{
		return custAmount;
	}
	public void setCustInitialBalance(double custInitialBalance) 
	{
		this.custAmount = custInitialBalance;
	}
	
	public Customer() 
	{
		super();
	}
	
	public Customer(String custName, String custMobile, float custAge,
			double custInitialBalance)
	{
		super();
		this.custName = custName;
		this.custMobile = custMobile;
		this.custAge = custAge;
		this.custAmount = custInitialBalance;
	}
	
	
	
}
