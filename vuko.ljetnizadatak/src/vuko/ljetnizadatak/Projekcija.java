package vuko.ljetnizadatak;



public class Projekcija {
	
	private int sifra;
	private int film;
	private float datum;
	
	public Projekcija() {
		
	}

	public Projekcija(int sifra, int film, float datum) {
		super();
		this.sifra = sifra;
		this.film = film;
		this.datum = datum;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public int getFilm() {
		return film;
	}

	public void setFilm(int film) {
		this.film = film;
	}

	public float getDatum() {
		return datum;
	}

	public void setDatum(float datum) {
		this.datum = datum;
	}
	
	

}
