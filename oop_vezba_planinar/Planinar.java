package Test_17_09_2021;
//(15 poena) Kreirati apstraktnu klasu ​Planinar ​koja od zaštićenih atributa ima: 

//jedinstveni celobrojni identifikacioni broj
//ime i prezime 
//Dok od javnih metoda: 
//konstruktor koji postavlja sve atribute klase. 
//gettere i settere (atribute klase nije moguće menjati, nakon inicijalizacije tj. posle njihovog 
//		postavljanja u konstruktoru)

public abstract class Planinar {

	protected int identifikacioniBroj;
	protected String imeIPrezime;

	public Planinar(int identifikacioniBroj, String imeIPrezime) {
		super();
		this.identifikacioniBroj = identifikacioniBroj;
		this.imeIPrezime = imeIPrezime;
	}

	public int getIdentifikacioniBroj() {
		return identifikacioniBroj;
	}

	public String getImeIPrezime() {
		return imeIPrezime;
	}

	public abstract void stampaj();

	public abstract int vratiClanarinuPlaninara();

	public abstract boolean uspesanUspon(Planina planina);
}
