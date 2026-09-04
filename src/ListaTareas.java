package src;

/**
 * Lista de tareas usando el TDA Lista estatica.
 */
public class ListaTareas {
    private ListaTDA tareas;

    public ListaTareas() {
        tareas = new ListaEstatica();
        tareas.inicializarLista();
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        tareas.agregarFinal(new Tarea("Estudiar TDA Lista", true));
        tareas.agregarFinal(new Tarea("Entregar TP03"));
        tareas.agregarFinal(new Tarea("Repasar TDA Pila y Cola"));
    }

    public void agregarTarea(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la tarea no puede estar vacio");
        }
        tareas.agregarFinal(new Tarea(nombre.trim()));
    }

    public void eliminarPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la tarea no puede estar vacio");
        }
        int pos = buscarPorNombre(nombre.trim());
        if (pos == 0) {
            throw new IllegalArgumentException("Esa tarea no existe en la lista");
        }
        tareas.eliminarEn(pos);
    }

    public void eliminarPorNumero(int numero) {
        tareas.eliminarEn(numero);
    }

    public void marcarTarea(int numero) {
        Tarea tarea = (Tarea) tareas.recuperar(numero);
        tarea.setCompletada(!tarea.estaCompletada());

        if (tarea.estaCompletada()) {
            System.out.println("Tarea marcada como completada!");
        } else {
            System.out.println("Tarea marcada como no completada!");
        }
    }

    public void mostrarTareas() {
        if (tareas.listaVacia()) {
            System.out.println("No hay tareas cargadas");
        } else {
            System.out.println("--- Lista de Tareas ---");
            for (int i = 1; i <= tareas.tamanio(); i++) {
                System.out.println(i + ". " + tareas.recuperar(i));
            }
        }
        System.out.println("-------------------------------------");
        System.out.println();
    }

    private int buscarPorNombre(String nombre) {
        for (int i = 1; i <= tareas.tamanio(); i++) {
            Tarea t = (Tarea) tareas.recuperar(i);
            if (t.getNombre().equals(nombre)) {
                return i;
            }
        }
        return 0;
    }
}
