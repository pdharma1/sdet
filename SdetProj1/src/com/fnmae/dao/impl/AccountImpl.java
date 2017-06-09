package com.fnmae.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fnmae.beans.Account;
import com.fnmae.dao.interfaces.IAccount;

public class AccountImpl implements IAccount {

	private Connection connection = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	private String maxIdSql = "select max(id) from account;";
	private String allAccountsSql = "select * from account;";
	private String saveAccount = "INSERT INTO account (`Account_No`, `Balance`, `Average_Balance`) VALUES (?,?,?);";
	private String accountsCount = "select count(*) from account;";
	private String accountIdQuery = "select * from account where id=?;";
	private String updateAccountQuery = "UPDATE `test`.`account` SET `Balance` = ?,`Average_Balance` = ? WHERE `id` = ?;";

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accounts = new ArrayList<Account>();

		GetMySQLConnection mySql = new GetMySQLConnection();
		try {
			connection = mySql.getMySQlConnection();
			ps = connection.prepareStatement(allAccountsSql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Account account = new Account();
				account.setAccountNumber(rs.getInt("account_no"));
				account.setAccountBalance(rs.getDouble("balance"));
				account.setAverageBalance(rs.getDouble("average_balance"));
				account.setAccountId(rs.getInt("id"));
				accounts.add(account);
			}
		} catch (Exception e) {
			accounts = null;
			e.printStackTrace();
		}
		return accounts;
	}

	@Override
	public int getMaxAccountId() {
		int maxAccountId = 0;
		GetMySQLConnection mySql = new GetMySQLConnection();
		try {
			connection = mySql.getMySQlConnection();
			ps = connection.prepareStatement(maxIdSql);
			rs = ps.executeQuery();
			while (rs.next()) {
				maxAccountId = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return maxAccountId;
	}

	@Override
	public void saveAccount(Account account) {
		GetMySQLConnection mySql = new GetMySQLConnection();
		try {
			connection = mySql.getMySQlConnection();
			ps = connection.prepareStatement(saveAccount);
			ps.setInt(1, account.getAccountNumber());
			ps.setDouble(2, account.getAccountBalance());
			ps.setDouble(3, account.getAverageBalance());
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public int getAccountsCount() {
		GetMySQLConnection mySql = new GetMySQLConnection();
		int count = 0;
		try {
			connection = mySql.getMySQlConnection();
			ps = connection.prepareStatement(accountsCount);
			ResultSet rs = ps.executeQuery(accountsCount);
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return count;
	}

	@Override
	public void updateAccount(Account account) {
		GetMySQLConnection mySql = new GetMySQLConnection();
		try {
			connection = mySql.getMySQlConnection();
			ps = connection.prepareStatement(updateAccountQuery);
			ps.setDouble(1, account.getAccountBalance());
			ps.setDouble(2, account.getAverageBalance());
			ps.setInt(3, account.getAccountId());
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Account getAccount(int accountId) {

		Account account = new Account();
		GetMySQLConnection mySql = new GetMySQLConnection();
		try {
			connection = mySql.getMySQlConnection();
			ps = connection.prepareStatement(accountIdQuery);
			ps.setInt(1, accountId);
			rs = ps.executeQuery();
			while (rs.next()) {
				account.setAccountNumber(rs.getInt("account_no"));
				account.setAccountBalance(rs.getDouble("balance"));
				account.setAverageBalance(rs.getDouble("average_balance"));
				account.setAccountId(rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return account;
	}
}
