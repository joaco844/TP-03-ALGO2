package src;

/**
 * TDA Lista visto en clase (implementacion estatica con arrays, no ArrayList de Java).
 * Las posiciones son 1-based: el primer elemento esta en la posicion 1.
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
