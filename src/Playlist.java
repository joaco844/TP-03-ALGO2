/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package src;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author joacodiaz
 */
public class Playlist {
    ArrayList<String> playlist = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Boolean playing = false;
    int cancionActual = 0;

    public void agregarCancion(){
        System.out.println("Ingrese el nombre de la cancion: ");
        String nombreCancion = scanner.nextLine();
        
        playlist.add(nombreCancion);
    }

    public void eliminarCancion(){
        System.out.println("Como desea eliminar la cancion?");
        System.out.println("1. Nombre");
        System.out.println("2. Numero en playlist");

        int userInput;
        try {
            userInput = scanner.nextInt();
            scanner.nextLine();
        } catch (java.util.InputMismatchException e) {
            System.out.println("Entrada invalida.");
            scanner.nextLine();
            return;
        }

        switch (userInput) {
            case 1:
                System.out.println("Ingrese el nombre: ");
                String nombreCancion = scanner.nextLine();
                if (!playlist.remove(nombreCancion)) {
                    System.out.println("Esa cancion no existe en la playlist.");
                }
                break;
            case 2:
                System.out.println("Ingrese el numero: ");
                int numCancion;
                try {
                    numCancion = scanner.nextInt();
                    scanner.nextLine();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada invalida.");
                    scanner.nextLine();
                    return;
                }
                if (numCancion < 1 || numCancion > playlist.size()) {
                    throw new IndexOutOfBoundsException("Numero de cancion fuera de rango");
                }
                playlist.remove(numCancion - 1);
                break;
            default:
                System.out.println("Opcion Invalida");
        }
    }

    public void siguienteCancion(){
        if (playlist.isEmpty()) {
            System.out.println("No hay canciones en la playlist");
            return;
        }
        if (cancionActual >= playlist.size() - 1) {
            throw new IndexOutOfBoundsException("No hay siguiente cancion");
        }
        cancionActual++;
        System.out.println("Ahora estas escuchando: " + playlist.get(cancionActual));
    }

    public void anteriorCancion(){
        if (playlist.isEmpty()) {
            System.out.println("No hay canciones en la playlist");
            return;
        }
        if (cancionActual <= 0) {
            throw new IndexOutOfBoundsException("No hay cancion anterior");
        }
        cancionActual--;
        System.out.println("Ahora estas escuchando: " + playlist.get(cancionActual));
    }

    public void pausar(){
        if(playing){
            System.err.println("Pausando cancion!");
            playing = false;
        }else{
            System.out.println("ya esta pausado.");
        }
    }

    public void reproducir(){
        if(!playing){
            System.err.println("Reproduciendo cancion!");
            playing = true;
        }else{
            System.out.println("ya se esta reproduciendo.");
        }
    }
}   
