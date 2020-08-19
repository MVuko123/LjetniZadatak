package vuko.ljetnizadatak;

public class Film {
	
	private int sifra;
	private String naziv;
	private String redatelj;
	private int godina;
	private float ocjena;
	
	public Film() {
		
	}

	public Film(int sifra, String naziv, String redatelj, int godina, float ocjena) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.redatelj = redatelj;
		this.godina = godina;
		this.ocjena = ocjena;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getRedatelj() {
		return redatelj;
	}

	public void setRedatelj(String redatelj) {
		this.redatelj = redatelj;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public float getOcjena() {
		return ocjena;
	}

	public void setOcjena(int ocjena) {
		this.ocjena = ocjena;
	}
	
	
	

}
