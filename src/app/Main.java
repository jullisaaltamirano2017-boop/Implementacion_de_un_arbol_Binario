package app;

import modelo.Nodo;
import negocio.ArbolBinario;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArbolBinario<String> arbol = new ArbolBinario<>();
        int opcion = 0;

        do {
            System.out.println("\n--- SISTEMA DE ORGANIZACIÓN JERÁRQUICA - ÁRBOL BINARIO ---");
            System.out.println("1. Crear el árbol inicial (Universidad)");
            System.out.println("2. Visualizar el árbol");
            System.out.println("3. Consultar el número total de nodos");
            System.out.println("4. Consultar el número total de hojas");
            System.out.println("5. Consultar la altura del árbol");
            System.out.println("6. Consultar el grado de un nodo");
            System.out.println("7. Verificar si un nodo es hoja");
            System.out.println("8. Probar casos de acuerdo a requerimientos");
            System.out.println("9. Salir");
            System.out.print("Seleccione una opción: ");

            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Por favor, ingrese un número válido.");
                scanner.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    arbol.crearRaiz("UNIVERSIDAD");
                    Nodo<String> raiz = arbol.getRaiz();
                    
                    arbol.agregarIzquierdo(raiz, "FISEI");
                    arbol.agregarDerecho(raiz, "DIDE");
                    
                    Nodo<String> fisei = raiz.getIzquierdo();
                    arbol.agregarIzquierdo(fisei, "SOFTWARE");
                    arbol.agregarDerecho(fisei, "TI");
                    
                    Nodo<String> dide = raiz.getDerecho();
                    arbol.agregarIzquierdo(dide, "INVEST.");
                    arbol.agregarDerecho(dide, "VINCULACIÓN");
                    
                    Nodo<String> software = fisei.getIzquierdo();
                    arbol.agregarIzquierdo(software, "NIVEL1");
                    arbol.agregarDerecho(software, "NIVEL3");
                    
                    System.out.println("¡Árbol inicial construido exitosamente!");
                    break;

                case 2:
                    System.out.println("\nEstructura del Árbol:");
                    arbol.mostrarArbol();
                    break;

                case 3:
                    System.out.println("Número total de nodos: " + arbol.contarNodos());
                    break;

                case 4:
                    System.out.println("Número total de hojas: " + arbol.contarHojas());
                    break;

                case 5:
                    System.out.println("Altura del árbol (en aristas): " + arbol.altura());
                    break;

                case 6:
                    System.out.print("Ingrese el nombre del nodo a consultar (ej. FISEI, SOFTWARE): ");
                    String nombreNodoGrado = scanner.nextLine().trim().toUpperCase();
                    Nodo<String> nodoBuscadoG = arbol.buscar(nombreNodoGrado);
                    if (nodoBuscadoG != null) {
                        System.out.println("El grado del nodo [" + nombreNodoGrado + "] es: " + nodoBuscadoG.grado());
                    } else {
                        System.out.println("Nodo no encontrado en el árbol.");
                    }
                    break;

                case 7:
                    System.out.print("Ingrese el nombre del nodo a verificar (ej. NIVEL1, DIDE): ");
                    String nombreNodoHoja = scanner.nextLine().trim().toUpperCase();
                    Nodo<String> nodoBuscadoH = arbol.buscar(nombreNodoHoja);
                    if (nodoBuscadoH != null) {
                        if (nodoBuscadoH.esHoja()) {
                            System.out.println("El nodo [" + nombreNodoHoja + "] SÍ es una hoja.");
                        } else {
                            System.out.println("El nodo [" + nombreNodoHoja + "] NO es una hoja.");
                        }
                    } else {
                        System.out.println("Nodo no encontrado en el árbol.");
                    }
                    break;

                case 8:
                    System.out.println("\n--- DEMOSTRACIÓN DE CASOS DE PRUEBA OBLIGATORIOS ---");
                    ArbolBinario<String> arbolVacio = new ArbolBinario<>();
                    System.out.println("-> Árbol Vacío | Nodos: " + arbolVacio.contarNodos() + " | Altura: " + arbolVacio.altura());
                    
                    ArbolBinario<String> arbolUnico = new ArbolBinario<>();
                    arbolUnico.crearRaiz("UNICO");
                    System.out.println("-> Árbol Un Nodo | Hojas: " + arbolUnico.contarHojas() + " | Altura: " + arbolUnico.altura());
                    
                    System.out.println("-> Árbol Inicial | Nodos: " + arbol.contarNodos() + " | Hojas: " + arbol.contarHojas() + " | Altura: " + arbol.altura());
                    
                    if (!arbol.esVacio()) {
                        System.out.println("-> Probando inserción en posición ocupada (FISEI):");
                        arbol.agregarIzquierdo(arbol.getRaiz().getIzquierdo(), "OTRO_NODO");
                    }
                    
                    Nodo<String> nFisei = arbol.buscar("FISEI");
                    Nodo<String> nSoftware = arbol.buscar("SOFTWARE");
                    if (nFisei != null) System.out.println("-> Grado de FISEI: " + nFisei.grado());
                    if (nSoftware != null) System.out.println("-> Grado de SOFTWARE: " + nSoftware.grado());
                    break;

                case 9:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 9);

        scanner.close();
    }
}