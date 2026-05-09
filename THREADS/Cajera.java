package tallerThreads;

public class Cajera {

        // Nombre de la cajera
        private String nombre;

        // Constructor
        public Cajera(String nombre) {
                this.nombre = nombre;
        }

        // Procesa la compra de un cliente
        public void procesarCompra(Cliente cliente, long timeStamp) {

                // Inicio de atención
                System.out.println("La cajera " + this.nombre +
                                " comienza a procesar la compra del cliente "
                                + cliente.getNombre() +
                                " en el tiempo: "
                                + (System.currentTimeMillis() - timeStamp) / 1000);

                // Recorre los productos del cliente
                for (int i = 0; i < cliente.getCarroCompra().length; i++) {

                        // Simula tiempo de procesamiento
                        this.esperarXsegundos(cliente.getCarroCompra()[i]);

                        // Muestra producto procesado
                        System.out.println("Procesado el producto " + (i + 1) +
                                        " del cliente " + cliente.getNombre() +
                                        " -> Tiempo: "
                                        + (System.currentTimeMillis() - timeStamp) / 1000);
                }

                // Fin de atención
                System.out.println("La cajera " + this.nombre +
                                " ha terminado de procesar "
                                + cliente.getNombre() +
                                " en el tiempo: "
                                + (System.currentTimeMillis() - timeStamp) / 1000);
        }

        // Pausa el programa unos segundos
        private void esperarXsegundos(int segundos) {

                try {

                        Thread.sleep(segundos * 1000);

                } catch (InterruptedException ex) {

                        Thread.currentThread().interrupt();
                }
        }
}
