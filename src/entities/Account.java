package entities;

public class Account {
	
	private int balance;

	public Account(){
		balance = 30000;
	}
	
	public int getBalance(){
		return balance;
	}
	
	public void setBalace(int balance){
		this.balance = balance;
	}
	
	public void addBalance(int balance){
		this.balance = this.balance + balance;
	}
	
	public boolean enoughMoney(int price){
		return balance >= price;
	}
}