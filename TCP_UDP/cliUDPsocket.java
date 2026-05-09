// ==================
// CLIENTE UDP
// ==================

import java.net.*;
import java.io.*;

public class cliUDPsocket {
   
   public static void main(String argv[]) {
      
      // Verifica que se haya pasado la dirección del servidor
      if (argv.length == 0) {
         System.err.println("Java socketudpcli servidor");
         System.exit(1);
      }

      // Buffer para leer entrada desde teclado
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Prueba de sockets UDP (cliente)");
      
      DatagramSocket socket;     // Socket UDP
      InetAddress address;       // Dirección del servidor
      byte[] mensaje_bytes = new byte[256]; // Buffer de bytes
      String mensaje = "";       // Mensaje a enviar
      DatagramPacket paquete;    // Paquete UDP

      // Inicializa el arreglo de bytes (aunque aquí no es necesario aún)
      mensaje_bytes = mensaje.getBytes();
      
      try {
         // Crea el socket UDP (no necesita conexión previa)
         System.out.print("Creando socket... ");
         socket = new DatagramSocket();
         System.out.println("ok");

         // Obtiene la dirección IP del servidor
         System.out.print("Capturando direccion de host... ");
         address = InetAddress.getByName(argv[0]);
         System.out.println("ok");

         // Solicita mensajes al usuario
         System.out.println("Introduce mensajes a enviar:");

         // Ciclo para enviar múltiples mensajes
         do {
            // Lee mensaje desde teclado
            mensaje = in.readLine();
            
            // Convierte el mensaje a bytes
            mensaje_bytes = mensaje.getBytes();
            
            // Crea el paquete UDP con:
            // - datos (mensaje_bytes)
            // - tamaño del mensaje
            // - dirección del servidor
            // - puerto destino (6000)
            paquete = new DatagramPacket(mensaje_bytes, mensaje.length(), address, 6000);
            
            // Envía el paquete al servidor
            socket.send(paquete);

         // Termina cuando el mensaje empieza con "fin"
         } while (!mensaje.startsWith("fin")); 
      }
      catch (Exception e) {
         // Manejo de errores
         System.err.println(e.getMessage());
         System.exit(1);
      }
   }
}
