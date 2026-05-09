Aquí lo tienes en **Markdown limpio (sin bloques raros)** listo para copiar y pegar en GitHub:

---

# Taller 04 – Sockets TCP vs UDP y Ejecución Secuencial vs Multihilos

## 1. Descripción

Este proyecto implementa un sistema cliente-servidor en Java utilizando TCP y UDP, con el objetivo de analizar sus diferencias en funcionamiento, rendimiento y comportamiento. También se compara la ejecución secuencial frente al uso de multihilos (threads).

---

## 2. Objetivos

### Objetivo General

Evaluar el desempeño de diferentes modelos de comunicación y ejecución en sistemas distribuidos.

### Objetivos Específicos

* Implementar cliente y servidor TCP
* Implementar cliente y servidor UDP
* Analizar diferencias entre TCP y UDP
* Comparar ejecución secuencial vs multihilos
* Realizar pruebas de rendimiento

---

## 3. Estructura del Proyecto

```
.
├── cliTCPsocket.java
├── serTCPsocket.java
├── cliUDPsocket.java
├── serUDPsocket.java
├── capturas/
├── resultados/
└── README.md
```

---

## 4. Explicación Teórica

### 4.1 TCP vs UDP

| Característica     | TCP                  | UDP                     |
| ------------------ | -------------------- | ----------------------- |
| Tipo               | Orientado a conexión | No orientado a conexión |
| Confiabilidad      | Alta                 | Baja                    |
| Orden de datos     | Garantizado          | No garantizado          |
| Control de errores | Sí                   | No                      |
| Velocidad          | Más lento            | Más rápido              |

#### TCP

* Establece conexión (handshake)
* Garantiza entrega de datos
* Reenvía paquetes perdidos
* Mayor consumo de recursos

#### UDP

* No establece conexión
* Envía paquetes directamente
* Menor latencia
* Puede perder información

---

### 4.2 Secuencial vs Multihilos

| Característica | Secuencial          | Multihilos                         |
| -------------- | ------------------- | ---------------------------------- |
| Ejecución      | Un cliente a la vez | Múltiples clientes simultáneamente |
| Rendimiento    | Bajo bajo carga     | Alto                               |
| Complejidad    | Baja                | Media/Alta                         |
| Escalabilidad  | Limitada            | Alta                               |

#### Secuencial

* Atiende un cliente por vez
* Bloquea la ejecución
* Fácil de implementar

#### Multihilos (Threads)

* Atiende múltiples clientes simultáneamente
* Usa hilos independientes
* Mejora el rendimiento

---

## 5. Funcionamiento del Sistema

### TCP

* Servidor escucha en el puerto **6001**
* Cliente se conecta al servidor
* Comunicación confiable mediante streams

### UDP

* Servidor escucha en el puerto **6000**
* No hay conexión previa
* Comunicación mediante datagramas

---

## 6. Instrucciones de Ejecución

### Compilación

```bash
javac *.java
```

### Ejecución

#### Servidor TCP

```bash
java serTCPsocket
```

#### Cliente TCP

```bash
java cliTCPsocket <IP_SERVIDOR>
```

#### Servidor UDP

```bash
java serUDPsocket
```

#### Cliente UDP

```bash
java cliUDPsocket <IP_SERVIDOR>
```

---

## 7. Pruebas Realizadas

Se realizaron pruebas con:

* Envío de múltiples mensajes
* Comparación de tiempos
* Pruebas con varios clientes

### Métricas evaluadas

* Tiempo de respuesta
* Latencia
* Pérdida de paquetes (UDP)
* Capacidad de atención simultánea

---

## 8. Resultados y Comparativa

| Configuración  | Resultado                        |
| -------------- | -------------------------------- |
| TCP Secuencial | Alta confiabilidad, mayor tiempo |
| UDP Secuencial | Rápido, posible pérdida de datos |
| TCP Multihilos | Buen equilibrio                  |
| UDP Multihilos | Máximo rendimiento               |

---

## 9. Análisis

* TCP es ideal cuando se requiere integridad de datos
* UDP es mejor para velocidad y tiempo real
* El modelo secuencial limita el rendimiento
* Los threads mejoran la capacidad de respuesta

---

## 10. Conclusiones

* TCP garantiza comunicación confiable pero con mayor costo
* UDP ofrece mayor velocidad pero sin garantías
* Los threads mejoran significativamente el rendimiento
* La mejor opción depende del tipo de aplicación

