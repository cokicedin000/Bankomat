package Racuni;

import java.util.Scanner;

public class Bankomat {

    public static void main(String[] args) {
	start();
    }

    public static void start() {
	Scanner unos = new Scanner(System.in);
	System.out.println("\tBankomat: \n1) Novi racun \n2) Transfer novca \n3) Postojevi racun");
	int broj;
	do {
	    System.out.print("Unesite jednu od opcija: ");
	    broj = unos.nextInt();
	    if (broj != 1 && broj != 2 && broj != 3) {
		System.out.println("Neispravan unos");
	    }
	} while (broj != 1 && broj != 2 && broj != 3);
	System.out.println();

	switch (broj) {
	case 1:
	    noviRacun();
	    break;
	case 2:
	    prebacivanjeNovca();
	    break;

	case 3:
	    ispis();
	    break;

	}

    }

    public static void noviRacun() {
	Scanner unos = new Scanner(System.in);

	System.out.print("Unesite broj racuna: ");
	int BrojRacuna = unos.nextInt();

	if (BrojRacuna > 0) {
	    System.out.print("Unesite stanje na racunu: ");
	    double StanjeNaRacunu = unos.nextDouble();
	    if (StanjeNaRacunu > 0) {
		System.out.print("Unesite korisnicko ime: ");
		String ImeKorisnika = unos.next();
		System.out.println();
		PrviRacun korisnik = new PrviRacun(BrojRacuna, StanjeNaRacunu, ImeKorisnika);
		System.out.println();
		start();

	    } else {
		System.out.println();
	    System.out.println("Stanje na racunu ne moze biti u minusu.");
	    System.out.println();
	    start();
	    }
	} else {
	    System.out.println();
	System.out.println("Broj racuna ne moze biti negativan.");
	System.out.println();
	start();
	}
    }

    public static void prebacivanjeNovca() {
	Scanner unos = new Scanner(System.in);
	System.out.print("Unesite broj racuna sa kojeg prebacujete novac: ");
	int prviRacun = unos.nextInt();

	if (prviRacun > 0) {
	    System.out.print("Unesite broj racuna na koji prebacujete novac: ");
	    int drugiRacun = unos.nextInt();

	    if (drugiRacun > 0) {
		System.out.print("Unesite iznos koji prebacujete: ");
		double novac = unos.nextDouble();
		System.out.println();
		PrviRacun.Slanje(prviRacun, drugiRacun, novac);
		System.out.println();
		start();
	    } else
		System.out.println("Broj racuna ne moze biti negativan.");
	    System.out.println();
	    start();
	} else
	    System.out.println("Broj racuna ne moze biti negativan.");
	System.out.println();
	start();
    }

    public static void ispis() {
	Scanner unos = new Scanner (System.in);
	System.out.print("Unesite broj racuna: ");
	int brojRacuna = unos.nextInt();
	
	PrviRacun.ispisRacuna(brojRacuna);
	System.out.println();
	start();
    }

}
