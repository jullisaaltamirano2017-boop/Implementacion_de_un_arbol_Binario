package negocio;

import modelo.Nodo;

public class ArbolBinario<T> {

    private Nodo<T> raiz;

    public ArbolBinario() {
        this.raiz = null;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public boolean crearRaiz(T dato) {
        if (raiz != null) {
            return false;
        }
        raiz = new Nodo<>(dato);
        return true;
    }

    public boolean agregarIzquierdo(Nodo<T> padre, T dato) {
        if (padre == null || padre.getIzquierdo() != null) {
            return false;
        }
        padre.setIzquierdo(new Nodo<>(dato));
        return true;
    }

    public boolean agregarDerecho(Nodo<T> padre, T dato) {
        if (padre == null || padre.getDerecho() != null) {
            return false;
        }
        padre.setDerecho(new Nodo<>(dato));
        return true;
    }

    public boolean esVacio() {
        return raiz == null;
    }


    public int contarNodos() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        return 1 + contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
    }

    public int contarHojas() {
        return contarHojas(raiz);
    }

    private int contarHojas(Nodo<T> nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.esHoja()) {
            return 1;
        }
        return contarHojas(nodo.getIzquierdo()) + contarHojas(nodo.getDerecho());
    }

    public int altura() {
        return altura(raiz);
    }

    private int altura(Nodo<T> nodo) {
        if (nodo == null) {
            return -1;
        }
        return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
    }

    public Nodo<T> buscar(T dato) {
        return buscar(raiz, dato);
    }

    private Nodo<T> buscar(Nodo<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }
        if (String.valueOf(nodo.getDato()).equalsIgnoreCase(String.valueOf(dato))) {
            return nodo;
        }
        Nodo<T> enIzquierdo = buscar(nodo.getIzquierdo(), dato);
        if (enIzquierdo != null) {
            return enIzquierdo;
        }
        return buscar(nodo.getDerecho(), dato);
    }

    public void mostrarArbol() {
        if (esVacio()) {
            System.out.println("(árbol vacío)");
            return;
        }
        System.out.println(raiz.getDato());
        mostrarHijos(raiz, "");
    }

    private void mostrarHijos(Nodo<T> nodo, String prefijo) {
        Nodo<T> izq = nodo.getIzquierdo();
        Nodo<T> der = nodo.getDerecho();
        if (izq != null) {
            System.out.println(prefijo + "+-- [I] " + izq.getDato());
            mostrarHijos(izq, prefijo + (der != null ? "|   " : "    "));
        }
        if (der != null) {
            System.out.println(prefijo + "+-- [D] " + der.getDato());
            mostrarHijos(der, prefijo + "    ");
        }
    }
}