
public class CheckingAccount extends BankAccount {
	private final static double FEE = 0.15;
	
	
	public CheckingAccount(String name, double initAmnt) {
		super(name, initAmnt);
		super.setAccountNumber(super.getAccountNumber() + "-10");
		
	}
	
	@Override
	public boolean withdraw(double amount) {
		return super.withdraw(amount + FEE);
	}
}
