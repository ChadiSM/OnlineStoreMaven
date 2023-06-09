package Modelo;

/**
 * <p>
 * La clase {@link modelo.ClienteEstandar} representa y modela a los clientes
 * estándar de la tienda en línea denominada OnlineStore.</p>
 *
 * <p>
 * Esta clase hereda atributos y métodos de la clase abstracta
 * {@link modelo.Cliente}.</p>
 */
public class ClienteEstandar extends Cliente {

    /**
     * Genera la instancia de un cliente estándar de la tienda.
     *
     * @param email El correo electrónico del cliente.
     * @param nif El número de identificación fiscal del cliente.
     * @param nombre El nombre del cliente.
     * @param domicilio El domicilio del cliente.
     */
    public ClienteEstandar(String email, String nif, String nombre, String domicilio) {
        super(email, nif, nombre, domicilio);
    }

    /**
     * Calcula la cuota anual de un cliente.
     *
     * @return La cuota anual en euros.
     */
    @Override
    public Float calculoCuotaAnual() {
        return Float.valueOf(0);
    }

    /**
     * Aplica el descuento en los gastos de envío.
     *
     * @param gastosEnvio Los gastos de envío de la compra de articulos en la
     * tienda.
     * @return Los gastos de envío en euros con el descuento aplicado.
     */
    @Override
    public Float descuentoGastosEnvio(Float gastosEnvio) {
        return gastosEnvio;
    }

    /**
     * Genera una cadena de carácteres que muestra información relevante sobre
     * el objeto o instancia de la clase.
     *
     * Sobreescribe el método de la clase superior.
     *
     * @return Una cadena de caracteres que representan todos los atributos del
     * objeto de forma clara.
     */
    @Override
    public String toString() {
        String clienteEstandar = super.toString()
                + "Es un cliente de tipo estándar.\n";
        return clienteEstandar;
    }
}
