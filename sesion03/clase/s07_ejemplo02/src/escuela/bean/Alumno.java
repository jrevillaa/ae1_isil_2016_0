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

import escuela.util.*;

public class Alumno extends Bean {
	private String Codigo;
	private String Nombres;

	private String Apellidos;
	private String FechaNac;
	private String Sexo;

public Alumno() {
	super();
}


public String getApellidos() {
	return Apellidos;
}


public String getCodigo() {
	return Codigo;
}

public String getFechaNac() {
	return FechaNac;
}

public String getNombres() {
	return Nombres;
}



public void setApellidos(java.lang.String newApellidos) {
	Apellidos = newApellidos;
}

public void setCodigo(java.lang.String newCodigo) {
	Codigo = newCodigo;
}

public void setFechaNac(java.lang.String newFechaNac) {
	FechaNac = newFechaNac;
}

public void setNombres(java.lang.String newNombres) {
	Nombres = newNombres;
}


public String getSexo() {
	return Sexo;
}public void setSexo(String newSexo) {
	Sexo = newSexo;
}}