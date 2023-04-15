package bank;

public class Girokonto extends Konto
{

	private double giroGebuehr;
	
	public Girokonto(int pKontonummer, double pKontostand, double pGiroGebuehr)
	{
		super(pKontonummer,pKontostand);
		giroGebuehr=pGiroGebuehr;
		
	}

	public double getGiroGebuehr()
	{
		return giroGebuehr;
	}

	public void setGiroGebuehr(double giroGebuehr)
	{
		this.giroGebuehr = giroGebuehr;
	}

	public double berechneGiroGebuehr()
	{
		kontostand = Math.round(100.0*(kontostand - giroGebuehr))/100.0;
		return kontostand;
	}

	
}
