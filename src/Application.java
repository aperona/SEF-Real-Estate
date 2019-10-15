
public class Application {

	private double amount;
	private Property p;
	private int contractLength;
	
	public Application(Property p, double amount) {
		this.amount = amount;
		this.p = p;
	}
	
	public Application(Property p, double amount, int contract) {
		this.p = p;
		this.amount = amount;
		this.contractLength = contract;
	}
	
	public void acceptApplication() {
		if(p instanceof Sale) {
			p.sell(amount);
		}else if(p instanceof Rental) {
			p.rent(amount, contractLength);
		}
	}
	
}
