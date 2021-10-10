package Domaci27_08_2021;
////1.Kreirati klasu FacebookPost koja ima:



////	U glavnoj klasi napraviti minimum dva FacebookPost-a i
//nad svakim pozvati svaku funkciju.
////
////
////	Primer stampanja:
////	Milan Jovanovic >>> Pera Peric
////	Ovo je tekst objave
////	Likes 3 | Shares 1

public class FacebookPost {

	private String imeIPrezimeKorisnikaKojiJeObjavioPost;
	private String imeIPrezimeVlasnikaProfila;
	private String tekstObjave;
	private int brojLajkova;
	private int brojDeljenja;

	public void setimeIPrezimeKorisnikaKojiJeObjavioPost(String imeIPrezime) {
		this.imeIPrezimeKorisnikaKojiJeObjavioPost = imeIPrezime;
	}

	public String getImeIPrezimeKorisnikaKojiJeObjavioPost() {
		return this.imeIPrezimeKorisnikaKojiJeObjavioPost;
	}

	public void setImeIPrezimeVlasnikaProfila(String imeIPrezimeVlasnika) {
		this.imeIPrezimeVlasnikaProfila = imeIPrezimeVlasnika;
	}

	public String getImeIPrezimeVlasnikaProfila() {
		return this.imeIPrezimeVlasnikaProfila;
	}

	public void setTekstObjave(String tekst) {
		this.tekstObjave = tekst;
	}

	public String getTekstObjave() {
		return this.tekstObjave;
	}

	public int getBrojLajkova() {
		return this.brojLajkova;
	}

	public int getBrojDeljenja() {
		return this.brojDeljenja;
	}

	public FacebookPost(String imeIPrezime, String imeIPrezimeVlasnika,
						String tekstObjave, int brojLakova, int brojDeljenja) {
		
		this.imeIPrezimeKorisnikaKojiJeObjavioPost = imeIPrezime;
		this.imeIPrezimeVlasnikaProfila = imeIPrezimeVlasnika;
		this.tekstObjave = tekstObjave;
		this.brojLajkova = brojLakova;
		this.brojDeljenja = brojDeljenja;
		
	}
	public FacebookPost() {
		
	}
	
	public int like() {
		this.brojLajkova = this.brojLajkova+1;
		return brojLajkova;
		
	}
	
	public int dislike() {
		int brojLajkova = this.brojLajkova-1;
		
		if(brojLajkova<0) {
			return 0;
		}
		return brojLajkova;
		
	}
	public int share() {
		this.brojDeljenja = this.brojDeljenja + 1;
		return this.brojDeljenja;
	}
	public void print() {
		System.out.println(this.imeIPrezimeKorisnikaKojiJeObjavioPost+" >>> "+ this.imeIPrezimeVlasnikaProfila);
		System.out.println(this.tekstObjave);
		System.out.println("Likes "+ this.brojLajkova+" |  Shares "+this.brojDeljenja);
	}

////(ime i prezime osobe koja je objavila) >>> (ime i prezime na cijem profilu)
////(tekst objave)
////Likes (broj lajkova) | Shares (broj deljenja)
////
}
