package tallerThreads;

public class Cliente {

	// Nombre del cliente
	private String nombre;

	// Productos del carrito
	private int[] carroCompra;

	// Constructor
	public Cliente(String nombre, int[] carroCompra) {
		this.nombre = nombre;
		this.carroCompra = carroCompra;
	}

	// Retorna el nombre del cliente
	public String getNombre() {
		return nombre;
	}

	// Retorna los productos del carrito
	public int[] getCarroCompra() {
		return carroCompra;
	}
}
