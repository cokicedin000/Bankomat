package Racuni;

import java.util.ArrayList;

public class PrviRacun {

    private static ArrayList<PrviRacun> racun = new ArrayList<>();

    private int BrojRacuna;
    private String ImeKorisnika;
    private double IznosNaRacunu;

    

    public PrviRacun(int BrojRacuna, double IznosNaRacunu,  String ImeKorisnika) {

	if (aktivacija(BrojRacuna, IznosNaRacunu)) {
	    this.BrojRacuna = BrojRacuna;
	    this.ImeKorisnika = ImeKorisnika;
	    this.IznosNaRacunu = IznosNaRacunu;

	    racun.add(this);

	    System.out.println("Racun je kreiran");
	}
    }

    private boolean aktivacija(int BrojRacuna, double IznosNaRacunu) {

	for (int i = 0; i < racun.size(); i++)
	    if (BrojRacuna == racun.get(i).BrojRacuna) {
		System.out.println("Racun nije kreiran jer unijeti broj racuna vec postoji.");
		return false;
	    }

	return true;

    }

    public static void Slanje(int prviRacun, int drugiRacun, double iznosSlanja) {
	if (provjeraSlanja(prviRacun, drugiRacun, iznosSlanja)) {
	    for (int i = 0; i < racun.size(); i++) {
		if (racun.get(i).BrojRacuna == prviRacun) {
		    racun.get(i).IznosNaRacunu -= iznosSlanja;
		}
		if (racun.get(i).BrojRacuna == drugiRacun) {
		    racun.get(i).IznosNaRacunu += iznosSlanja;
		}

	    }
	    System.out.println("Prebacivanje uspjesno");

	} else {
	    System.out.println("Prebacivanje neuspjesno");
	}
    }

    private static boolean provjeraSlanja(int prviRacun, int drugiRacun, double IznosSlanja) {
	boolean pocetniRacun = false;
	for (int i = 0; i < racun.size(); i++) {
	    if (prviRacun == racun.get(i).BrojRacuna) {
		pocetniRacun = true;
		break;
	    }
	}
	boolean krajnjiRacun = false;
	for (int j = 0; j < racun.size(); j++) {
	    if (drugiRacun == racun.get(j).BrojRacuna) {
		krajnjiRacun = true;
		break;
	    }
	}
	boolean novac = false;
	for (int k = 0; k < racun.size(); k++) {
	    if (racun.get(k).BrojRacuna == prviRacun) {
		if (racun.get(k).IznosNaRacunu >= IznosSlanja) {
		    novac = true;
		}

	    }
	}
	if (pocetniRacun && krajnjiRacun && novac) {
	    return true;
	} else {
	    return false;
	}
    }

    public static void ispisRacuna(int brojRacuna) {

	for (int i = 0; i < racun.size(); i++)
	    if (racun.get(i).BrojRacuna == brojRacuna) {
		System.out.println(racun.get(i).toString());
		return;
	    }

	System.out.println("Unijeti racun nije pronadjen.");
    }

    @Override
    public String toString() {
	return "PrviRacun [BrojRacuna=" + BrojRacuna + ", ImeKorisnika=" + ImeKorisnika + ", IznosNaRacunu="
		+ IznosNaRacunu + "]";
    }

}
