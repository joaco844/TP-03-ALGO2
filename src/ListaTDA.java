package src;

/**
 * TDA Lista con array (no ArrayList).
 * Las posiciones empiezan en 1.
 */
public interface ListaTDA {
    void inicializarLista();
    boolean listaVacia();
    int tamanio();
    void agregarFinal(Object elemento);
    void eliminarEn(int posicion);
    Object recuperar(int posicion);
    int buscar(Object elemento);
}
