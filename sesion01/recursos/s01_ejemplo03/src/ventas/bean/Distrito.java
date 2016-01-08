package ventas.bean;


public class Distrito {
	
	private String codigo = null;
	private String nombre = null;
	private String vendedor = null;
	
	public Distrito() {
		this.codigo = null;
		this.nombre = null;
		this.vendedor = null;
	}	
	
	public Distrito(String codigo, String nombre, String vendedor) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.vendedor = vendedor;
	}	
	
	public void setCodigo(String codigo){
		this.codigo = codigo;	
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;	
	}
	
	public void setVendedor(String vendedor){
		this.vendedor = vendedor;	
	}
	
	public String getCodigo(){
		return codigo;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getVendedor(){
		return vendedor;
	}
}
