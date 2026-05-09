// ==================
// SERVIDOR TCP
// ==================

public class serTCPsocket {

   public static void main(String argv[]) {
      
      // Mensaje de inicio del servidor
      System.out.println("\n\n\t=**SOCKETS TCP <<SERVIDOR>>");
      
      ServerSocket socket; // Socket servidor (escucha conexiones)
      boolean fin = false; // (No se usa realmente)

      try {
         // Crea el servidor en el puerto 6001
         socket = new ServerSocket(6001);
         
         // Espera (bloquea) hasta que un cliente se conecte
         Socket socket_cli = socket.accept();
         
         // Flujo de entrada para recibir datos del cliente
         DataInputStream in =
            new DataInputStream(socket_cli.getInputStream());
         
         // Ciclo infinito para recibir mensajes
         do {
            String mensaje ="";
            
            // Lee un mensaje enviado por el cliente (formato UTF)
            mensaje = in.readUTF();
            
            // Imprime el mensaje recibido en consola
            System.out.println(mensaje);

         // Condición siempre verdadera → ciclo infinito
         } while (1>0);

      }
      catch (Exception e) {
         // Manejo de errores
         System.err.println(e.getMessage());
         System.exit(1);
      }
   }
}
