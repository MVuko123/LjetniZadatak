package vuko.ljetnizadatak;

import java.awt.Desktop;
import java.net.URI;
import java.util.List;

import javax.swing.JOptionPane;



public class Start {



	public Start() {

		izbornik();
		Baza.zatvoriVezu();
	}

	private void izbornik() {
		System.out.println("1. Izlistavanje");
		System.out.println("2. Unos novoga");
		System.out.println("3. Promjena");
		System.out.println("4. Brisanje");
		System.out.println("5. Otvaranje ERA dijagrama na githubu");
		System.out.println("6. Otvaranje koda na githubu");
		System.out.println("7. Izlaz iz programa");
		izvedi();
		
		
	}

	private void izvedi() {
		switch (Pomocno.ucitajBroj("Odaberite broj:")) {
		case 1: {
			System.out.println("1. Izlistaj kupce");
			System.out.println("2. Izlistaj karte");
			System.out.println("3. Izlistaj projekcije");
			System.out.println("4. Izlistaj hranu i pice");
			System.out.println("5. Izlistaj kolicinu pojedenog/popijenog");
			System.out.println("6. Izlistaj filmove");
            System.out.println("7. Povratak na prošli izbornik");
			izvedi1();
            break;
			}
		case 2:{
			System.out.println("1. Unesi novog kupca");
			System.out.println("2. Unesi novu kartu");
			System.out.println("3. Unesi novu projekciju");
			System.out.println("4. Unesi novu hranu i pice");
			System.out.println("5. Unesi novu kolicinu pojedenog");
			System.out.println("6. Unesi novi film");
			System.out.println("7. Povratak na prošli izbornik");
			izvedi2();
			break;
		}
		case 3:{ 
			System.out.println("1. Promjeni kupce");
			System.out.println("2. Promjeni karte");
			System.out.println("3. Promjeni projekcije");
			System.out.println("4. Promjeni hranu i pice");
			System.out.println("5. Promjeni kolicinu pojedenog/popijenog");
			System.out.println("6. Promjeni filmove");
            System.out.println("7. Povratak na prošli izbornik");
            izvedi3();
            break;
		    }
		case 4:{
			System.out.println("1. Brisanje kupca");
			System.out.println("2. Brisanje karte");
			System.out.println("3. Brisanje projekcije");
			System.out.println("4. Brisanje hrane i pica");
			System.out.println("5. Brisanje kolicine pojedenog/popijenog");
			System.out.println("6. Brisanje filmova");
            System.out.println("7. Povratak na prošli izbornik");
            izvedi4();
            break;
			}
		case 5:{
			gitHub();
			izbornik();
		}
		case 6:{
			gitHub1();
			izbornik();
		}
		default:
			break;
		}
	}
	
	private void gitHub1() {
		adresa("https://github.com/MVuko123/LjetniZadatak");
		
	}

	private void gitHub() {
		 adresa("https://github.com/MVuko123/hellojp22/blob/master/era.jpg");
		
	}

	private void adresa(String url) {
		try {
			Desktop d = Desktop.getDesktop();
			d.browse(new URI(url));

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void izvedi2() {
		switch(Pomocno.ucitajBroj("Odaberite broj")) {
		case 1:{
			CRUDKupac.create(new Kupac(1, Pomocno.ucitajString("Unesi ime"), Pomocno.ucitajString("Unesi prezime"), Pomocno.ucitajString("Unesi spol"), Pomocno.ucitajBroj("Unesi dob")));
			izvedi();
			break;
		}
		case 2:{
			CRUDKarta.create(new Karta(1, Pomocno.ucitajBroj("Unesi cijenu"), Pomocno.ucitajBroj("Unesi novi redni broj za kupca"), Pomocno.ucitajBroj(" Unesi novi redni broj za projekciju "), Pomocno.ucitajBroj("Unesi novi redni broj za sjedalo"), Pomocno.ucitajString("Unesi novi red")));
			izvedi();
			break;
		}
		case 3:{
			CRUDProjekcija.create(new Projekcija(1, Pomocno.ucitajBroj("Unesi novi redni broj za film"), Pomocno.ucitajBroj("Unesi novi datum")));
			izvedi();
			break;
		}
		case 4:{
			CRUDHranaIPice.create(new HranaIPice(1, Pomocno.ucitajString("Unesi novi naziv"), Pomocno.ucitajBroj("Unesi novu cijenu")));
			izvedi();
			break;
		}
		case 5:{
			CRUDPojeoPopio.create(new PojeoPopio(1, Pomocno.ucitajString("Unesi novi naziv"), Pomocno.ucitajBroj("Unesi novu cijenu"), Pomocno.ucitajBroj("Unesi novu kolicinu")));
			izvedi();
			break;
		}
		case 6:{
			CRUDFilm.create(new Film(1, Pomocno.ucitajString("Unesi novi naziv"), Pomocno.ucitajString("Unesi novo ime redatelja"),  Pomocno.ucitajBroj("Unesi novu godinu"), Pomocno.ucitajBroj(" Unesi novu ocjenu")));
			izvedi();
			break;
		}
		default:
			izbornik();
		}
		
	}

	private void izvedi4() {
		switch(Pomocno.ucitajBroj("Odaberite broj")) {
        case 1:{ 
			brisanjeKupca();
			izvedi();
        	break;
		}
		case 2:{
			brisanjeKarte();
			izvedi();
			break;
		}
		case 3:{
			brisanjeProjekcije();
			izvedi();
			break;
		}
		case 4:{
			brisanjeHraneIPice();
			izvedi();
			break;
		}
		case 5:{
			brisanjePojeoPopio();
			izvedi();
			break;
		}
		case 6:{
			brisanjeFilma();
			izvedi();
			break;
		}
		default:
			izbornik();
			break;

		}
		
	}
	
	private void brisanjeFilma() {
		Film film = odaberiFilm(" Unesi redni broj filma koji zelite obrisati ");
		if(film == null) {
			JOptionPane.showMessageDialog(null, " Neispravan redni broj ");
			return;
		}
		CRUDFilm.delete(film.getSifra());
	}

	private Film odaberiFilm(String poruka) {
		izlistajFilmove();
		int redniBroj = Pomocno.ucitajBroj(poruka);
		return CRUDFilm.getFilm(redniBroj);
	}

	private void brisanjePojeoPopio() {
		PojeoPopio pojeoPopio = odaberiPojeoPopio(" Unesi redni broj PojeoPopio koji zelite obrisati ");
		if(pojeoPopio == null) {
			JOptionPane.showMessageDialog(null, " Neispravan redni broj ");
			return;
		}
		CRUDPojeoPopio.delete(pojeoPopio.getSifra());
	}

	private PojeoPopio odaberiPojeoPopio(String poruka) {
	      izlistajPojeoPopio();
	      int redniBroj = Pomocno.ucitajBroj(poruka);
	      return CRUDPojeoPopio.getPojeoPopio(redniBroj);
	}

	private HranaIPice odaberiHranuIPice(String poruka) {
		izlistajHranuIPice();
		int redniBroj = Pomocno.ucitajBroj(poruka);
		return CRUDHranaIPice.getHranaIPice(redniBroj);
	}

	private void brisanjeHraneIPice() {
		 HranaIPice hranaIPice = odaberiHranuIPice(" Unesi redni broj hraneIPica koji zelite obrisati ");
		 if(hranaIPice == null) {
			 JOptionPane.showMessageDialog(null, "Neispravan redni broj");
			 return;
		 }
		 CRUDHranaIPice.delete(hranaIPice.getSifra());
		
	}

	private Projekcija odaberiProjekciju(String poruka) {
		izlistajProjekcije();
		int redniBroj = Pomocno.ucitajBroj(poruka);
		return CRUDProjekcija.getProjekcija(redniBroj);
	}
	private void brisanjeProjekcije() {
		Projekcija projekcija = odaberiProjekciju("Unesi redni broj projekcije koju zelite obrisati ");
		if(projekcija == null) {
			JOptionPane.showMessageDialog(null, "Neispravan redni broj");
			return;
		}
		CRUDProjekcija.delete(projekcija.getSifra());
		
	}

	private Karta odaberiKartu(String poruka) {
		izlistajKarte();
		int redniBroj = Pomocno.ucitajBroj(poruka);
		return CRUDKarta.getKarta(redniBroj);
	}
	
	private void brisanjeKarte() {
		Karta karta = odaberiKartu("Unesi redni broj karte koju zelite obrisati ");
		if(karta == null) {
			JOptionPane.showMessageDialog(null, "Neispravan redni broj");
			return;
		}
		CRUDKarta.delete(karta.getSifra());
		
	}

	private Kupac odaberiKupca(String poruka) {
		izlistajKupce();
		int redniBroj = Pomocno.ucitajBroj(poruka);
		return CRUDKupac.getKupac(redniBroj);
		
	}
	private void brisanjeKupca() {
		Kupac kupac = odaberiKupca(" Unesi redni broj kupca kojeg zelite obrisati ");
		if(kupac == null) {
			JOptionPane.showMessageDialog(null, "Neispravan redni broj");
			return;
		}
		CRUDKupac.delete(kupac.getSifra());
		
	}

	private void izvedi3() {
		switch(Pomocno.ucitajBroj("Odaberite broj")) {
        case 1:{ 
			promjeniKupce();
			izvedi();
			break;
		}
		case 2:{
			promjeniKarte();
			izvedi();
			break;
		}
		case 3:{
			promjeniProjekciju();
			izvedi();
			break;
		}
		case 4:{
			promjeniHranuIPice();
			izvedi();
			break;
		}
		case 5:{
			promjeniPojeoPopio();
			izvedi();
			break;
		}
		case 6:{
			promjeniFilm();
			izvedi();
			break;
		}
		default:
			izbornik();
			break;

		
		}
		
		
	}
	
	private void promjeniFilm() {
		izlistajFilmove();
		int redniBroj = Pomocno.ucitajBroj(" Unesite broj filma kojeg zelite promjeniti: ");
		Film film = CRUDFilm.getFilm(redniBroj);
		if(film == null) {
			JOptionPane.showInputDialog(null, " Neispravan broj! ");
			return;
		}
		film.setNaziv(Pomocno.ucitajString("Promjenite naziv filma", film.getNaziv()));
		film.setRedatelj(Pomocno.ucitajString("Promjenite redatelja filma", film.getRedatelj()));
		film.setGodina(Pomocno.ucitajBroj("Promjeni godinu filma", film.getGodina()));
		film.setOcjena(Pomocno.ucitajBroj("Promjenite ocjenu filma", film.getOcjena()));
		
		CRUDFilm.update(film);
	}
	
	private void promjeniPojeoPopio() {
		izlistajPojeoPopio();
		int redniBroj = Pomocno.ucitajBroj(" Unesite broj koji zelite promjeniti: ");
		PojeoPopio pojeoPopio = CRUDPojeoPopio.getPojeoPopio(redniBroj);
		if(pojeoPopio == null) {
			JOptionPane.showInputDialog(null, " Neispravan broj! ");
			return;
		}
		pojeoPopio.setCijena(Pomocno.ucitajBroj("Promjenite cijenu", pojeoPopio.getCijena()));
		pojeoPopio.setNaziv(Pomocno.ucitajString("Promjeni naziv", pojeoPopio.getNaziv()));
		
		CRUDPojeoPopio.update(pojeoPopio);
		
	}

	private void promjeniHranuIPice(){
		izlistajHranuIPice();
		int redniBroj = Pomocno.ucitajBroj(" Unesite broj HraneIPice kojji zelite promjeniti: ");
		HranaIPice hranaIPice = CRUDHranaIPice.getHranaIPice(redniBroj);
		if(hranaIPice == null) {
			JOptionPane.showInputDialog(null, " Neispravan broj! ");
			return;
		}
		hranaIPice.setCijena(Pomocno.ucitajBroj("Promjenite cijenu", hranaIPice.getCijena()));
		hranaIPice.setNaziv(Pomocno.ucitajString("Promjeni naziv", hranaIPice.getNaziv()));
		
		CRUDHranaIPice.update(hranaIPice);
	}

	private void promjeniProjekciju() {
		izlistajProjekcije();
		int redniBroj = Pomocno.ucitajBroj(" Unesite broj projekcije koju zelite promjeniti: ");
		Projekcija projekcija = CRUDProjekcija.getProjekcija(redniBroj);
		if(projekcija == null) {
			JOptionPane.showInputDialog(null, " Nesipravan broj! ");
			return;
		}
		projekcija.setFilm(Pomocno.ucitajBroj("Promjeni film ", projekcija.getFilm()));
		projekcija.setDatum(Pomocno.ucitajBroj("Promjeni datum", projekcija.getDatum()));
		
		CRUDProjekcija.update(projekcija);
	}

	private void promjeniKarte() {
		izlistajKarte();
		int redniBroj = Pomocno.ucitajBroj(" Unesite broj karte koju zelite promjeniti: ");
		Karta karta = CRUDKarta.getKarta(redniBroj);
		if(karta == null) {
			JOptionPane.showInputDialog(null, " Neispravan broj! ");
			return;
		}
		karta.setCijena(Pomocno.ucitajBroj(" Promjeni cijenu", karta.getCijena()));
		karta.setKupac(Pomocno.ucitajBroj("Promjeni kupca", karta.getKupac()));
		karta.setProjekcija(Pomocno.ucitajBroj("Promjeni projekciju", karta.getProjekcija()));
		karta.setRed(Pomocno.ucitajString("Promjeni red", karta.getRed()));
		karta.setSjedalo(Pomocno.ucitajBroj("Promjeni sjedalo", karta.getSjedalo()));
		
		CRUDKarta.update(karta);
		
	}

	private void promjeniKupce() {
		izlistajKupce();
		int redniBroj = Pomocno.ucitajBroj(" Unesite broj kupca kojeg zelite promjeniti:");
		Kupac kupac = CRUDKupac.getKupac(redniBroj);
		if(kupac == null) {
			JOptionPane.showInputDialog(null, " Neispravan broj!");
			return;
		}
		kupac.setIme(Pomocno.ucitajString("Promjeni ime", kupac.getIme()));
		kupac.setPrezime(Pomocno.ucitajString("Promjeni prezime", kupac.getPrezime()));
		kupac.setSpol(Pomocno.ucitajString("Promjeni spol", kupac.getSpol()));
		kupac.setDob(Pomocno.ucitajBroj("Promjeni dob", kupac.getDob()));
		CRUDKupac.update(kupac);
	}

	private void izvedi1() {
		switch (Pomocno.ucitajBroj("Odaberite broj:")) {
		case 1:{ 
			izlistajKupce();
			izvedi();
			break;
		}
		case 2:{
			izlistajKarte();
			izvedi();
			break;
		}
		case 3:{
			izlistajProjekcije();
			izvedi();
			break;
		}
		case 4:{
			izlistajHranuIPice();
			izvedi();
			break;
		}
		case 5:{
			izlistajPojeoPopio();
			izvedi();
			break;
		}
		case 6:{
			izlistajFilmove();
			izvedi();
			break;
		}
		default:
			izbornik();
			break;

		
	}
	}

	private void izlistajFilmove() {
		List<Film> filmovi = CRUDFilm.read();
		String redniBroj;
		for(int i = 0; i < filmovi.size(); i++) {
			redniBroj = Pomocno.vodecePraznine(filmovi.size()) + (i + 1);
			redniBroj = redniBroj.substring(redniBroj.length() - Pomocno.brojZnamenki(filmovi.size()));
			System.out.println(redniBroj + " . " + filmovi.get(i));
		}
		
	}

	private void izlistajPojeoPopio() {
		List<PojeoPopio> pojedenoPopijeno = CRUDPojeoPopio.read();
		String redniBroj;
		for(int i = 0; i < pojedenoPopijeno.size(); i++) {
			redniBroj = Pomocno.vodecePraznine(pojedenoPopijeno.size()) + ( i + 1);
			redniBroj = redniBroj.substring(redniBroj.length() - Pomocno.brojZnamenki(pojedenoPopijeno.size()));
			System.out.println(redniBroj + " . " + pojedenoPopijeno.get(i));
		}
		
	}

	private void izlistajHranuIPice() {
		List<HranaIPice> hranaIPica = CRUDHranaIPice.read();
		String redniBroj;
		for(int i = 0; i < hranaIPica.size(); i++) {
			redniBroj = Pomocno.vodecePraznine(hranaIPica.size()) + (i + 1);
			redniBroj = redniBroj.substring(redniBroj.length() - Pomocno.brojZnamenki(hranaIPica.size()));
		    System.out.println(redniBroj + " . " + hranaIPica.get(i));
		}
		
	}

	private void izlistajProjekcije() {
		List<Projekcija> projekcije = CRUDProjekcija.read();
		String redniBroj;
		for(int i = 0; i < projekcije.size(); i++) {
			redniBroj = Pomocno.vodecePraznine(projekcije.size()) + (i + 1);
			redniBroj = redniBroj.substring(redniBroj.length()- Pomocno.brojZnamenki(projekcije.size()));
		    System.out.println(redniBroj + " . " + projekcije.get(i));
		}
		
	}

	private void izlistajKarte() {
		List<Karta> karte = CRUDKarta.read();
		String redniBroj;
		for(int i = 0; i < karte.size(); i++) {
			redniBroj = Pomocno.vodecePraznine(karte.size()) + (i + 1);
			redniBroj = redniBroj.substring(redniBroj.length() - Pomocno.brojZnamenki(karte.size()));
		    System.out.println(redniBroj + " . " + karte.get(i));
		}
		
	}

	private void izlistajKupce() {
		List<Kupac> kupci = CRUDKupac.read();
		String redniBroj;
		for(int i = 0; i < kupci.size(); i++) {
			redniBroj = Pomocno.vodecePraznine(kupci.size()) + (i+1);
			redniBroj = redniBroj.substring(redniBroj.length() - Pomocno.brojZnamenki(kupci.size()));
		    System.out.println(redniBroj + " . " + kupci.get(i));
		}
		
	}
			
	
	public static void main(String[] args) {
		new Start();
	}
		
		

}
