package com.fnmae.beans;

public class Account implements Comparable<Account>{

	private int accountId;
	private int accountNumber;
	private double accountBalance;
	private double averageBalance;
	
	public Account() {
		
	}

	public Account(int accountNumber, double accountBalance, double averageBalance) {
		super();
		this.accountNumber = accountNumber;
		this.accountBalance = accountBalance;
		this.averageBalance = averageBalance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public double getAverageBalance() {
		return averageBalance;
	}

	public void setAverageBalance(double averageBalance) {
		this.averageBalance = averageBalance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "\nAccount [accountId=" + accountId + ", \naccountNumber=" + accountNumber + ", \naccountBalance=" + accountBalance
				+ ", \naverageBalance=" + averageBalance + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(accountBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + accountId;
		result = prime * result + accountNumber;
		temp = Double.doubleToLongBits(averageBalance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (this == obj)
			result= true;
		if (obj == null)
			result=  false;
		if (getClass() != obj.getClass())
			result=  false;
		
		Account other = (Account) obj;
		if (Double.doubleToLongBits(accountBalance) != Double.doubleToLongBits(other.accountBalance))
			result=  false;
		if (accountId != other.accountId)
			result=  false;
		if (accountNumber != other.accountNumber)
			result=  false;
		if (Double.doubleToLongBits(averageBalance) != Double.doubleToLongBits(other.averageBalance))
			result=  false;
		return result;
	}

	@Override
	public int compareTo(Account o) {
		int result=1;
		
		if(o.getAccountId()==this.getAccountId()) {
			result=0;
		}
		return result;
	}
	
	

}
