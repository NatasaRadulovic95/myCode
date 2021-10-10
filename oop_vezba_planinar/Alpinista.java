package Test_17_09_2021;

public class Alpinista extends Planinar {

	private int ostvareniPoeni;

	public int getOstvareniPoeni() {
		return ostvareniPoeni;
	}

	public void setOstvareniPoeni(int ostvareniPoeni) {
		this.ostvareniPoeni = ostvareniPoeni;
	}

	@Override
	public void stampaj() {
		System.out.println("Alpinista, id" + this.identifikacioniBroj);
		System.out.println("Ime: " + this.imeIPrezime);
		System.out.println("Broj poena: " + this.ostvareniPoeni);

	}

	@Override
	public int vratiClanarinuPlaninara() {
		return 1500 - (this.ostvareniPoeni * 50);
	}

	@Override
	public boolean uspesanUspon(Planina planina) {
		if (planina.getVisinaPlanine() <= 4000) {
			return true;
		} else {
			return false;
		}
	}

	public Alpinista(int identifikacioniBroj, String imeIPrezime, int ostvareniPoeni) {
		super(identifikacioniBroj, imeIPrezime);
		this.ostvareniPoeni = ostvareniPoeni;
	}

}
