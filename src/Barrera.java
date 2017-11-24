
public class Barrera {

	private int[] plazas;
	private int nPlazas;
	private int libres;
	
	int plaza = 0;

	public Barrera(int nPlazas) {
		
		this.nPlazas = nPlazas;
		this.libres = nPlazas;
		
		plazas = new int[nPlazas];
		for (int i = 0; i < nPlazas; i++) {
			plazas[i] = 0;
		}
	}

	public synchronized int entrada(int num){
		verParking();
		int plazaL=0;		
			while(libres == 0 ){				
				try {
					System.out.println(Thread.currentThread().getName()+" esperando plaza libre" );
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			while (plazas[plazaL] !=0) {	
				plazaL++;
			}
			plazas[plazaL]= num;
			libres--;
			System.out.println(Thread.currentThread().getName()+ " aparcado");
			
		return plazaL;

	}

	public synchronized void salida(int nom) {
		
		plazas[nom] = 0;
		libres++;
		notify();
		System.out.println("Coche " + Thread.currentThread().getName() + " saliendo");
		verParking();
	}

	public int[] getPlazas() {
		return plazas;
	}

	public int getnPlazas() {
		return nPlazas;
	}

	public int getLibres() {
		return libres;
	}


	public void verParking() {
		
		for (int i = 0; i < nPlazas; i++) {
			System.out.print("[" + plazas[i] + "] ");
		}
		System.out.println("");
	}

}
