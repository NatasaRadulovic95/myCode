package Domaci27_08_2021;

public class Zadatak1 {

	public static void main(String[] args) {
		FacebookPost facebook = new FacebookPost();
		facebook.setimeIPrezimeKorisnikaKojiJeObjavioPost("Natasa Radulovic");
		facebook.setImeIPrezimeVlasnikaProfila("Petar Petrovic");
		facebook.setTekstObjave("Cao Pero :)");
		facebook.like();
		facebook.like();
		facebook.like();
		facebook.share();
		facebook.print();
	}

}
