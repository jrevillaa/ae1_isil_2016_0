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

public class Curso extends Bean {
	
	private String Codigo;
	private String Nombre;
	private int Creditos;
	
	public String getCodigo(){
		return this.Codigo;
	}
	
	public String getNombre(){
		return this.Nombre;
	}

	public int getCreditos(){
		return this.Creditos;
	}

	public void setCodigo(String newCodigo){
		this.Codigo=newCodigo;
	}
	
	public void setNombre(String newNombre){
		this.Nombre=newNombre;
	}

	public void setCreditos(int newCreditos){
		this.Creditos=newCreditos;
	}	
	
}
