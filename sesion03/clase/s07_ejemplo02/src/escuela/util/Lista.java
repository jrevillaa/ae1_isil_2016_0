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

package escuela.util;

import java.util.*;

public class Lista {
	
	protected Vector lista = new Vector(10,10);
	private boolean anterior;			
	private int disponible; 
	
	/*tamanho del 1 al numPagina*/			
	private int numPagina;			
	private boolean siguiente;			
	private int tamPagina;

public void eliminarElemento() {
	try{
		lista.removeElementAt(0);
	}
	catch(Exception e){}
}

public void eliminarElemento(int index) {
	try{
		lista.removeElementAt(index);
	}
	catch(Exception e){}
}



public int getDisponible() {
	return disponible;
}

public void getNextPage(){

	int total;  
	int restantes;
	total =getTamanio();
	if(total> (numPagina+1)*tamPagina){
		numPagina++;
		
		restantes =total-numPagina*tamPagina;
		
		if(restantes>=tamPagina)
			disponible=tamPagina;
		else
			disponible=restantes;

		anterior=(numPagina>0);
		
		if(restantes>tamPagina) 
			siguiente=true;
		else
			siguiente=false;

	}
}

public int getNumPagina() {
	return numPagina;
}

public void getPrevPage(){
	if(numPagina>0){
		numPagina--;
		disponible=tamPagina;
		siguiente=true;
		anterior =(numPagina>0);
	}
}


public int getTamanio() {
	return lista.size();
}
public int getTamPagina() {
	return tamPagina;
}
public void Init(){
	tamPagina=3;
	numPagina=-1;
	getNextPage();


}

public boolean isAnterior() {
	return anterior;
}

public boolean isSiguiente() {
	return siguiente;
}

public void limpiarLista() {
	lista.removeAllElements();	
}

public void setAnterior(boolean newAnterior) {
	anterior = newAnterior;
}

public void setDisponible(int newDisponible) {
	disponible = newDisponible;
}




public void setNumPagina(int newNumPagina) {
	numPagina = newNumPagina;
}


public void setSiguiente(boolean newSiguiente) {
	siguiente = newSiguiente;
}

public void setTamPagina(int newTamPagina) {
	tamPagina = newTamPagina;
}

public boolean existeElemento(Bean elemento) {
	for (int i=0; i<lista.size();i++){
		if (lista.elementAt(i).equals(elemento)) return true;
	}
	return false;
}public Bean getElemento() {
	Bean elemento = null;
	
	try{
		elemento = (Bean)lista.elementAt(0);
	}
	catch(Exception e){
	}
	return elemento;
}public Bean getElemento(int index) {
	Bean elemento = null;
	try{
		elemento = (Bean)lista.elementAt(index+tamPagina*numPagina);
	}
	catch(Exception e){
		System.out.println("getElemento"+e);
	}
	return elemento;
}public void setElemento(Bean elemento) {
	try{
		lista.setElementAt(elemento,lista.size());
	}
	catch(Exception e){
		lista.addElement(elemento);
	}	
}public Bean setElemento(Bean elemento,int index) {
	try{
		lista.setElementAt(elemento,index);
	}
	catch(Exception e){
		lista.addElement(elemento);
	}
	return elemento;
}}