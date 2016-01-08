package ventas.util;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

public class QueryTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Vector cache; // Contendr� objetos String[] 
	int colCount;
	String[] headers;
	Connection con;
	Statement st;
	String currentURL;

	public QueryTableModel() {
		cache = new Vector();
		initDB();// crea la conexion necesaria
	}

//	t�tulo de columna
	public String getColumnName(int i) {
		return headers[i];
	} 
// Cu�ntas columnas
	public int getColumnCount() {
		return colCount;
	}
//	Cu�ntas filas
	public int getRowCount() {
		return cache.size();
	} 
//	cadena en fila, columna. Inicia en (0,0)
	public Object getValueAt(
		int row,
		int col) 
	{
		return ((String[]) cache.elementAt(row))[col];
	}

	// Llenado de la tabla con la consulta
	public void setQuery(String q) {
		cache = new Vector();
		try {
			st= con.createStatement();
			ResultSet rs = st.executeQuery(q);
			ResultSetMetaData meta = rs.getMetaData();
			colCount = meta.getColumnCount();

			// Poniendo nombres de columnas
			headers = new String[colCount];
			for (int h = 1; h <= colCount; h++) {
				headers[h - 1] = meta.getColumnName(h);
			}

			while (rs.next()) { //para cargar los datos
				String[] record = new String[colCount];

				for (int i = 0; i < colCount; i++)
					record[i] = rs.getString(i + 1);

				cache.addElement(record);
			}
			fireTableChanged(null); // notifica que tenemos una nueva tabla
			
		} catch (Exception e) {
			cache = new Vector(); // blanquea el vector.
			e.printStackTrace();
		}
	}

	public void initDB() {
		try {
			con = DBConn.getConnection();
		} catch (Exception e) {
			System.out.println("No puede inicializar la base de datos.");
		}
	}

	public void closeDB() {
		try {
			if (st != null) {
				st.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println("No puede cerrar la actual conexi�n.");
		}
	}
}
/* Si deseas llevar el curso completo escribe a cursos@cjavaperu.com*/