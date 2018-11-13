package com.cg.pwa.test;

import org.junit.Assert;
import org.junit.Test;

import com.cg.pwa.exception.CustomerAccountException;
import com.cg.pwa.service.BankServiceImpl;
import com.cg.pwa.service.BankServiceInterface;



public class TestClass {

	@Test(expected=CustomerAccountException.class)
    public void test_ValidateName_null() throws CustomerAccountException{
        BankServiceInterface service=new BankServiceImpl();
        service.validateName(null);
    }
    
    @Test
    public void test_validateName_v1() throws CustomerAccountException{
    
        String name="Aete121";
        BankServiceInterface service=new BankServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    @Test
    public void test_validateName_v2() throws CustomerAccountException{
    
        String name="Amita";
        BankServiceInterface service=new BankServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(true,result);
    }
    @Test
    public void test_validateName_v3() throws CustomerAccountException{
    
        String name="amita";
        BankServiceInterface service=new BankServiceImpl();
        boolean result= service.validateName(name);
        Assert.assertEquals(false,result);
    }
    @Test(expected=CustomerAccountException.class)
    public void test_ValidateMobNo_null() throws CustomerAccountException{
        BankServiceInterface service=new BankServiceImpl();
        service.validateMoileNo(null);
    }
    
    @Test
    public void test_validateMobNo_v1() throws CustomerAccountException{
    
        String mobNo="ABCD91828288";
        BankServiceInterface service=new BankServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
    @Test
    public void test_validateMobNo_v2() throws CustomerAccountException{
    
        String mobNo="9922974725";
        BankServiceInterface service=new BankServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(true,result);
    }
    @Test
    public void test_validateMobNo_v3() throws CustomerAccountException{
    
        String mobNo="992297";
        BankServiceInterface service=new BankServiceImpl();
        boolean result= service.validateMoileNo(mobNo);
        Assert.assertEquals(false,result);
    }
	

}
