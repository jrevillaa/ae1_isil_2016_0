/*****************************************************************
 * CJava - Capacitaciones (Derechos Reservados)                  *
 *																 *
 * Curso:     J2EE usando MVC y Tomcat			       			 *
 * Profesor:  Edwin Marav�										 *
 *																 *
 * Version:   1.0  												 *
 * A�o:       2005												 *
 *																 *
 * Direcci�n: Jr. Joaqu�n Bernal 482 - Lima 14					 *
 * Tel�fono:  471-2673 											 *
 *																 *
 *****************************************************************/

package escuela.util;

public abstract class Bean  implements java.io.Serializable{

public String getReferencia() {
	return getClass().getName();
}

}