package src;

/**
 * Playlist usando el TDA Lista estatica.
 */
public class Playlist {
    private ListaTDA canciones;
    private boolean reproduciendo;
    private int cancionActual;

    public Playlist() {
        canciones = new ListaEstatica();
        canciones.inicializarLista();
        reproduciendo = false;
        cancionActual = 1;
        cargarDatosIniciales();
    }

    private void cargarDatosIniciales() {
        canciones.agregarFinal("Bohemian Rhapsody");
        canciones.agregarFinal("Hotel California");
        canciones.agregarFinal("Stairway to Heaven");
        canciones.agregarFinal("Come As You Are");
    }

    public void agregarCancion(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la cancion no puede estar vacio");
        }
        canciones.agregarFinal(nombre.trim());
    }

    public void eliminarPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la cancion no puede estar vacio");
        }
        int pos = canciones.buscar(nombre.trim());
        if (pos == 0) {
            throw new IllegalArgumentException("Esa cancion no existe en la playlist");
        }
        eliminarEn(pos);
    }

    public void eliminarPorNumero(int numero) {
        eliminarEn(numero);
    }

    private void eliminarEn(int posicion) {
        canciones.eliminarEn(posicion);
        if (canciones.listaVacia()) {
            cancionActual = 1;
            reproduciendo = false;
            return;
        }
        if (cancionActual > canciones.tamanio()) {
            cancionActual = canciones.tamanio();
        } else if (cancionActual > posicion) {
            cancionActual--;
        }
    }

    public void siguienteCancion() {
        if (canciones.listaVacia()) {
            throw new IllegalStateException("No hay canciones en la playlist");
        }
        if (cancionActual >= canciones.tamanio()) {
            throw new IndexOutOfBoundsException("No hay siguiente cancion");
        }
        cancionActual++;
        reproduciendo = true;
        System.out.println("Ahora estas escuchando: " + canciones.recuperar(cancionActual));
    }

    public void anteriorCancion() {
        if (canciones.listaVacia()) {
            throw new IllegalStateException("No hay canciones en la playlist");
        }
        if (cancionActual <= 1) {
            throw new IndexOutOfBoundsException("No hay cancion anterior");
        }
        cancionActual--;
        reproduciendo = true;
        System.out.println("Ahora estas escuchando: " + canciones.recuperar(cancionActual));
    }

    public void pausar() {
        if (canciones.listaVacia()) {
            throw new IllegalStateException("No hay canciones en la playlist");
        }
        if (!reproduciendo) {
            throw new IllegalStateException("Ya esta pausado");
        }
        reproduciendo = false;
        System.out.println("Pausando cancion!");
    }

    public void reproducir() {
        if (canciones.listaVacia()) {
            throw new IllegalStateException("No hay canciones en la playlist");
        }
        if (reproduciendo) {
            throw new IllegalStateException("Ya se esta reproduciendo");
        }
        reproduciendo = true;
        System.out.println("Reproduciendo cancion!");
    }

    public void mostrarPlaylist() {
        if (canciones.listaVacia()) {
            System.out.println("la playlist actual esta vacia!");
        } else {
            System.out.println("la playlist actual contiene " + canciones.tamanio() + " canciones!");
            System.out.println();
            System.out.println("--- Canciones en la Playlist ---");
            for (int i = 1; i <= canciones.tamanio(); i++) {
                System.out.println(i + ". " + canciones.recuperar(i));
            }
            if (reproduciendo) {
                System.out.println("Se esta reproduciendo " + canciones.recuperar(cancionActual));
            }
        }
        System.out.println("-------------------------------------");
        System.out.println();
    }
}
