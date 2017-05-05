
package constantes;

import java.io.File;


public class Constantes {
    
    static File miDir = new File("");
    //String dir=miDir.getAbsolutePath()+"\\build\\web\\foto";
    static final String RUTA_IMG=miDir.getAbsolutePath()+"\\build\\web\\foto";
    static final String DIR=miDir.getAbsolutePath()+"\\web\\foto";

    public static String getRUTA_IMG() {
        return RUTA_IMG;
    }

    public static String getDIR() {
        return DIR;
    }
    
    
    
}
