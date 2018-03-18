package bb;

import java.io.*; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
class Fund_Exception extends Exception{
	private double amount;
	public Fund_Exception(double amount){
		this.amount = amount;
	} 
	public double getAmount(){
		return amount;
		}
	}
	abstract class Account{
		private String name; 
		public String id; 
		private double balance; 
		public void setBalance(double balance){
			this.balance = balance;
		}
		public double getBalance(){
			return balance;
		} 
		public Account(String name, String id, double balance){
			super();
			this.name = name;
			this.id = id;
			this.balance = balance;
		}
		public Account(String name, String id) {
			super();
			this.name = name;
			this.id = id;
		}
		public void deposit(double amount){
			this.balance+=amount;
		}
		abstract void withdraw(double amount)throws Fund_Exception;
		abstract void findOverdraw();
	}
	class CashAccount extends Account {
		public String cashsort;
		public String getCashsort() {
			return cashsort;
		}
		public void setCashsort(String cashsort) {
			this.cashsort = cashsort;
		}
		public CashAccount(String name, String id, double balance, String cashsort) {
			super(name, id, balance);
			this.cashsort = cashsort;
		}
		public void  withdraw(double amount)throws Fund_Exception {
				if(this.getBalance()>=amount){
					this.setBalance(this.getBalance()-amount);
				}
				else{
					double needs = amount - this.getBalance();
					throw new Fund_Exception(needs);
				}
		}
		void findOverdraw(){}
	}

	class CreditAccount extends Account {
		double staticoverdraw;
		double overdraw;
		public CreditAccount(String name, String id, double balance,double staticoverdraw, double overdraw) {
			super(name, id, balance);
			this.staticoverdraw = staticoverdraw;
			this.overdraw = overdraw;
		}
		public void  findOverdraw(){
			if(this.getBalance()<0){
				System.out.println("Í¸Ö§");
				overdraw=-(this.getBalance());
			}
			else {
				System.out.println("Î´Í¸Ö§");
		
			}
		}
		public void  withdraw(double amount){
			if(this.getBalance()+staticoverdraw>=amount){
				this.setBalance(this.getBalance()-amount);
			}
			else{
				System.out.println("´íÎó");
			}
		}
	}

	public class Test {
		public static void main(String[] args){
			Account credit=new CreditAccount("zqq","20094070149",0,500,0);
			Account debit=new CashAccount("zsq","20094070101",0,"½è¼Ç¿¨");
			credit.deposit(500);
			debit.deposit(500);
			try{
				credit.withdraw(200);
				debit.withdraw(200);
				credit.withdraw(400);
				debit.withdraw(400);
			}
			catch(Fund_Exception e){
				System.out.println("Your CashAccount overdraw $" + e.getAmount());
			}
			finally{
				System.out.println("credit balance  "+credit.getBalance());
				System.out.println("cash balance "+debit.getBalance());
				credit.findOverdraw();
			}
		}
	}

