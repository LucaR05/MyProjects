package paket_Fachklassen;

public class Artikel
{   private String artikelNr = new String();
    private String bezeichnung = new String();
    private double preis;
    private int bestand;

    
    public Artikel(String pArtikelNr)
    {  artikelNr = pArtikelNr;
    }
    
    public String getArtikelNr()
    {  return artikelNr;
    }
    public String getBezeichnung()
    {  return bezeichnung;
    }
    public double getPreis()
    {  return preis;
    }
    public int getBestand()
    {  return bestand;
    }
    
    public void setArtikelNr(String pNeueNummer)
    {  artikelNr = pNeueNummer;   
    }
    public void setBezeichnung(String pBezeichnung)
    {  bezeichnung = pBezeichnung;
    }
    public void setPreis(double pPreis)
    {  preis = pPreis;
    }   
    public void mehren(int pStueck)
    {  bestand = bestand + pStueck;
    }
    public boolean mindern(int pStueck)
    {  if(bestand - pStueck >= 0)
        { bestand = bestand - pStueck; 
        return true;
        }
    else {
    	return false;
    }
    }
    

   
}
