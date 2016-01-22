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


public class Profesor {
	
	private String PCodigo;
	private String PNombre;
	private int PCreditos;
	

	public Profesor(String PCodigo,String PNombre,int PCreditos){
		this.PCodigo=PCodigo;
		this.PNombre=PNombre;
		this.PCreditos=PCreditos;
		
	}
	
	public Profesor(){
		this.PCodigo=null;
		this.PNombre=null;
		this.PCreditos=0;
		
	}
	
	
	public String getPCodigo(){
		return this.PCodigo;
	}
	
	public String getPNombre(){
		return this.PNombre;
	}

	public int getPCreditos(){
		return this.PCreditos;
	}

	public void setPCodigo(String PCodigo){
		this.PCodigo=PCodigo;
	}
	
	public void setPNombre(String PNombre){
		this.PNombre=PNombre;
	}

	public void setPCreditos(int PCreditos){
		this.PCreditos=PCreditos;
	}
	
}
