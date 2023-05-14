package Modelo;

/**
 * <p>
 * La clase {@link modelo.ClientePremium} representa y modela a los clientes
 * premium de la tienda en línea denominada OnlineStore.</p>
 *
 * <p>
 * Esta clase hereda atributos y métodos de la clase abstracta
 * {@link modelo.Cliente}.</p>
 */
public class ClientePremium extends Cliente {

    /**
     * La cuota mensual del cliente premium.
     */
    private Float cuota;

    /**
     * Genera la instancia de un cliente premium de la tienda.
     *
     * @param email El correo electrónico del cliente.
     * @param nif El número de identificación fiscal del cliente.
     * @param nombre El nombre del cliente.
     * @param domicilio El domicilio del cliente.
     * @param cuota La cuota mensual del cliente premium.
     */
    public ClientePremium(String email, String nif, String nombre, String domicilio, Float cuota) {
        super(email, nif, nombre, domicilio);
        this.cuota = cuota;
    }

    /**
     * Calcula la cuota anual de un cliente.
     *
     * @return La cuota anual en euros.
     */
    @Override
    public Float calculoCuotaAnual() {
        return this.cuota * 12;
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
        float x = (float) 0.2;
        Float descuento = x;
        Float cantidadDescontar = gastosEnvio * descuento;
        return gastosEnvio - cantidadDescontar;
    }

    /**
     * Obtiene la cuota mensual del cliente premium.
     *
     * @return La cuota mensual del cliente premium que queremos obtener.
     */
    public Float getCuota() {
        return cuota;
    }

    /**
     * Establece la cuota mensual del cliente premium.
     *
     * @param cuota La cuota mensual del cliente premium que queremos
     * establecer.
     */
    public void setCuota(Float cuota) {
        this.cuota = cuota;
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
        String clientePremium = super.toString()
                + "Es un cliente de tipo premium.\n"
                + "Paga una cuota mensual de "
                + String.valueOf(this.getCuota())
                + " €.\n";
        return clientePremium;
    }
}
