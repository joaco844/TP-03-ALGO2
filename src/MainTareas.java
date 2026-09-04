package src;

import java.util.Scanner;

/**
 * Consola de la opcion 2: Lista de Tareas.
 * Un error no cierra el programa ni vuelve a un menu anterior: se retoma aca.
 */
public class MainTareas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ejecutar(scanner);
        scanner.close();
    }

    public static void ejecutar(Scanner scanner) {
        ListaTareas lista = new ListaTareas();
        boolean salir = false;

        System.out.println("Entro a la consola Lista de Tareas");

        while (!salir) {
            lista.mostrarTareas();

            System.out.println("que accion quiere realizar?");
            System.out.println("1.AGREGAR TAREA");
            System.out.println("2.REMOVER TAREA");
            System.out.println("3.MARCAR/DESMARCAR TAREA");
            System.out.println("4.SALIR");

            Integer opcion = Entrada.leerEntero(scanner);
            if (opcion == null) {
                continue;
            }

            try {
                switch (opcion) {
                    case 1:
                        String nombre = Entrada.leerTexto(scanner, "Ingrese el nombre de la tarea: ");
                        lista.agregarTarea(nombre);
                        break;
                    case 2:
                        removerTarea(scanner, lista);
                        break;
                    case 3:
                        Integer numMarcar = Entrada.leerEntero(scanner, "Ingrese el numero de la tarea a marcar: ");
                        if (numMarcar == null) {
                            continue;
                        }
                        lista.marcarTarea(numMarcar);
                        break;
                    case 4:
                        salir = true;
                        System.out.println("Saliendo de la consola Lista de Tareas...");
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                }
            } catch (IllegalArgumentException | IllegalStateException | IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void removerTarea(Scanner scanner, ListaTareas lista) {
        boolean hecho = false;
        while (!hecho) {
            System.out.println("Como desea eliminar la tarea?");
            System.out.println("1. Nombre");
            System.out.println("2. Numero en la lista");

            Integer modo = Entrada.leerEntero(scanner);
            if (modo == null) {
                continue;
            }
            try {
                switch (modo) {
                    case 1:
                        String nombre = Entrada.leerTexto(scanner, "Ingrese el nombre: ");
                        lista.eliminarPorNombre(nombre);
                        hecho = true;
                        break;
                    case 2:
                        Integer numero = Entrada.leerEntero(scanner, "Ingrese el numero: ");
                        if (numero == null) {
                            continue;
                        }
                        lista.eliminarPorNumero(numero);
                        hecho = true;
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                }
            } catch (IllegalArgumentException | IllegalStateException | IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
