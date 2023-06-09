package Modelo;

import java.io.Serializable;
import java.time.Duration;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
/**
 * <p>
 * La clase {@link modelo.Articulo} representa y modela los artículos a la venta
 * en la tienda en línea denominada OnlineStore.</p>
 *
 * <p>
 * El código alfanumérico del artículo será utilizado como su identificador
 * único.</p>
 *
 * <p>
 * Cada artículo tiene un tiempo de preparación para el envío representado en
 * minutos.</p>
 */
@Entity
@Table(name = "artiuclos")
public class Articulo implements Serializable{

	private static final long serialVersionUID = 1L;
    /**
     * El código alfanumérico del artículo. Este campo es el identificador único
     * del artículo.
     */
	
	@Id
	@Column(name = "Codigo")
	//
	@OneToOne
    private String codigo;

    /**
     * La descripción textual del artículo.
     */
	
	@Column(name = "Descripcion")
	
	
    private String descripcion;

    /**
     * El precio de venta al público del artículo. Es un valor monetario en
     * euros representado con un número decimal.
     */
	
	@Column(name = "PVP")
	
    private Float pvp;

    /**
     * Los gastos de envío del artículo. Es un valor monetario en euros
     * representado con un número decimal.
     */
	
	@Column(name = "GastosEnvio")
	
    private Float gastosEnvio;

    /**
     * El tiempo de preparación del envío del artículo. Es un valor representado
     * en minutos.
     */
	
	@Column(name = "TiempoPreparacionEnvio")
	
    private Duration tiempoPreparacionEnvio;

    /**
     * Genera la instancia de un artículo de la tienda.
     *
     * @param codigo El código alfanumérico del artículo.
     * @param descripcion La descripción textual del artículo.
     * @param pvp El precio de venta al público del artículo.
     * @param gastosEnvio Los gastos de envío del artículo.
     * @param tiempoPreparacionEnvio El tiempo de preparación del envío del
     * artículo.
     */
    public Articulo(String codigo, String descripcion, Float pvp, Float gastosEnvio, Duration tiempoPreparacionEnvio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.gastosEnvio = gastosEnvio;
        this.tiempoPreparacionEnvio = tiempoPreparacionEnvio;
    }

  

	public Articulo(String codigo2, String descripcion2, double d, double e, int i) {
		// TODO Auto-generated constructor stub
	}



	/**
     * Obtiene el código alfanumérico del artículo.
     *
     * @return El código alfanumérico del artículo que queremos obtener.
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Establece el código alfanumérico del artículo.
     *
     * @param codigo El código alfanumérico del artículo que queremos
     * establecer.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Obtiene la descripción textual del artículo.
     *
     * @return La descripción textual del artículo que queremos obtener.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción textual del artículo.
     *
     * @param descripcion La descripción textual del artículo que queremos
     * establecer.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene el precio de venta al público del artículo.
     *
     * @return El precio de venta al público del artículo que queremos obtener.
     */
    public Float getPvp() {
        return pvp;
    }

    /**
     * Establece el precio de venta al público del artículo.
     *
     * @param pvp El precio de venta al público del artículo que queremos
     * establecer.
     */
    public void setPvp(Float pvp) {
        this.pvp = pvp;
    }

    /**
     * Obtiene los gastos de envío del artículo.
     *
     * @return Los gastos de envío del artículo que queremos obtener.
     */
    public Float getGastosEnvio() {
        return gastosEnvio;
    }

    /**
     * Establece los gastos de envío del artículo.
     *
     * @param gastosEnvio Los gastos de envío del artículo que queremos
     * establecer.
     */
    public void setGastosEnvio(Float gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    /**
     * Obtiene el tiempo de preparación del envío del artículo.
     *
     * @return El tiempo de preparación del envío del artículo que queremos
     * obetener.
     */
    public Duration getTiempoPreparacionEnvio() {
        return tiempoPreparacionEnvio;
    }

    /**
     * Establece el tiempo de preparación del envío del artículo.
     *
     * @param tiempoPreparacionEnvio El tiempo de preparación del envío del
     * artículo que queremos establecer.
     */
    public void setTiempoPreparacionEnvio(Duration tiempoPreparacionEnvio) {
        this.tiempoPreparacionEnvio = tiempoPreparacionEnvio;
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
        String articulo = "\nArtículo "
                + this.codigo
                + "\nDescripción del artículo: "
                + this.descripcion
                + "\nPrecio de Venta al Público (PVP) del artículo: "
                + String.format("%.2f", this.pvp)
                + "€"
                + "\nLos gastos de envío del artículo: "
                + String.format("%.2f", this.gastosEnvio)
                + "€"
                + "\nEl tiempo de preparación del envío del artículo: "
                + String.valueOf(this.tiempoPreparacionEnvio.toMinutes())
                + " minutos.\n";
        return articulo;
    }
}
