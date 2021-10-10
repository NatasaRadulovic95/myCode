package Test_17_09_2021;

import java.util.ArrayList;

public class PlaninarskiDom {

	private String nazivDoma;
	private int godinaOsnivanja;

	ArrayList<Planinar> planinari = new ArrayList<Planinar>();

	public PlaninarskiDom() {
		super();
	}

	public PlaninarskiDom(String nazivDoma, int godinaOsnivanja) {
		super();
		this.nazivDoma = nazivDoma;
		this.godinaOsnivanja = godinaOsnivanja;
	}

	public String getNazivDoma() {
		return nazivDoma;
	}

	public void setNazivDoma(String nazivDoma) {
		this.nazivDoma = nazivDoma;
	}

	public int getGodinaOsnivanja() {
		return godinaOsnivanja;
	}

	public void setGodinaOsnivanja(int godinaOsnivanja) {
		this.godinaOsnivanja = godinaOsnivanja;
	}

	public ArrayList<Planinar> getPlaninari() {
		return planinari;
	}

	public void setPlaninari(ArrayList<Planinar> planinari) {
		this.planinari = planinari;
	}

	public void uclaniPlaninara(Planinar planinar) {
		planinari.add(planinar);
	}

	public int brojPlaninaraKojiCeSeUspesnoPopeti(Planina planina) {
		int count = 0;
		for (int i = 0; i < planinari.size(); i++) {
			if (planinari.get(i).uspesanUspon(planina)) {
				count++;
			}

		}
		return count;
	}

	public void izbaciPlaninaraIzDoma(int identifikacioniBroj) {
		for (int i = 0; i < planinari.size(); i++) {
			if (planinari.get(i).identifikacioniBroj == identifikacioniBroj) {
				planinari.remove(i);
			}
		}
	}

	public void stampaj() {
		System.out.println("Naziv doma: " + this.nazivDoma);
		System.out.println("Godina osnivanja doma: " + this.godinaOsnivanja);
		for (int i = 0; i < planinari.size(); i++) {
			System.out.println("ID: " + planinari.get(i).identifikacioniBroj);
			System.out.println("Ime i prezime: " + planinari.get(i).imeIPrezime);
			System.out.println("Clanarina: "+planinari.get(i).vratiClanarinuPlaninara());

		}

	}

	public int vratiMesecniPrihod() {
		int prihod = 0;
		for (int i = 0; i < planinari.size(); i++) {
			prihod = prihod + planinari.get(i).vratiClanarinuPlaninara();

		}
		return prihod;
	}
}
