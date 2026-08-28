
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
public class ListaTareas {
    ArrayList<Tarea> tareas = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public ListaTareas() {
        tareas.add(new Tarea("Lavar los platos"));
        tareas.add(new Tarea("Estudiar para el parcial"));
        Tarea tareaCompletada = new Tarea("Comprar comida");
        tareaCompletada.setCompletada(true);
        tareas.add(tareaCompletada);
    }
    
    public void agregarTarea(){
        System.out.println("Ingrese el nombre de la tarea: ");
        String nombreTarea = scanner.nextLine();

        if (nombreTarea.isBlank()) {
            throw new IllegalArgumentException("El nombre de la tarea no puede estar vacio");
        }

        tareas.add(new Tarea(nombreTarea));
    }

    public void eliminarTarea(){
        System.out.println("Como desea eliminar la tarea?");
        System.out.println("1. Nombre");
        System.out.println("2. Numero en Lista");

        int userInput = scanner.nextInt();
        scanner.nextLine();
        switch (userInput) {
            case 1:
                System.out.println("Ingrese el nombre: ");
                String nombreTarea = scanner.nextLine();

                Tarea tareaAEliminar = null;
                for (Tarea t : tareas) {
                    if (t.getNombre().equals(nombreTarea)) {
                        tareaAEliminar = t;
                    }
                }

                tareas.remove(tareaAEliminar);
                break;
            case 2: 
                System.out.println("Ingrese el numero: ");
                int numTarea = scanner.nextInt();
                scanner.nextLine();

                tareas.remove(numTarea - 1);
                break;
            default:
                throw new AssertionError();
        }
    }

    public void marcarTarea(){
        System.out.println("Ingrese el numero de la tarea a marcar: ");
        int numTarea = scanner.nextInt();
        scanner.nextLine();

        if (numTarea < 1 || numTarea > tareas.size()) {
            throw new IndexOutOfBoundsException("Numero de tarea fuera de rango");
        }

        Tarea tarea = tareas.get(numTarea - 1);
        tarea.setCompletada(!tarea.estaCompletada());

        if (tarea.estaCompletada()) {
            System.out.println("Tarea marcada como completada!");
        } else {
            System.out.println("Tarea marcada como no completada!");
        }
    }

    public void mostrarTareas(){
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas cargadas");
            return;
        }

        System.out.println("--- Lista de Tareas ---");
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println((i + 1) + ". " + tareas.get(i));
        }
    }

    public ArrayList<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }
}
