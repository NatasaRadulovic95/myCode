package Test_17_09_2021;
//(20 poena) Kreirati klasu ​RekreativniPlaninar​ koja nasleđuje klasu Planinar.

//Klasa dodatno pamti još neke informacije koje se ne mogu menjati nakon postavljanja u konstuktoru: 
//težinu opreme (kg) koju nosi (celobrojna je vrednost npr: 20kg) 
//naziv okruga odakle je rekreativni planinar. 
//maksimalni uspon koji planinar može da savlada bez opreme (npr: 2000m)
//da li će rekreativni planinar uspešno popeti na planinu zavisi da li je
//njegov najveći uspon manji od visine planine, s tim da oprema dodatno
//otežava penjanje i za svaki kilogram opreme koji nosi može da pređe 50 metara manje. 
//rekeativci placaju clanarinu u iznosu od 1000 rsd
//metoda koja ispisuje podatke o planinaru ispisuje ih u sledećem formatu: 

public class RekreativniPlaninar extends Planinar {

	private int tezinaOpreme;
	private String nazivOkruga;
	private int maksimalanUspon;

	@Override
	public void stampaj() {
		System.out.println("Rektrativac, id" + this.identifikacioniBroj);
		System.out.println("Ime: " + this.imeIPrezime);
		System.out.println("Okrug: " + this.nazivOkruga);

	}

	@Override
	public int vratiClanarinuPlaninara() {
		return 1000;
	}

//	da li će rekreativni planinar uspešno popeti na planinu zavisi da li je njegov 
//	najveći uspon manji od visine planine, s tim da oprema dodatno otežava penjanje
//	i za svaki kilogram opreme koji nosi može da pređe 50 metara manje. 
	@Override
	public boolean uspesanUspon(Planina planina) {
		if ((this.maksimalanUspon - (this.tezinaOpreme * 50)) > planina.getVisinaPlanine()) {
			return true;
		} else {
			return false;
		}
	}

	public RekreativniPlaninar(int identifikacioniBroj, String imeIPrezime, int tezinaOpreme, String nazivOkruga,
			int maksimalanUspon) {
		super(identifikacioniBroj, imeIPrezime);
		this.tezinaOpreme = tezinaOpreme;
		this.nazivOkruga = nazivOkruga;
		this.maksimalanUspon = maksimalanUspon;
	}

}
