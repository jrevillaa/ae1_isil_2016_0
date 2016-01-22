/*****************************************************************
 * CJava - Capacitaciones (Derechos Reservados)                  *
 *																 *
 * Curso:     J2EE usando MVC y Tomcat			       			 *
 * Profesor:  Edwin Maraví										 *
 *																 *
 * Version:   1.0  												 *
 * Año:       2005												 *
 *																 *
 * Dirección: Jr. Joaquín Bernal 482 - Lima 14					 *
 * Teléfono:  471-2673 											 *
 *																 *
 *****************************************************************/

package escuela.bean;


public class Administrador {
	private java.lang.String Login;
	private java.lang.String Password;
	private java.lang.String Nombres;
	private java.lang.String Apellidos;
	private java.lang.String Codigo;

public Administrador() {
	super();
}

public java.lang.String getApellidos() {
	return Apellidos;
}

public java.lang.String getCodigo() {
	return Codigo;
}

public java.lang.String getLogin() {
	return Login;
}

public java.lang.String getNombres() {
	return Nombres;
}

public java.lang.String getPassword() {
	return Password;
}

public void setApellidos(java.lang.String newApellidos) {
	Apellidos = newApellidos;
}

public void setCodigo(java.lang.String newCodigo) {
	Codigo = newCodigo;
}

public void setLogin(java.lang.String newLogin) {
	Login = newLogin;
}

public void setNombres(java.lang.String newNombres) {
	Nombres = newNombres;
}

public void setPassword(java.lang.String newPassword) {
	Password = newPassword;
}

}