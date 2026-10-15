
# Diagrama 
```mermaid
classDiagram
    direction LR
    class Nodo~T~ {
        - T dato
        - Nodo~T~ izquierdo
        - Nodo~T~ derecho
        + Nodo(T dato)
        + getDato() T
        + setDato(T dato) void
        + getIzquierdo() Nodo~T~
        + setIzquierdo(Nodo~T~ izquierdo) void
        + getDerecho() Nodo~T~
        + setDerecho(Nodo~T~ derecho) void
        + esHoja() boolean
        + grado() int
    }
    class ArbolBinario~T~ {
        - Nodo~T~ raiz
        + ArbolBinario()
        + getRaiz() Nodo~T~
        + esVacio() boolean
        + crearRaiz(T dato) void
        + agregarIzquierdo(Nodo~T~ padre, T dato) boolean
        + agregarDerecho(Nodo~T~ padre, T dato) boolean
        + contarNodos() int
        - contarNodosRec(Nodo~T~ nodo) int
        + contarHojas() int
        - contarHojasRec(Nodo~T~ nodo) int
        + altura() int
        - alturaRec(Nodo~T~ nodo) int
        + buscar(T dato) Nodo~T~
        - buscarRec(Nodo~T~ nodo, T dato) Nodo~T~
        + mostrarArbol() void
        - mostrarArbolRec(Nodo~T~ nodo, String prefijo, boolean esUltimo) void
    }
    class Main {
        + main(String[] args)$ void
    }
    ArbolBinario --> Nodo : contiene raiz
    Nodo --> Nodo : izquierdo / derecho
    Main ..> ArbolBinario : usa
    Main ..> Nodo : usa
