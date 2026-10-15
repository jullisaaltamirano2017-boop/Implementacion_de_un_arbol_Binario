# Implementación de un árbol binario

**Asignatura:** Estructura de Datos · **Nivel:** Tercero – Ingeniería de Software
**Autora:** Jullisa Altamirano · **Herramientas:** Java, Visual Studio Code, GitHub

## 1. Problema
La Universidad necesita representar la organización de sus dependencias académicas mediante un **árbol binario**: cada nodo guarda el nombre de una dependencia y tiene como máximo dos hijos. La aplicación debe construir, visualizar y analizar esa estructura (nodos, hojas, altura y grado de un nodo).

## 2. Estructura del árbol

```
UNIVERSIDAD
+-- [I] FISEI
|   +-- [I] SOFTWARE
|   |   +-- [I] NIVEL1
|   |   +-- [D] NIVEL3
|   +-- [D] TI
+-- [D] DIDE
    +-- [I] INVEST.
    +-- [D] VINCULACIÓN
```

| Propiedad | Valor |
|-----------|-------|
| Nodos | 9 |
| Hojas | 5 (TI, NIVEL1, NIVEL3, INVEST., VINCULACIÓN) |
| Altura | 3 aristas |

## 3. Organización del proyecto

```
src/
 ├── modelo/
 │    └── Nodo.java            // Nodo<T>: dato, izquierdo, derecho, esHoja(), grado()
 ├── negocio/
 │    └── ArbolBinario.java    // crearRaiz, agregarIzquierdo/Derecho, contarNodos, contarHojas, altura, esVacio, mostrarArbol
 └── app/
      └── Main.java            // menú interactivo con Scanner y casos de prueba
```

Decisiones de implementación:
- `contarNodos()`, `contarHojas()`, `altura()` y `buscar()` son **recursivas**.
- La altura se mide en **aristas**: árbol vacío = -1, un solo nodo = 0.
- `agregarIzquierdo` / `agregarDerecho` devuelven `false` si la posición ya está ocupada (no sobrescriben).
- No se usan `TreeSet`, `TreeMap`, `PriorityQueue`, `NavigableSet` ni `NavigableMap`.

## 4. Instrucciones de ejecución

Requisitos: JDK 8 o superior.

```bash
# Desde la raíz del repositorio
javac -encoding UTF-8 -d out src/modelo/Nodo.java src/negocio/ArbolBinario.java src/app/Main.java
java -cp out app.Main
```

En Visual Studio Code: abrir la carpeta del proyecto, abrir `src/app/Main.java` y pulsar **Run**.
> Si en la consola de Windows se ven mal las tildes, ejecutar antes `chcp 65001`.

## 5. Menú de la aplicación

| Opción | Acción |
|--------|--------|
| 1 | Crear el árbol inicial |
| 2 | Visualizar el árbol |
| 3 | Consultar el número de nodos |
| 4 | Consultar el número de hojas |
| 5 | Consultar la altura |
| 6 | Consultar el grado de un nodo |
| 7 | Verificar si un nodo es hoja |
| 8 | Ejecutar casos de prueba |
| 9 | Salir |

## 6. Casos de prueba y resultados

| # | Caso | Esperado | Obtenido |
|---|------|----------|----------|
| 1 | Árbol vacío | 0 nodos, altura -1 | 0 nodos, altura -1 |
| 2 | Un solo nodo | 1 hoja, altura 0 | 1 nodo, 1 hoja, altura 0 |
| 3 | Árbol inicial | 9 nodos, 5 hojas, altura 3 | 9 nodos, 5 hojas, altura 3 |
| 4 | Insertar en posición ocupada | Rechazado | `false` (no se inserta) |
| 5 | Grado de FISEI y SOFTWARE | 2 y 2 | 2 y 2 |

### Capturas de pantalla
_Agregar aquí las capturas de la ejecución (carpeta `capturas/`):_

- `![Menú y árbol inicial](capturas/01-arbol-inicial.png)`
- `![Casos de prueba](capturas/02-casos-de-prueba.png)`
- `![Consulta de grado y hojas](capturas/03-consultas.png)`
