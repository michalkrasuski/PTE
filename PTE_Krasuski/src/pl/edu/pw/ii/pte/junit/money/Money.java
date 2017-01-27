package pl.edu.pw.ii.pte.junit.money;

class Money {
	private int fAmount;
	private String fCurrency;

	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}

	public int amount() {
		return fAmount;
	}

	public String currency() {
		return fCurrency;
	}

	public Money add(Money m) {
		return new Money(amount() + m.amount(), currency());
	}

	public boolean equals(Object anObject) {
		if (anObject instanceof Money) {
			Money a = (Money) anObject;

			return a.currency().equals(currency()) && amount() == a.amount();
		}
		return false;

	}
	
	public Money mul(int i) {
		return new Money(amount() * i, currency());
	}
	
	public double exchangeRate(){
		if (fCurrency == "CHF") return 4.0;
		else if (fCurrency == "PLN") return 2.0;
		else return 0; 
	}
	
	public Money addDifCurrency (Money m){
		return new Money(amount() + (int)(m.amount() * (m.exchangeRate() / this.exchangeRate())), currency());
	}
	
	public boolean isSameValue(Money m){
		return amount() == (int)(m.amount() * (m.exchangeRate() / this.exchangeRate()));
	}
}