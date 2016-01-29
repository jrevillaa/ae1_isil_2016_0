package ae1.util;

import static ae1.util.DBConn.properties;
import java.io.FileInputStream;
import java.util.PropertyResourceBundle;


public class Constantes {
    public static final int PST=1;
    public static final int CTM=2;
    public static int OPC=1;
    
    
    static{
	try{
		properties = new PropertyResourceBundle(new FileInputStream("c:/Datos.ini"));
                //properties = new PropertyResourceBundle(new FileInputStream("/home/jair/Documentos/isil/ae1_isil_2016_0/sesion01/recursos/scripts/Datos.ini"));
		OPC= Integer.parseInt(properties.getString("OPC"));

	}
	catch(Exception e){
		System.out.println("Error:"+e);
	}
	}
    
}
