package src;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Lectura de consola. Si el input no es un numero, avisa y no corta el programa.
 */
public class Entrada {
    public static Integer leerEntero(Scanner scanner) {
        try {
            int valor = scanner.nextInt();
            scanner.nextLine();
            return valor;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Entrada invalida. Debe ingresar un numero.");
            return null;
        }
    }

    public static Integer leerEntero(Scanner scanner, String mensaje) {
        System.out.println(mensaje);
        return leerEntero(scanner);
    }

    public static String leerTexto(Scanner scanner, String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }
}
