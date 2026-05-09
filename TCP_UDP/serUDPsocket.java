import java.net.*;
import java.io.*;

public class serUDPsocket {
   
   public static void main(String argv[]) {
      
      // Mensaje de inicio del servidor
      System.out.println("Prueba de sockets UDP (servidor)");
      
      DatagramSocket socket; // Socket UDP
      boolean fin = false;   // Control para terminar el programa

      try {
         // Crea el socket UDP en el puerto 6000
         System.out.print("Creando socket... ");
         socket = new DatagramSocket(6000);
         System.out.println("ok");

         // Indica que está listo para recibir mensajes
         System.out.println("Recibiendo mensajes... ");
         
         // Ciclo para recibir mensajes continuamente
         do {
            // Buffer donde se almacenarán los datos recibidos
            byte[] mensaje_bytes = new byte[256];
            
            // Paquete UDP que contendrá los datos
            DatagramPacket paquete = new DatagramPacket(mensaje_bytes, 256);
            
            // Espera (bloquea) hasta recibir un paquete
            socket.receive(paquete);
            
            // Variable para guardar el mensaje en formato texto
            String mensaje = "";
            
            // Convierte el arreglo de bytes en String
            mensaje = new String(mensaje_bytes);
            
            // Imprime el mensaje recibido
            System.out.println(mensaje);
            
            // Si el mensaje empieza con "fin", termina el servidor
            if (mensaje.startsWith("fin")) fin = true;

         } while (!fin); 
      }
      catch (Exception e) {
         // Manejo de errores
         System.err.println(e.getMessage());
         System.exit(1);
      }
   }
}
