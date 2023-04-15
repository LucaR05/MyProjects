package bank;

public abstract class Konto
{
	public int kontonummer;
	public double kontostand;

	public Konto(int pKontonummer, double pKontostand)
	{
		kontonummer=pKontonummer;
		kontostand=pKontostand;
	}

	public int getKontonummer()
	{
		return kontonummer;
	}

	public void setKontonummer(int kontonummer)
	{
		this.kontonummer = kontonummer;
	}

	public double getKontostand()
	{
		return kontostand;
	}

	public void setKontostand(double kontostand)
	{
		this.kontostand = kontostand;
	}

	public double einzahlen(double pEinzahlung)
	{
		kontostand=kontostand+pEinzahlung;
		return kontostand;
	}

	public double auszahlen(double pAuszahlungsbetrag)
	
	{
		kontostand=kontostand-pAuszahlungsbetrag;
		return kontostand;
	}
}
