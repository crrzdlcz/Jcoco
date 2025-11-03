package coco;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

/*
 * 	Solo para leer el "código fuente".
 */

public class entrada 
{
	public static InputStream leerCodigoFuente (String Archivo) throws FileNotFoundException 
	{
		return new FileInputStream(Archivo);
	}	
}
