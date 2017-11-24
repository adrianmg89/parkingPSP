
public class Coche extends Thread{
	private Barrera b;
	private int numeroCoche;

	//Constructor del coche, que nos dice su nombre y su numero de identificacion
	public Coche( Barrera b, int numeroCoche) {
		super();
		this.numeroCoche = numeroCoche;
		this.b = b;
	}

	public void run() {
		try {
			Thread.sleep(Math.round(Math.random()*5000));
			System.out.println("El "+this.getName()+" espera en la barrera");
			//Enviamos al metodo el numero de coche, para que lo guarde en el sitio del parking.
			int nombre = b.entrada(numeroCoche);
			//nos traemos el numero de coche,para enviarlo de nuevo cuando vaya a salir.
			
			Thread.sleep(Math.round(Math.random()*5000));	
			
			//Enviamos el numero de coche para que lo borre del parking.
			b.salida(nombre);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public int getNumeroCoche() {
		return numeroCoche;
	}

	public void setNumeroCoche(int numeroCoche) {
		this.numeroCoche = numeroCoche;
	}
	
}
