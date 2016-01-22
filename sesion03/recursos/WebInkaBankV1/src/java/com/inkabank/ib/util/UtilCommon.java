package com.inkabank.ib.util;

public class UtilCommon {
    public static String getNroOperacion(){
        return 99999+(int)(Math.random()*((99999-1))+1)+"";
    }    
}
