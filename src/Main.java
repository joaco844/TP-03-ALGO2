package src;

import java.util.Scanner;

/**
 * Menu inicial: elige Playlist o Lista de Tareas.
 * Cada opcion tiene su propio Main. Un error no vuelve aca; solo SALIR de esa consola.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("-------------------------------------");
            System.out.println("Bienvenido a la Consola TP3!");
            System.out.println("Ingrese la accion que quiera realizar:");
            System.out.println("1. Ejercicio Playlist");
            System.out.println("2. Ejercicio Lista Tareas");
            System.out.println("3. SALIR");
            System.out.println("-------------------------------------");

            Integer opcion = Entrada.leerEntero(scanner);
            if (opcion == null) {
                continue;
            }

            switch (opcion) {
                case 1:
                    MainPlaylist.ejecutar(scanner);
                    break;
                case 2:
                    MainTareas.ejecutar(scanner);
                    break;
                case 3:
                    salir = true;
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion Invalida");
            }
        }

        scanner.close();
    }
}
