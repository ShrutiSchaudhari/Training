package com.SpringAOP.AOPDemo.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.SpringAOP.AOPDemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

	private String name;
	private String serviceCode;
	
	
	@Override
	public void addAccount(Account theAccount,boolean theVipFag) {
		
		System.out.println(getClass()+"Doing my DB work- Opening new account");
		
	}

	@Override
	public boolean doWork() {
		System.out.println(getClass()+": doWork()");
		return false;
	}

	public String getName() {
		System.out.println(getClass()+": getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": setServiceCode()");
		this.serviceCode = serviceCode;
	}

	@Override
	public List<Account> findAccount() {
	
		return findAccount(false);
	}

	@Override
	public List<Account> findAccount(boolean tripWire) {
		
		if (tripWire) {
			throw new RuntimeException("Error occured!!");
		}
		
		
		List<Account> myAccounts = new ArrayList<>();
		// create sample account
		Account temp1 = new Account("John","silver");
		Account temp2 = new Account("Madhu","platinum");
		Account temp3 = new Account("Petter","gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);
		//add them to list
		return myAccounts;
	}
	
	

}
