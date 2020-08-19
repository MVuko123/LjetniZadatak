package vuko.ljetnizadatak;

public class PojeoPopio {
	
	private int sifra;
	private String naziv;
	private float cijena;
	private int kolicina;
	
	public PojeoPopio(int i, String string, float f, float g) {
		
	}

	public PojeoPopio(int sifra, String naziv, float cijena, int kolicina) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.cijena = cijena;
		this.kolicina = kolicina;
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

	public float getCijena() {
		return cijena;
	}

	public void setCijena(float cijena) {
		this.cijena = cijena;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	

}
