package p27_08_2021;
//Dodati gettere i settere za koordinate i oznaku (klasa Tacka)

//Naravno atributi idu private

public class Tacka {

	private int x;
	private int y;

	public Tacka() {

	}

	public Tacka(int xxKoordinata, int yyKoordinata) {
		this.x = xxKoordinata;
		this.y = yyKoordinata;
	}

	public void stampaj() {
		System.out.println("X koordinata: " + this.x + " ");
		System.out.println("Y koordinata: " + this.y);
	}

	public void setX(int x) {
		this.x = x;

	}

	public int getX() {
		return this.x;

	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return this.y;
	}

}
