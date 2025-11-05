package coco;
import static java.lang.System.out;
import static java.lang.System.err;

import parser.Gramatica;
import parser.Gramatica.*;
import parser.GramaticaConstants;
import parser.GramaticaTokenManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import parser.SimpleCharStream;
import parser.Token;
import parser.TokenMgrError;

import java.io.InputStreamReader;

public class lexer 
{
	public static void main(String[] args)
	{
		out.println( colores.AZUL_NEGRITA 
				+ " Tokens Aceptados");
		out.println("===================");
		
		String ruta = args[0];
		InputStream is = null;
		
		
		try {
			is = new FileInputStream(ruta);
		} catch (FileNotFoundException e) {
			err.println("Error: Archivo '" + ruta + "' no encontrado.");
			return;
		}
		
		
		try 
		{
			SimpleCharStream stream = new SimpleCharStream(new InputStreamReader(is));
			GramaticaTokenManager tokenManager = new GramaticaTokenManager(stream);
			
			Token token;
			
			do {
				try {
					token = tokenManager.getNextToken();
					if (token.kind != GramaticaConstants.EOF)
					{
						String tokenKind = GramaticaConstants.tokenImage[token.kind];
						out.println( colores.VERDE_NEGRITA 
								+ "\t" + tokenKind + colores.RESET 
								+ " -> " + "Valor: " + colores.MORADO_NEGRITA + token.image + colores.RESET
								+ " -> " + "Linea: " + colores.UNDERLINE + token.beginLine + colores.RESET 
								+ " -> " + "Columna: " + colores.UNDERLINE + token.beginColumn + colores.RESET );
					}
				}catch (TokenMgrError e) {
					// TODO: handle exception
					
					/*out.println( colores.ROJO_NEGRITA + 
							"Tokens Rechazados");
					out.println("===================" + colores.RESET);
					*/
					
					out.println( colores.ROJO_NEGRITA 
							+ " *** ERROR LEXICO *** \n" 
							+ e.getMessage()
							+ colores.RESET);
					
					out.println( colores.AZUL_NEGRITA + "===================");
					out.println(" Analisis lexico terminado") ;
					return;
				}
			}while (token.kind != GramaticaConstants.EOF);
			
			
			out.println( colores.AZUL_NEGRITA + "===================");
			out.println(" Analisis lexico terminado") ;
			
		}
		finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					err.println("Error al cerrar el archivo: " + e.getMessage());
				}
			}
		}
	}
}
