package vuko.ljetnizadatak;

public class HranaIPice {
	
	private int sifra;
	private String naziv;
	private float cijena;
	
	public HranaIPice() {
		
	}

	public HranaIPice(int sifra, String naziv, float cijena) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.cijena = cijena;
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

	public void setCijena(int cijena) {
		this.cijena = cijena;
	}
	
	@Override
	public String toString() {
		return naziv;
	}
	

}
