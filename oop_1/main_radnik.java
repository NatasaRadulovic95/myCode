package p27_08_2021;

public class Zadatak2 {

	public static void main(String[] args) {
		
		
		Radnik radnik = new Radnik();
		radnik.setBrojDece(6);
		radnik.setimeIPrezimeRadnika("Natasa Radulovic");
		radnik.setstepenSS(8);
		radnik.setgodineRadnogStaza(10);
		
		radnik.vratiMinuliRad();
		radnik.vratiKoeficijentSlozenosti();
		radnik.stampaj();
		double plata = radnik.vratiPlatuRadnika();
		System.out.println("Plata radnika je: "+plata);
		boolean kreditnoSposoban = radnik.daLiJeKreditnoSposoban(plata);
		System.out.println("Kreditno sposoban: "+kreditnoSposoban);
		int slobodniDani = radnik.vratiSlobodneDane();
		System.out.print("Radnih ima slobodnih dana: "+slobodniDani);
	}

}
