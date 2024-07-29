
public class SavingsAccount extends BankAccount {
	private double rate = .025;
	private int savingsNumber;
	private String accountNumber;
	
	public SavingsAccount(String name, double initBalance) {
		super(name, initBalance);
		this.accountNumber = super.getAccountNumber();
		super.setAccountNumber(this.accountNumber);
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
		
		
	}
	
	//copy constructor
	public SavingsAccount(SavingsAccount anotherSaving, double initBalance) {
		super(anotherSaving, initBalance);
		this.savingsNumber = anotherSaving.savingsNumber + 1;
		super.setAccountNumber(super.getAccountNumber());
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
		
		
		
	}
	
	public void postInterest() {
		
		double newBalance = getBalance() * (rate / 12);
		deposit(newBalance);
	}
	
	@Override
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	
}
