package vuko.ljetnizadatak;

public class Kupac {
       
	private int sifra;
	private String ime;
	private String prezime;
	private String spol;
	private int dob;
	
	public Kupac() {

	}

	public Kupac(int sifra, String ime, String prezime, String spol, int dob) {
		super();
		this.sifra = sifra;
		this.ime = ime;
		this.prezime = prezime;
		this.spol = spol;
		this.dob = dob;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getSpol() {
		return spol;
	}

	public void setSpol(String spol) {
		this.spol = spol;
	}

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}
	
	@Override
	public String toString() {
		return prezime + " " + ime + " " + spol;
	}
}
