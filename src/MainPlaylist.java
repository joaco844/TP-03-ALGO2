package src;

import java.util.Scanner;

/**
 * Consola de la opcion 1: Playlist.
 * Un error no cierra el programa ni vuelve a un menu anterior: se retoma aca.
 */
public class MainPlaylist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ejecutar(scanner);
        scanner.close();
    }

    public static void ejecutar(Scanner scanner) {
        Playlist playlist = new Playlist();
        boolean salir = false;

        System.out.println("Entro a la consola Playlist");

        while (!salir) {
            playlist.mostrarPlaylist();

            System.out.println("que accion quiere realizar?");
            System.out.println("1.AGREGAR CANCION");
            System.out.println("2.REMOVER CANCION");
            System.out.println("3.SIGUIENTE CANCION");
            System.out.println("4.ANTERIOR CANCION");
            System.out.println("5.PAUSAR CANCION");
            System.out.println("6.REPRODUCIR CANCION");
            System.out.println("7.SALIR");

            Integer opcion = Entrada.leerEntero(scanner);
            if (opcion == null) {
                continue;
            }

            try {
                switch (opcion) {
                    case 1:
                        String nombre = Entrada.leerTexto(scanner, "Ingrese el nombre de la cancion: ");
                        playlist.agregarCancion(nombre);
                        break;
                    case 2:
                        removerCancion(scanner, playlist);
                        break;
                    case 3:
                        playlist.siguienteCancion();
                        break;
                    case 4:
                        playlist.anteriorCancion();
                        break;
                    case 5:
                        playlist.pausar();
                        break;
                    case 6:
                        playlist.reproducir();
                        break;
                    case 7:
                        salir = true;
                        System.out.println("Saliendo de la consola Playlist...");
                        break;
                    default:
                        System.out.println("Opcion Invalida");
                }
            } catch (IllegalArgumentException | IllegalStateException | IndexOutOfBoundsException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void removerCancion(Scanner scanner, Playlist playlist) {
        boolean hecho = false;
        while (!hecho) {
            System.out.println("Como desea eliminar la cancion?");
            System.out.println("1. Nombre");
            System.out.println("2. Numero en playlist");

            Integer modo = Entrada.leerEntero(scanner);
            if (modo == null) {
                continue;
            }
            try {
                switch (modo) {
                    case 1:
                        String nombre = Entrada.leerTexto(scanner, "Ingrese el nombre: ");
                        playlist.eliminarPorNombre(nombre);
                        hecho = true;
                        break;
                    case 2:
                        Integer numero = Entrada.leerEntero(scanner, "Ingrese el numero: ");
                        if (numero == null) {
                            continue;
                        }
                        playlist.eliminarPorNumero(numero);
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
