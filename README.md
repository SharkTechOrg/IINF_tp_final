# IINF_tp_final

Este repositorio contiene el trabajo práctico final de la materia **Ingeniería de Software** de la carrera **Tecnicatura Superior de Desarrollo de Software** del Instituto *Leopoldo Marechal*. El proyecto fue desarrollado por el equipo **SharkTech** y presentado en julio de 2025 bajo la cátedra del profesor **Agustín Arias**.

## Objetivo
El objetivo principal es implementar en código los diagramas de secuencia trabajados durante la cursada. Se simula el flujo de solicitud y ejecución de un viaje similar a Uber, siguiendo el caso de uso provisto por la materia.

## Estructura del proyecto

```
.
├── Diagramas                # Archivos PDF y drawio de los diagramas
├── Uber_Trip_Request        # Flujo de solicitud de viaje por consola
│   ├── UberRequestFlow.java # Punto de entrada de la demo
│   └── src/com/uber         # Controladores, modelos, repositorios y UI
└── Uber_Trip_Simulation     # Simulación completa del viaje
    └── com/uber             # Controlador de viaje, modelos y repositorio
```

## Cómo compilar y ejecutar

### Uber_Trip_Request
Compilar y ejecutar desde el directorio `Uber_Trip_Request`:

```bash
cd Uber_Trip_Request
javac UberRequestFlow.java src/com/uber/**/*.java
java UberRequestFlow
```

### Uber_Trip_Simulation
Compilar y ejecutar desde el directorio `Uber_Trip_Simulation`:

```bash
cd Uber_Trip_Simulation
javac com/uber/**/*.java
java com.uber.UberFlow
```

## Equipo de desarrollo
- Lourdes Helman
- Paula Martinez Farías
- Daiana Rodriguez
- Santiago Villanueva
- Jorge Marinoni

---
**SharkTech** – Julio de 2025
