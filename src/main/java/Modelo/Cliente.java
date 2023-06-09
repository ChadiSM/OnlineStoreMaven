package Modelo;

/**
 * <p>
 * La clase {@link modelo.Cliente} representa y modela a los clientes de la
 * tienda en línea denominada OnlineStore.</p>
 *
 * <p>
 * El correo electrónico del cliente será utilizado como su identificador
 * único.</p>
 *
 * <p>
 * Existen dos tipos de clientes:</p>
 * <p>
 * • Estándar - No paga ninguna cuota.</p>
 * <p>
 * • Premium - Paga una cuota mensual y se le aplica un 20% de descuento en los
 * gastos de envío de cada pedido.</p>
 */
public abstract class Cliente {

    /**
     * El correo electrónico del cliente. Este campo es el identificador único
     * del cliente.
     */
    protected String email;

    /**
     * El número de identificación fiscal del cliente.
     */
    protected String nif;

    /**
     * El nombre del cliente.
     */
    protected String nombre;

    /**
     * El domicilio del cliente.
     */
    protected String domicilio;

    /**
     * Genera la instancia de un cliente de la tienda.
     *
     * @param email El correo electrónico del cliente.
     * @param nif El número de identificación fiscal del cliente.
     * @param nombre El nombre del cliente.
     * @param domicilio El domicilio del cliente.
     */
    public Cliente(String email, String nif, String nombre, String domicilio) {
        this.email = email;
        this.nif = nif;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }

    /**
     * Calcula la cuota anual de un cliente.
     *
     * @return La cuota anual en euros.
     */
    public abstract Float calculoCuotaAnual();

    /**
     * Aplica el descuento en los gastos de envío.
     *
     * @param gastosEnvio Los gastos de envío de la compra de articulos en la
     * tienda.
     * @return Los gastos de envío en euros con el descuento aplicado.
     */
    public abstract Float descuentoGastosEnvio(Float gastosEnvio);

    /**
     * Obtiene el domicilio del cliente.
     *
     * @return El domicilio del cliente que queremos obtener.
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * Establece el domicilio del cliente.
     *
     * @param domicilio El domicilio del cliente que queremos establecer.
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     *
     * @return El correo electrónico del cliente que queremos obtener.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el correo electrónico del cliente.
     *
     * @param email El correo electrónico del cliente que queremos establecer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene el número de identificación fiscal del cliente.
     *
     * @return El número de identificación fiscal del cliente que queremos
     * obtener.
     */
    public String getNif() {
        return nif;
    }

    /**
     * Establece el número de identificación fiscal del cliente.
     *
     * @param nif El número de identificación fiscal del cliente que queremos
     * establecer.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obtiene el nombre del cliente.
     *
     * @return El nombre del cliente que queremos obtener.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cliente.
     *
     * @param nombre El nombre del cliente que queremos establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Genera una cadena de carácteres que muestra información relevante sobre
     * el objeto o instancia de la clase.
     *
     * Sobreescribe el método de: java.lang.Object
     *
     * @return Una cadena de caracteres que representan todos los atributos del
     * objeto de forma clara.
     */
    @Override
    public String toString() {
        String cliente
                = "\nNombre del cliente: " + this.nombre
                + "\nNúmero de Identificación Fiscal: " + this.nif
                + "\nDomicilio: " + this.domicilio
                + "\nCorreo electrónico: " + this.email + "\n";
        return cliente;
    }
}
