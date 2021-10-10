package p27_08_2021;
//3.Zad

//Kreirati klasu Radnik koja ima:
//jmbg radnika
//ime i prezime
//broj dece (1,2,3,... ili 0 ako nema dece)
//stepen strucne spreme (od 1 do 8)
//godine radnog staza
//gettere i settere (jmbg ne sme da se menja, znaci za njega nemamo setter)
//konstuktor koji postavlja samo jmbg
//konstuktor koji postavlja sve atribute
//(Za vezbanje)
//metodu koja racuna platu radnika, plata se racuna po formuli:
//25000 + (koeficijent slozenosti + minuli rad) * 10000
//metodu koja vraca da li je zaposleni kreditno sposoban. (Kreditno je sposoban ako je plata veca od 50 000)
//metodu koja racuna i vraca koliko slobodnih dana radnik ima za tekucu godinu.Svaki radnik godisnje ima 22 
//radna dana, i za svako dete plus po 2 dana

public class Radnik {

	private String jmbgRadnika;
	private String imeIPrezimeRadnika;
	private int brojDece;
	private int stepenSS;
	private int godineRadnogStaza;

	public Radnik(String jmbg) {
		this.jmbgRadnika = jmbg;

	}
	public Radnik() {
		
	}

	public Radnik(String jmbg, String imeIPrezime, int brojDece, int stepenSS, int godineRStaza) {
		this.jmbgRadnika = jmbg;
		this.imeIPrezimeRadnika = imeIPrezime;
		this.brojDece = brojDece;
		this.stepenSS = stepenSS;
		this.godineRadnogStaza = godineRStaza;
	}

	public void stampaj() {
		System.out.println("Ime i prezime: "+this.getimeIPrezimeRadnika());
		System.out.println("Broj dece: "+this.getbrojDece());
		System.out.println("Stepen strucne spreme: "+this.getstepenSS());
		System.out.println("Godine radnog staza: "+this.getgodineRadnogStaza());
		System.out.println("Koeficijent minulog rada je: "+ this.vratiMinuliRad());
		System.out.println("Koeficijent slozenosti je: "+ this.vratiKoeficijentSlozenosti());
	}
	
	
	public String getjmbgRadnika() {
		return this.jmbgRadnika;
	}

	public void setimeIPrezimeRadnika(String imeIPrezimeRadnika) {
		this.imeIPrezimeRadnika = imeIPrezimeRadnika;
	}

	public String getimeIPrezimeRadnika() {
		return this.imeIPrezimeRadnika;

	}

	public void setBrojDece(int brojDece) {
		this.brojDece = brojDece;
	}

	public int getbrojDece() {
		return this.brojDece;

	}

	public void setstepenSS(int stepenSS) {
		this.stepenSS = stepenSS;
	}

	public int getstepenSS() {
		return this.stepenSS;

	}

	public void setgodineRadnogStaza(int godineRadnogStaza) {
		this.godineRadnogStaza = godineRadnogStaza;
	}

	public int getgodineRadnogStaza() {
		return this.godineRadnogStaza;

	}
	
	public double vratiMinuliRad() {
		double minuliRad = 0;
		
		if(this.godineRadnogStaza<=10) {
			minuliRad = 0.05;
		}
		else if(this.godineRadnogStaza>10&&this.godineRadnogStaza<=20) {
			minuliRad = 0.075;
		}
		else {
			minuliRad = 0.1;
		}
		return minuliRad;
	}
	
	public double vratiKoeficijentSlozenosti() {
		double koeficijent = 0;
		switch (this.stepenSS) {
		case 1:
			koeficijent = 1.03;
		
			break;
		case 2:
			koeficijent = 1.65;
			break;
		case 3:
			koeficijent = 2.00;
			break;
		case 4:
			koeficijent = 2.27;
			break;
		case 5:
			koeficijent = 2.88;
			break;
		case 6:
			koeficijent = 3.09;
			break;
		case 7:
			koeficijent = 3.40;
			break;
		case 8:
			koeficijent = 4.12;
			
			break;
		
		
		default:
			break;
		
		}
		return koeficijent;
	}
	
	public double vratiPlatuRadnika() {
		
		return 25000+(this.vratiKoeficijentSlozenosti()+this.vratiMinuliRad())*10000;
		
	}
	
	public boolean daLiJeKreditnoSposoban(double vratiPlatuRadnika) {
		boolean jeSposoban = false;
		if(vratiPlatuRadnika>50000) {
			jeSposoban = true;
		}
		return jeSposoban;
	}
	
	public int vratiSlobodneDane() {
		return 22+this.brojDece*2;
	}
	

}


//metodu koja racuna i vraca koliko slobodnih dana radnik ima za tekucu godinu.Svaki radnik godisnje ima 22 
//radna dana, i za svako dete plus po 2 dana