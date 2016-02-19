package jsf;

import entity.Articulo;
import entity.Cliente;
import entity.Empleado;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import modelo.Carrito;
import modelo.CarritoItem;
import services.VentaService;

@ManagedBean
@SessionScoped
public class VentaBean implements Serializable {

	// Empleado
	private Empleado empleado = null;
	private String usuario = "";
	private String clave = "";
	private String mensaje = "";
	// Venta
	private Long idcliente;
	private Long idArticulo;
	private Double precio = 0.0;
	private Long cant = 1L;
	private Double subtotal = 0.0;
	private List<SelectItem> listaClientes = null;
	private List<SelectItem> listaArticulos = null;
	private Carrito carrito = new Carrito();

	public VentaBean() {
	}

	public Carrito getCarrito() {
		return carrito;
	}



	public Double getSubtotal() {
		return subtotal;
	}


	public Long getCant() {
		return cant;
	}

	public void setCant(Long cant) {
		this.cant = cant;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Long getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	public Long getIdArticulo() {
		return idArticulo;
	}

	public void setIdArticulo(Long idArticulo) {
		this.idArticulo = idArticulo;
	}

	public List<SelectItem> getListaArticulos() {
		if (listaArticulos == null) {
			try {
				listaArticulos = new ArrayList<SelectItem>();
				VentaService srv = new VentaService();
				List<Articulo> lista = srv.consultarArticulos();
				listaArticulos.add(new SelectItem(0, "Seleccione un articulo"));
				for (Articulo o : lista) {
					SelectItem op = new SelectItem();
					op.setValue(o.getId());
					op.setLabel(o.getNombre());
					listaArticulos.add(op);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaArticulos;
	}

	public List<SelectItem> getListaClientes() {
		if (listaClientes == null) {
			try {
				listaClientes = new ArrayList<SelectItem>();
				VentaService srv = new VentaService();
				List<Cliente> lista = srv.consultarClientes();
				for (Cliente c : lista) {
					SelectItem op = new SelectItem();
					op.setValue(c.getId());
					op.setLabel(c.getNombre());
					listaClientes.add(op);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaClientes;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String doIngresar() {
		String destino = "ventas";
		mensaje = "";
		try {
			VentaService srv = new VentaService();
			empleado = srv.validarIngreso(usuario, clave);
		} catch (Exception e) {
			mensaje = e.getMessage();
			destino = "index";
		}
		return destino;
	}

	public String doSalir() {
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		req.getSession(true).invalidate();
		return "index";
	}

	public void modificarPrecio(ValueChangeEvent event) {
		try {
			Long idArt = (Long) event.getNewValue();
			VentaService srv = new VentaService();
			Articulo a = srv.consultarArticulo(idArt);
			precio = a.getPrecio();
			subtotal = precio * cant;
		} catch (Exception e) {
			precio = 0.0;
		}
	}

	public void modificarCantidad(ValueChangeEvent event) {
		try {
			Long c = (Long) event.getNewValue();
			subtotal = precio * c;
		} catch (Exception e) {
			precio = 0.0;
		}
	}

	public String doAgregarItem(){
		try {
			VentaService srv = new VentaService();
			Articulo a = srv.consultarArticulo(idArticulo);
			CarritoItem item = new CarritoItem();
			item.setId(a.getId());
			item.setCodigo(a.getCodigo());
			item.setNombre(a.getNombre());
			item.setPrecio(a.getPrecio());
			item.setCant(cant);
			item.setSubtotal(item.getPrecio() * item.getCant());
			carrito.add(item);
		} catch (Exception e) {
		}
		return "ventas";
	}

	public String doEliminarItem( Long id ) {
		carrito.remove(id);
		return "ventas";
	}

	public String doGrabar(){
		mensaje = "";
		try {
			carrito.setCliente(idcliente);
			carrito.setEmpleado(empleado.getId());
			VentaService srv = new VentaService();
			srv.grabarVenta(carrito);
			carrito.clear();
			mensaje = "Proceso ok.";
		} catch (Exception e) {
			mensaje = e.getMessage();
			e.printStackTrace();
		}
		return "ventas";
	}

}
