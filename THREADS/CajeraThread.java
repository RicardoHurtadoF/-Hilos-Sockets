package tallerThreads;

public class CajeraThread extends Thread {

	// Nombre de la cajera
	private String nombre;

	// Cliente que será atendido
	private Cliente cliente;

	// Tiempo inicial de ejecución
	private long initialTime;

	// Constructor
	public CajeraThread(String nombre, Cliente cliente, long initialTime) {
		this.nombre = nombre;
		this.cliente = cliente;
		this.initialTime = initialTime;
	}

	// Método principal del hilo
	@Override
	public void run() {

		// Inicio de atención
		System.out.println("La cajera " + this.nombre +
				" comienza a procesar la compra del cliente " + cliente.getNombre() +
				" en el tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");

		// Recorre los productos del cliente
		for (int i = 0; i < cliente.getCarroCompra().length; i++) {

			// Simula tiempo de procesamiento
			this.esperarXsegundos(cliente.getCarroCompra()[i]);

			// Muestra producto procesado
			System.out.println("Procesado el producto " + (i + 1) +
					" del cliente " + cliente.getNombre() +
					" ->Tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
		}

		// Fin de atención
		System.out.println("La cajera " + this.nombre +
				" ha terminado de procesar " + cliente.getNombre() +
				" en el tiempo: " + (System.currentTimeMillis() - this.initialTime) / 1000 + "seg");
	}

	// Pausa el hilo unos segundos
	private void esperarXsegundos(int segundos) {

		try {

			Thread.sleep(segundos * 1000);

		} catch (InterruptedException ex) {

			Thread.currentThread().interrupt();
		}
	}
}
