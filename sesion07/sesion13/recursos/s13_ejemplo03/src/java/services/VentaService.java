package services;

import database.AccesoDB;
import entity.Articulo;
import entity.Cliente;
import entity.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Carrito;
import modelo.CarritoItem;

public class VentaService {

	public Empleado validarIngreso(String usuario, String clave) throws Exception {
		Empleado emp = null;
		Connection cn = null;
		try {
			String query = "SELECT emp_id, emp_nombre, "
					  + "emp_usuario, emp_clave  "
					  + "FROM empleado "
					  + "WHERE emp_usuario = ?";
			cn = AccesoDB.getConnection();
			PreparedStatement pstm = cn.prepareStatement(query);
			pstm.setString(1, usuario);
			ResultSet rs = pstm.executeQuery();
			if (!rs.next()) {
				throw new Exception("Datos incorrectos.");
			}
			if (!rs.getString("emp_clave").equals(clave)) {
				throw new Exception("Datos incorrectos.");
			}
			emp = new Empleado();
			emp.setId(rs.getLong("emp_id"));
			emp.setNombre(rs.getString("emp_nombre"));
			emp.setUsuario(rs.getString("emp_usuario"));
			emp.setClave(rs.getString("emp_clave"));
			pstm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (SQLException e) {
			}
		}
		return emp;
	}

	public List<Cliente> consultarClientes() throws Exception {
		List<Cliente> lista = new ArrayList<>();
		Connection cn = null;
		try {
			String query = "SELECT cli_id, cli_nombre FROM cliente ";
			cn = AccesoDB.getConnection();
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Cliente o = new Cliente();
				o.setId(rs.getLong("cli_id"));
				o.setNombre(rs.getString("cli_nombre"));
				lista.add(o);
			}
			stm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

	public List<Articulo> consultarArticulos() throws Exception {
		List<Articulo> lista = new ArrayList<>();
		Connection cn = null;
		try {
			String query = "SELECT art_id, art_codigo, art_nombre,"
					  + " art_precio, art_stock FROM articulo ";
			cn = AccesoDB.getConnection();
			Statement stm = cn.createStatement();
			ResultSet rs = stm.executeQuery(query);
			while (rs.next()) {
				Articulo o = new Articulo();
				o.setId(rs.getLong("art_id"));
				o.setCodigo(rs.getString("art_codigo"));
				o.setNombre(rs.getString("art_nombre"));
				o.setPrecio(rs.getDouble("art_precio"));
				o.setStock(rs.getLong("art_stock"));
				lista.add(o);
			}
			stm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;
	}

	public Articulo consultarArticulo(Long idArt) throws Exception {
		Articulo art;
		Connection cn = null;
		try {
			String query = "SELECT art_id, art_codigo, art_nombre,"
					  + " art_precio, art_stock FROM articulo where art_id = ?";
			cn = AccesoDB.getConnection();
			PreparedStatement pstm = cn.prepareStatement(query);
			pstm.setLong(1, idArt);
			ResultSet rs = pstm.executeQuery();
			if (!rs.next()) {
				throw new Exception("Articulo no existe.");
			}
			art = new Articulo();
			art.setId(rs.getLong("art_id"));
			art.setCodigo(rs.getString("art_codigo"));
			art.setNombre(rs.getString("art_nombre"));
			art.setPrecio(rs.getDouble("art_precio"));
			art.setStock(rs.getLong("art_stock"));
			pstm.close();
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return art;
	}

	public void grabarVenta(Carrito carrito) throws Exception{
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			cn.setAutoCommit(false);
			// Grabar la cabecera
			String query = "insert into venta(cli_id,ven_fecha,ven_subtotal,"
					  + "ven_impuesto,ven_total,emp_id) values(?,sysdate(),?,?,?,?)";
			PreparedStatement pstm = cn.prepareStatement(query);
			pstm.setLong(1, carrito.getCliente());
			pstm.setDouble(2, carrito.getImporte() );
			pstm.setDouble(3, carrito.getImpuesto() );
			pstm.setDouble(4, carrito.getTotal() );
			pstm.setLong(5, carrito.getEmpleado());
			pstm.executeUpdate();
			// Obtener el id de venta
			query = "select LAST_INSERT_ID() as id";
			pstm = cn.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			rs.next();
			Long idVenta = rs.getLong("id");
			// Grabar los detalles y actualizar los stocks
			for (CarritoItem i : carrito.getItems()) {
				// Stock
				Articulo a = consultarArticulo(i.getId());
				if( i.getCant() > a.getStock() ){
					throw new Exception("Stock no es sufientes en articulo " + i.getCodigo() + ".");
				}
				query = "update articulo set art_stock = art_stock - ? where art_id = ?";
				pstm = cn.prepareStatement(query);
				pstm.setLong(1, i.getCant());
				pstm.setLong(2, i.getId());
				pstm.executeUpdate();
				// Grabar el detalle
				query = "insert into detalle(ven_id,art_id,det_precio,det_cantidad,"
						  + "det_subtotal) values(?,?,?,?,?)";
				pstm = cn.prepareStatement(query);
				pstm.setLong(1, idVenta);
				pstm.setLong(2, i.getId());
				pstm.setDouble(3, i.getPrecio());
				pstm.setLong(4, i.getCant());
				pstm.setDouble(5, i.getSubtotal());
				pstm.executeUpdate();
			}
			cn.commit();
			pstm.close();
		} catch (Exception e) {
			try {
				cn.rollback();
			} catch (Exception e1) {
			}
			throw e;
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
	}
}
