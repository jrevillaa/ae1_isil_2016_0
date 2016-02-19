package modelo;

public class CarritoItem {

	private Long id;
	private String codigo;
	private String nombre;
	private Double precio;
	private Long cant;
	private Double subtotal;

	public CarritoItem() {
	}

	public Long getCant() {
		return cant;
	}

	public void setCant(Long cant) {
		this.cant = cant;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
}
