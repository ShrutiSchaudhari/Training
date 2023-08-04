package com.SpringAOP.AOPDemo.DAO;

import java.util.List;

import com.SpringAOP.AOPDemo.Account;

public interface AccountDAO {

	public void addAccount(Account theAccount, boolean vipFlag);
	
	boolean doWork();
	
	public String getName() ;

	public void setName(String name) ;

	public String getServiceCode();

	public void setServiceCode(String serviceCode);
	
	public List<Account> findAccount();

	public List<Account> findAccount(boolean tripWire);
	
}
