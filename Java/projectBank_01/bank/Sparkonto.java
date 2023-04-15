package bank;

public class Sparkonto extends Konto
{

	private double sparZinssatz;
	
	public Sparkonto(int pKontonummer, double pKontostand,double pSparZinssatz){
		super(pKontonummer,pKontostand);
		sparZinssatz= pSparZinssatz;
	}
	

	public double getSparZinssatz()
	{
		return sparZinssatz;
	}

	public void setSparZinssatz(double sparZinssatz)
	{
		this.sparZinssatz = sparZinssatz;
	}

	public double verzinsen(int pTage)
	{
		//kontostand=kontostand*(1+sparZinssatz/100)*pTage/360;
		kontostand=kontostand+kontostand*sparZinssatz/360/100*pTage;
		//kontostand=+kontostand*sparZinssatz/360/100*pTage;
		
		return kontostand;
	}



}
