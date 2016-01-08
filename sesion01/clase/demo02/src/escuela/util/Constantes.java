/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package escuela.util;

import static escuela.util.DBConn.properties;
import java.io.FileInputStream;
import java.util.PropertyResourceBundle;

/**
 *
 * @author Alumno-CT
 */
public class Constantes {
    public static final int STM=1;
    public static final int PST=2;
    public static final int CST=3;
    public static int OPC=0;
    
    static{
	try{
		properties = new PropertyResourceBundle(new FileInputStream("c:/Datos.ini"));
		OPC= Integer.parseInt(properties.getString("opc"));

	}
	catch(Exception e){
		System.out.println("Error:"+e);
	}
	}
}
