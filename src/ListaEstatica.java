package src;

/**
 * Implementacion estatica del TDA Lista: array de tamaño fijo + cantidad.
 * Si le pasas algo invalido tira excepcion.
 */
public class ListaEstatica implements ListaTDA {
    private static final int MAX = 100;
    private Object[] elementos;
    private int cant;

    @Override
    public void inicializarLista() {
        elementos = new Object[MAX];
        cant = 0;
    }

    @Override
    public boolean listaVacia() {
        return cant == 0;
    }

    @Override
    public int tamanio() {
        return cant;
    }

    @Override
    public void agregarFinal(Object elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento no puede ser nulo");
        }
        if (cant == MAX) {
            throw new IllegalStateException("La lista esta llena");
        }
        elementos[cant] = elemento;
        cant++;
    }

    @Override
    public void eliminarEn(int posicion) {
        if (listaVacia()) {
            throw new IllegalStateException("La lista esta vacia");
        }
        validarPosicion(posicion);
        for (int i = posicion - 1; i < cant - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[cant - 1] = null;
        cant--;
    }

    @Override
    public Object recuperar(int posicion) {
        if (listaVacia()) {
            throw new IllegalStateException("La lista esta vacia");
        }
        validarPosicion(posicion);
        return elementos[posicion - 1];
    }

    @Override
    public int buscar(Object elemento) {
        if (elemento == null) {
            throw new IllegalArgumentException("El elemento no puede ser nulo");
        }
        for (int i = 0; i < cant; i++) {
            if (elementos[i].equals(elemento)) {
                return i + 1;
            }
        }
        return 0;
    }

    private void validarPosicion(int posicion) {
        if (posicion < 1 || posicion > cant) {
            throw new IndexOutOfBoundsException("Posicion invalida: " + posicion);
        }
    }
}
