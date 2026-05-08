Taller 04 – Comparación TCP vs UDP y Ejecución Secuencial vs Multihilos
1. Descripción General

Este proyecto implementa un sistema cliente-servidor para analizar el comportamiento de:

Protocolos de red: TCP vs UDP
Modelos de ejecución: Secuencial vs Multihilos (Threads)

El objetivo es evaluar diferencias en rendimiento, confiabilidad y eficiencia mediante pruebas experimentales.

2. Objetivos
Objetivo General

Comparar el desempeño de TCP y UDP junto con modelos secuenciales y concurrentes en un entorno de comunicación cliente-servidor.

Objetivos Específicos
Implementar cliente y servidor usando TCP y UDP
Implementar versiones secuenciales y con threads
Medir tiempos de respuesta y throughput
Analizar diferencias en comportamiento y rendimiento
3. Estructura del Proyecto
.
├── cliente_tcp.c
├── servidor_tcp.c
├── cliente_udp.c
├── servidor_udp.c
├── Makefile
├── resultados/
├── capturas/
└── README.md
4. Explicación Teórica
4.1 TCP vs UDP
Característica	TCP	UDP
Tipo	Orientado a conexión	No orientado a conexión
Confiabilidad	Alta (garantiza entrega)	Baja (no garantiza entrega)
Orden de datos	Garantizado	No garantizado
Velocidad	Más lento	Más rápido
Control de errores	Sí	No
TCP
Establece conexión (handshake)
Garantiza entrega de paquetes
Reenvía paquetes perdidos
Mayor sobrecarga
UDP
No establece conexión
Envía datos directamente
Menor latencia
Puede perder paquetes
4.2 Secuencial vs Multihilos
Característica	Secuencial	Multihilos
Ejecución	Una tarea a la vez	Varias tareas simultáneas
Uso CPU	Bajo	Alto
Escalabilidad	Limitada	Alta
Complejidad	Baja	Alta
Secuencial
Atiende un cliente por vez
Bloquea ejecución hasta terminar
Simple de implementar
Multihilos
Atiende múltiples clientes simultáneamente
Usa threads para concurrencia
Mejor rendimiento bajo carga
5. Instrucciones de Uso
Compilación
make all
Ejecución
TCP

Servidor:

./servidor_tcp

Cliente:

./cliente_tcp
UDP

Servidor:

./servidor_udp

Cliente:

./cliente_udp
6. Metodología de Pruebas

Se realizaron pruebas variando:

Número de clientes simultáneos
Tipo de protocolo (TCP / UDP)
Tipo de ejecución (secuencial / threads)
Métricas evaluadas:
Tiempo de respuesta
Tiempo total de ejecución
Uso de CPU
Pérdida de paquetes (en UDP)
7. Resultados y Comparativas
Ejemplo de resultados
Configuración	Tiempo promedio	Observaciones
TCP Secuencial	Alto	Bloqueo por cliente
TCP Threads	Medio	Mejor concurrencia
UDP Secuencial	Bajo	Sin garantía
UDP Threads	Muy bajo	Máximo rendimiento
8. Análisis
TCP es más confiable pero introduce mayor latencia.
UDP es más rápido, pero puede perder información.
Threads mejoran significativamente el rendimiento en múltiples clientes.
El modelo secuencial no escala bien bajo carga.
9. Conclusiones
Para aplicaciones críticas → usar TCP
Para aplicaciones en tiempo real → usar UDP
Para sistemas con múltiples usuarios → usar multihilos
El mejor rendimiento general se obtuvo con:
UDP + Threads
10. Observaciones
UDP requiere manejo adicional de errores si se necesita confiabilidad.
Threads aumentan complejidad (sincronización, memoria).
TCP puede saturarse con muchos clientes simultáneos.
11. Evidencia (Capturas)

Las capturas de ejecución se encuentran en:

/capturas

Incluyen:

Ejecución de servidor
Conexiones múltiples
Comparación de tiempos
12. Informe PDF

El informe completo incluye:

Introducción
Marco teórico
Metodología
Experimentos
Resultados
Análisis
Conclusiones

Ubicación:

/docs/informe.pdf
