package com.fnmae.dao.impl;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fnmae.beans.Account;


public class TestMaxAccountId {

	private static int maxAccountIdBeforeTest = 0;
	private static int accountsCount = 0;

	private static GetMySQLConnection mysql = null;
	private static Connection connection = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	private static String maxIdSql = "select max(id) from account;";
	private static String accountsCountSql = "select count(*) from account;";
	private static String saveAccount = "INSERT INTO account (`Account_No`, `Balance`, `Average_Balance`) VALUES (?,?,?);";
	private static Account newAccount;

	@Before
	public void getMaxAccountId() {
		try {
			mysql = new GetMySQLConnection();
			connection = mysql.getMySQlConnection();
			ps = connection.prepareStatement(maxIdSql);
			rs = ps.executeQuery(maxIdSql);
			while (rs.next()) {
				maxAccountIdBeforeTest = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Before
	public void getAccountsCount() {
		try {
			mysql = new GetMySQLConnection();
			connection = mysql.getMySQlConnection();
			ps = connection.prepareStatement(accountsCountSql);
			rs = ps.executeQuery(accountsCountSql);
			while (rs.next()) {
				accountsCount = rs.getInt(1);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Before
	public  void saveAccount() {
		AccountImpl ai = new AccountImpl();
		GetMySQLConnection mySql = new GetMySQLConnection();
		try {
			connection = mySql.getMySQlConnection();
			ps = connection.prepareStatement(saveAccount);
			ps.setInt(1, 2011);
			ps.setDouble(2, 200000);
			ps.setDouble(3, 2000);
			ps.executeUpdate();
			newAccount = ai.getAccount(ai.getMaxAccountId());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test(timeout = 100)
	public void testNewAccount() {
		AccountImpl i = new AccountImpl();
		assertEquals(newAccount.getAccountId(), i.getAccount(i.getMaxAccountId()).getAccountId());
	}

	/* Failing this test case on timeout range */
	@Test(timeout = 10)
	public void testGetMaxAccountId() {
		AccountImpl i = new AccountImpl();
		assertEquals(maxAccountIdBeforeTest, i.getMaxAccountId());
	}

	@Test(timeout = 100)
	public void testAccountsCounts() {
		AccountImpl i = new AccountImpl();
		assertEquals(accountsCount, i.getAccountsCount());
	}

}
