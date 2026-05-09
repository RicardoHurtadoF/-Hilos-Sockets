# Taller 04 – Sockets TCP vs UDP y Ejecución Secuencial vs Multihilos
## Autor

* Ricardo Hurtado, Jose Guerrero, Samuel Giraldo
* Curso: Introduccion a sistemas distribuidos

---

## 1. Descripción

Este proyecto implementa:

* Comunicación cliente-servidor usando **TCP y UDP**
* Simulación de atención de clientes usando:

  * **Modelo secuencial**
  * **Modelo multihilo (threads)**

El objetivo es comparar rendimiento, comportamiento y escalabilidad.

---

## 2. Estructura del Proyecto

```
.
├── cliTCPsocket.java
├── serTCPsocket.java
├── cliUDPsocket.java
├── serUDPsocket.java
├── Cajera.java
├── CajeraThread.java
├── Cliente.java
├── Main.java
├── MainRunnable.java
├── MainThread.java
├── Makefile
├── Informe/
└── README.md
```

---

## 3. Parte 1 – Sockets (TCP vs UDP)

### TCP

* Comunicación confiable
* Orientado a conexión
* Usa streams (`DataInputStream`, `DataOutputStream`)

### UDP

* Comunicación rápida
* No confiable
* Usa datagramas (`DatagramPacket`)

---

## 4. Parte 2 – Secuencial vs Multihilos

### Archivos clave

* `Cajera.java` → lógica de atención (secuencial)
* `CajeraThread.java` → versión con threads
* `Cliente.java` → representa cliente con productos
* `Main.java` → ejecución secuencial
* `MainThread.java` → ejecución con threads (herencia de Thread)
* `MainRunnable.java` → ejecución con Runnable

---

### 4.1 Modelo Secuencial

* Un solo flujo de ejecución
* Atiende clientes uno por uno
* Mayor tiempo total

Ejecutar:

```
java Main
```

---

### 4.2 Modelo Multihilos

* Cada cliente es atendido en un hilo independiente
* Atención simultánea
* Reduce el tiempo total

Ejecutar:

```
java MainThread
```

o

```
java MainRunnable
```

---

## 5. Comparación Threads vs Secuencial

| Característica | Secuencial   | Threads  |
| -------------- | ------------ | -------- |
| Ejecución      | Uno a la vez | Paralela |
| Tiempo total   | Alto         | Bajo     |
| Uso CPU        | Bajo         | Alto     |
| Escalabilidad  | Baja         | Alta     |

---

## 6. Pruebas Realizadas

### Sockets

* Envío de múltiples mensajes
* Comparación TCP vs UDP

### Threads

* Tiempo total de atención
* Número de clientes simultáneos

---

## 7. Resultados Esperados

* **TCP**: más lento pero confiable
* **UDP**: más rápido pero sin garantía
* **Secuencial**: mayor tiempo total
* **Threads**: mejor rendimiento

---

## 8. Análisis

* TCP asegura integridad de datos
* UDP optimiza velocidad
* Threads permiten paralelismo real
* El modelo secuencial no escala

---

## 9. Conclusiones

* Para sistemas críticos → TCP
* Para tiempo real → UDP
* Para múltiples usuarios → Threads
* Mejor rendimiento → **UDP + Threads**

---

## 10. Observaciones

* Threads requieren manejo de concurrencia
* UDP puede perder datos
* TCP introduce overhead
* Es importante cerrar sockets

---

## 11. Compilación

```
javac *.java
```


