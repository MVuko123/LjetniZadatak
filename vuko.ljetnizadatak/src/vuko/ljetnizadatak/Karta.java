package vuko.ljetnizadatak;

public class Karta {
	
	private int sifra;
	private float cijena;
	private int kupac;
	private int projekcija;
	private int sjedalo;
	private String red;
	
	public Karta() {
		
	}

	public Karta(int sifra, float cijena, int kupac, int projekcija, int sjedalo, String red) {
		super();
		this.sifra = sifra;
		this.cijena = cijena;
		this.kupac = kupac;
		this.projekcija = projekcija;
		this.sjedalo = sjedalo;
		this.red = red;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public float getCijena() {
		return cijena;
	}

	public void setCijena(int cijena) {
		this.cijena = cijena;
	}

	public int getKupac() {
		return kupac;
	}

	public void setKupac(int kupac) {
		this.kupac = kupac;
	}

	public int getProjekcija() {
		return projekcija;
	}

	public void setProjekcija(int projekcija) {
		this.projekcija = projekcija;
	}

	public int getSjedalo() {
		return sjedalo;
	}

	public void setSjedalo(int sjedalo) {
		this.sjedalo = sjedalo;
	}

	public String getRed() {
		return red;
	}

	public void setRed(String red) {
		this.red = red;
	}
	
	@Override
	public String toString() {
		return red;
	}

}
