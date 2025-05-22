package proyecto.jubert.hilos.pack;

public class Main {

	public static void main(String[] args) {
		int clients = 10000;
		long  start = System.currentTimeMillis();
		Hilo[] hilos = new Hilo[clients];
		
		try {
			
			for(int i =1; i<=clients;i++) {
				hilos[i-1] = new Hilo();
				hilos[i-1].start();
			}
			
			for(int i=0;i<clients;i++)
			{	
				
				hilos[i].join();
		}
		
	}
		catch(Exception e) {
			
		System.out.println(e.getMessage());
	}
		
		long end = System.currentTimeMillis();
		long timecurrent = end-start;
		
		
		System.out.println("Tiempo transcurrido "+timecurrent+"ms");
		System.out.println("Numero de hilos exitosos "+Hilo.getGreatConnection());
		System.out.println("Numero de hilos fallidos "+Hilo.getFailedConnection());

	}
}
