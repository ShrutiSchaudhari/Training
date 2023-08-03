package com.SpringAOP.AOPDemo.DAO;

import org.springframework.stereotype.Repository;

import com.SpringAOP.AOPDemo.Account;

@Repository
public class AccountDAOImpl implements AccountDAO{

	@Override
	public void addAccount(Account theAccount,boolean theVipFag) {
		
		System.out.println(getClass()+"Doing my DB work- Opening new account");
		
	}

}
