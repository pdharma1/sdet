package com.fnmae.utils;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fnmae.beans.Account;
import com.fnmae.dao.impl.AccountImpl;
import com.fnmae.dao.interfaces.IAccount;

public class AccountMain {

	public static void main(String[] args) throws IOException {

		Account account = new Account();
		IAccount iAccount = new AccountImpl();
		char c1, c2, c3;
		int id = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// System.out.println("Max Account number before inserts: " +
		// iAccount.getMaxAccountId());

		/* one time data generation */
		// for (int i = 2; i <= 10; i++) {
		// account.setAccountNumber(1000 + i);
		// account.setAccountBalance(10000 * i);
		// account.setAverageBalance(account.getAccountBalance() / i);
		//
		// iAccount.saveAccount(account);
		// }

		System.out.println("Max Account number after test inserts: " + iAccount.getMaxAccountId());

		System.out.println("All Accounts in the system: ");

		System.out.println("Id" + "\t" + "Account_No" + "\t" + "Acc_Balance" + "\t" + "Avg_Balance");
		System.out.println("-----------------------------------------------------------------------------");

		for (Account a : iAccount.getAllAccounts()) {
			System.out.println(a.getAccountId() + "\t" + a.getAccountNumber() + "\t\t" + a.getAccountBalance() + "\t\t" + a.getAverageBalance());
		}

		do {
			System.out.print("\n\n\n\nDo you want to update any account (Y/y) ?");
			c1 = br.readLine().toLowerCase().charAt(0);

			if (c1 == 'y') {
				System.out.print("\nEnter account id:");
				account.setAccountId(Integer.parseInt(br.readLine()));
//				account.setAccountId(id);

				System.out.print("\nEnter new account balance: ");
				account.setAccountBalance(Double.parseDouble(br.readLine()));

				System.out.print("\nEnter new average balance: ");
				account.setAverageBalance(Double.parseDouble(br.readLine()));

				iAccount.updateAccount(account);
				account = iAccount.getAccount(account.getAccountId());
				System.out.println("\n\nNew details for the account id: " + account.getAccountId() + " are: " + account);
				
				for (Account a : iAccount.getAllAccounts()) {
					System.out.println(a.getAccountId() + "\t" + a.getAccountNumber() + "\t\t" + a.getAccountBalance() + "\t\t" + a.getAverageBalance());
				}
				
			} else {
				System.out.println("\n\nThanks. Good bye.");
				break;
			}
		} while (c1 == 'y');
	}
}
