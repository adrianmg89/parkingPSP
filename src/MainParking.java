import java.util.Scanner;

public class MainParking {

	public static void main(String[] args) throws InterruptedException {
		//Introducir datos por consola:
		Scanner sc = new Scanner(System.in);
		System.out.print("N�mero de plazas del parking: ");		
		int nPlazas = sc.nextInt();
		System.out.print("N�mero de coches que vendr�n: ");		
		int nCoches = sc.nextInt();
		
		//Introducir datos por argumento:
/*		int nPlazas = Integer.parseInt(args[0]);
		int nCoches = Integer.parseInt(args[1]);*/
		
		Barrera barrera = new Barrera(nPlazas);

		for (int i = 1; i <= nCoches; i++) {
			Coche coche = new Coche(barrera,i);
			coche.setName(String.valueOf( "coche "+i));
			coche.start();
			//coche.join();
		}

	}

}
