/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package src;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author joacodiaz
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.println("Bienvenido a la Consola TP3!");
        System.out.println("Ingrese la accion que quiera realizar: ");
        System.out.println("1. Ejercicio Playlist");
        System.out.println("2. Ejercicio Lista Tareas");
        System.out.println("-------------------------------------");

        int userInput = -1;
        try {
            userInput = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Entrada invalida. Debe ingresar un numero.");
            scanner.nextLine();
            return;
        }

        switch (userInput) {
            case 1:
                System.out.println("Entro a la consola Playlist");
                Playlist myPlaylist = new Playlist();
                boolean salirPlaylist = false;

                while (!salirPlaylist) {
                    if (myPlaylist.playlist.isEmpty()) {
                        System.out.println("la playlist actual esta vacia!");
                    } else {
                        System.out.println("la playlist actual contiene " + myPlaylist.playlist.size() + " canciones!");
                        if (myPlaylist.playing) {
                            System.err.println("Se esta reproduciendo "+ myPlaylist.playlist.get(myPlaylist.cancionActual));
                        }
                    }

                    System.out.println("que accion quiere realizar?");
                    System.out.println("1.AGREGAR CANCION");
                    System.out.println("2.REMOVER CANCION");
                    System.out.println("3.SIGUIENTE CANCION");
                    System.out.println("4.ANTERIOR CANCION");
                    System.out.println("5.PAUSAR CANCION");
                    System.out.println("6.REPRODUCIR CANCION");
                    System.out.println("7.SALIR");

                    int opcion;
                    try {
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida. Debe ingresar un numero.");
                        scanner.nextLine();
                        continue;
                    }

                    try {
                        switch (opcion) {
                            case 1:
                                myPlaylist.agregarCancion();
                                break;
                            case 2:
                                myPlaylist.eliminarCancion();
                                break;
                            case 3:
                                myPlaylist.siguienteCancion();
                                break;
                            case 4:
                                myPlaylist.anteriorCancion();
                                break;
                            case 5:
                                myPlaylist.pausar();
                                break;
                            case 6:
                                myPlaylist.reproducir();
                                break;
                            case 7:
                                salirPlaylist = true;
                                System.out.println("Saliendo de la consola Playlist...");
                                break;
                            default:
                                System.out.println("Opcion Invalida");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: esa cancion no existe en la playlist.");
                    } catch (Exception e) {
                        System.out.println("Ocurrio un error inesperado: "+e);
                    }
                }
                break;
            case 2:
                System.out.println("Entro a la consola Lista de Tareas");
                ListaTareas misTareas = new ListaTareas();
                boolean salirTareas = false;

                while (!salirTareas) {
                    misTareas.mostrarTareas();

                    System.out.println("que accion quiere realizar?");
                    System.out.println("1.AGREGAR TAREA");
                    System.out.println("2.REMOVER TAREA");
                    System.out.println("3.MARCAR/DESMARCAR TAREA");
                    System.out.println("4.SALIR");

                    int opcion;
                    try {
                        opcion = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada invalida. Debe ingresar un numero.");
                        scanner.nextLine();
                        continue;
                    }

                    try {
                        switch (opcion) {
                            case 1:
                                misTareas.agregarTarea();
                                break;
                            case 2:
                                misTareas.eliminarTarea();
                                break;
                            case 3:
                                misTareas.marcarTarea();
                                break;
                            case 4:
                                salirTareas = true;
                                System.out.println("Saliendo de la consola Lista de Tareas...");
                                break;
                            default:
                                System.out.println("Opcion Invalida");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: esa tarea no existe en la lista.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (Exception e) {
                        System.out.println("Ocurrio un error inesperado: " + e.getMessage());
                    }
                }
                break;
            default:
                System.out.println("Opcion Invalida");
        }

        scanner.close();
    }
}