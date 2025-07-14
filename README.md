# IINF_tp_final

Este repositorio contiene el trabajo práctico final de la materia **Ingeniería de Software** de la carrera **Tecnicatura Superior de Desarrollo de Software** del Instituto *Leopoldo Marechal*. El proyecto fue desarrollado por el equipo **SharkTech** y presentado en julio de 2025 bajo la cátedra del profesor **Agustín Arias**.

## Objetivo
El objetivo principal es implementar en código los diagramas de secuencia trabajados durante la cursada. Se simula el flujo de solicitud y ejecución de un viaje similar a Uber, siguiendo el caso de uso provisto por la materia.

Durante el desarrollo se trabajó de forma **modular**, creando cada funcionalidad en un directorio independiente. Una vez completados los módulos se realizó una **integración final** que reúne todos los componentes en un sistema único.

## Estructura del proyecto

```
.
├── Diagramas                    # Archivos PDF y drawio de los diagramas
├── Uber_Trip_Request            # Módulo de solicitud de viaje por consola
│   ├── UberRequestFlow.java     # Punto de entrada de la demo
│   └── src/com/uber             # Controladores, modelos, repositorios y UI
├── Uber_Trip_Simulation         # Módulo de simulación del viaje
│   └── com/uber                 # Controlador de viaje, modelos y repositorio
└── UBER_INTEGRATION             # Sistema integrado final
    └── UBER_INTEGRATED_SYSTEM   # Contiene MAIN.java para ejecutar el proyecto
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

### UBER_INTEGRATION
Una vez integrados todos los módulos, el sistema completo se ejecuta desde `MAIN.java` ubicado en `UBER_INTEGRATION/UBER_INTEGRATED_SYSTEM`.

```bash
cd UBER_INTEGRATION/UBER_INTEGRATED_SYSTEM
javac Main.java
java Main
```

## Equipo de desarrollo
- Lourdes Helman
- Paula Martinez Farías
- Daiana Rodriguez
- Santiago Villanueva
- Jorge Marinoni

---
**SharkTech** – Julio de 2025