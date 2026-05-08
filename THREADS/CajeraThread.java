package tallerThreads;

public class CajeraThread extends Thread { 
	
	private String nombre;
	private Cliente cliente;
	private long initialTime;
	
	public CajeraThread(String nombre, Cliente cliente, long initialTime) {
		this.nombre = nombre; 
		this.cliente = cliente; 
		this.initialTime = initialTime; 
	}
	
	@Override
	public void run() { 
		System.out.println("La cajera " + this.nombre + 
				" comienza a procesar la compra del cliente " + cliente.getNombre() + 
				" en el tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		
		for (int i = 0; i < cliente.getCarroCompra().length; i++) { 
			this.esperarXsegundos(cliente.getCarroCompra()[i]); 
			System.out.println("Procesado el producto " + (i + 1) + 
					" del cliente " + cliente.getNombre() + 
					" ->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		}
		
		System.out.println("La cajera " + this.nombre + 
				" ha terminado de procesar " + cliente.getNombre() + 
				" en el tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg"); 
	}
	
	private void esperarXsegundos(int segundos) { 
		try {
			Thread.sleep(segundos * 1000); 
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt(); 
		}
	}
}
