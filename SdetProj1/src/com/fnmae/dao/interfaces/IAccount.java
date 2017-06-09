package com.fnmae.dao.interfaces;

import java.util.List;

import com.fnmae.beans.Account;

public interface IAccount {

	public List<Account> getAllAccounts();
	
	public int getMaxAccountId();
	
	public void saveAccount(Account account);
	
	public int getAccountsCount();
	
	public void updateAccount(Account account);
	
	public Account getAccount(int accountId);
}
