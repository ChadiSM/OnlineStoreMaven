package Modelo.Comparador;

import java.util.Comparator;
import Modelo.Articulo;

/**
 * <p>
 * La clase {@link modelo.comparador.ComparadorArticuloCodigo} implementa a
 * {@link java.util.Comparator} con el propósito de ordenar y distinguir objetos
 * similares de la clase {@link modelo.Articulo} por su código alfanumérico.</p>
 * <p>
 * En la mayoría de los escenarios de la vida real, queremos ordenar basándonos
 * en distintos parámetros.</p>
 * <p>
 * En esta situación necesitamos usar la interfaz propia del lenguaje Java
 * {@link java.util.Comparator}, porque la implementación del método
 * Comparable.compareTo(Object o) únicamente puede proporcionar una ordenación
 * predeterminada y no podemos cambiarla dinámicamente.</p>
 * <p>
 * Mientras que implementando clases con Comparator, podemos definir múltiples
 * métodos con diferentes formas de ordenación para luego elegir el método que
 * nos convenga.</p>
 */
public class ComparadorArticuloCodigo implements Comparator<Articulo> {

    /**
     * Comparador para ordenar por el código alfanumérico una colección de
     * artículos.
     *
     * @param a1 Primer argumento a comparar.
     * @param a2 Segundo argumento a comparar.
     * @return Retornará un entero negativo, cero o un entero positivo cuando el
     * primer argumento es menor, igual o mayor que el segundo.
     */
    @Override
    public int compare(Articulo a1, Articulo a2) {
        return a1.getCodigo().compareToIgnoreCase(a2.getCodigo());
    }
}
