// ==================
// CLIENTE TCP
// ==================
import java.net.*;
import java.io.*;

public class cliTCPsocket {

   public static void main(String argv[]) {

      // Verifica que se haya pasado la dirección del servidor como argumento
      if (argv.length == 0) {
         System.err.println("JAVA cliTCPsocket <<SERVIDOR>>");
         System.exit(1); // Termina el programa si no hay argumento
      }

      // Buffer para leer entrada desde teclado
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

      System.out.println("Prueba de sockets TCP (CLIENTE)");
      
      // Declaración de variables
      Socket socket;                 // Socket cliente
      InetAddress address;           // Dirección IP del servidor
      byte[] mensaje_bytes = new byte[256]; // (No se usa realmente)
      String mensaje="";             // Mensaje a enviar

      try {
         // Obtiene la dirección IP del servidor a partir del argumento
         System.out.print("Capturando direccion de host... ");
         address = InetAddress.getByName(argv[0]);
         System.out.println("ok");

         // Crea el socket y se conecta al servidor en el puerto 6001
         System.out.print("Creando socket... ");
         socket = new Socket(address,6001);
         System.out.println("ok");

         // Flujo de salida para enviar datos al servidor
         DataOutputStream out =
            new DataOutputStream(socket.getOutputStream());

         // Mensaje para el usuario
         System.out.println("Introduce mensajes a enviar:");

         // Ciclo para enviar múltiples mensajes
         do {
            // Lee un mensaje desde teclado
            mensaje = in.readLine();

            // Envía el mensaje al servidor en formato UTF
            out.writeUTF(mensaje);

         // El ciclo termina cuando el mensaje empieza con "fin"
         } while (!mensaje.startsWith("fin"));
      }
      catch (Exception e) {
         // Manejo de errores
         System.err.println(e.getMessage());
         System.exit(1);
      }
   }
}
}
