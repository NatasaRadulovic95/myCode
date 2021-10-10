package p27_08_2021;
//Za klasu Tacka, koja ima atribute:
//x - x koordinata
//y - y koordinata
//metodu stampaj
//imamo difoltni konstruktor
//imamo konstuktor koji prima obe koordinate za kreiranje objekta
//U glavnom programu kreirati objekte preko oba konstuktora.
public class Zadatak1 {

	public static void main(String[] args) {
	
		Tacka tacka = new Tacka();
		tacka.setX(0);;
		tacka.setY(0);
		
		Tacka tacka1 = new Tacka(5, 7);

		tacka.stampaj();
		tacka1.stampaj();
	}

}
