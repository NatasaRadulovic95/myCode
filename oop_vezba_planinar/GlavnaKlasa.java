package Test_17_09_2021;

public class GlavnaKlasa {

	public static void main(String[] args) {
		PlaninarskiDom dom = new PlaninarskiDom("Crni vrh", 1945);
		
		Planina tara = new Planina("Tara", "Srbija", 2900);
		Planina everest = new Planina("Everest", "Azija", 9000);
		
		Planinar natasa = new RekreativniPlaninar(1612, "Natasa Radulovic", 5, "Zlatiborski", 2500);
		Planinar pera = new RekreativniPlaninar(55, "Pera Peric", 8, "Kolubarski", 3000);
		Planinar milan = new RekreativniPlaninar(44, "Milan Milanovic", 9, "Niski", 1400);
		
		
		Planinar marko = new Alpinista(1514, "Marko Markovic", 3);
		Planinar nikola = new Alpinista(6633, "Nikola Nikolic", 4);
		Planinar aleksa = new Alpinista(77, "Aleksa Aleksic", 10);
		

		dom.uclaniPlaninara(natasa);
		dom.uclaniPlaninara(pera);
		dom.uclaniPlaninara(marko);
		dom.uclaniPlaninara(nikola);
		dom.uclaniPlaninara(milan);
		dom.uclaniPlaninara(aleksa);
		
		dom.izbaciPlaninaraIzDoma(6633);
		dom.izbaciPlaninaraIzDoma(1612);
		dom.stampaj();
		int mesecniPrihod = dom.vratiMesecniPrihod();
		
		int broj = dom.brojPlaninaraKojiCeSeUspesnoPopeti(tara);
		int broj2 = dom.brojPlaninaraKojiCeSeUspesnoPopeti(everest);
		
		System.out.println("Na Taru se uspesno popelo: "+broj+" planinara");
		System.out.println("Na Everest ce se uspesno popeti: "+broj2);
		System.out.println("Mesecni prihod planinarskog doma je: "+mesecniPrihod);
	}

}
