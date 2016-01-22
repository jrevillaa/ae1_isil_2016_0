package com.inkabank.ib.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDataTime {
    
    public static String fmtFecha(){
        String newstring = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        return newstring;
    }
    
    public static String fmtHora(){
        String newstring = new SimpleDateFormat("HH:mm:ss").format(new Date());
        return newstring;
    }
}
