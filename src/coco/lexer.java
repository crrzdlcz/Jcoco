package coco;
import static java.lang.System.out;
import java.awt.DefaultFocusTraversalPolicy;
import static java.lang.System.err;
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
	
	
	private static String getTokenName (int tokenKind, String tokenImage) 
	{
		switch (tokenKind)
		{
		case GramaticaConstants.INICIO:
			return "INICIO";
		case GramaticaConstants.FINAL:
			return "FINAL";
		case GramaticaConstants.ENTERO:
			return "ENTERO";
		case GramaticaConstants.FLOTANTE:
			return "FLOTANTE";
		case GramaticaConstants.BOOLEANO:
			return "BOOLEANO";
		case GramaticaConstants.CHAR:
			return "CHAR";
		case GramaticaConstants.STRING:
			return "STRING";
		case GramaticaConstants.OPERADOR_MENOR_O_IGUAL:
			return "OPERADOR_MENOR_O_IGUAL";
		case GramaticaConstants.OPERADOR_MAYOR_O_IGUAL:
			return "OPERADOR_MAYOR_O_IGUAL";
		case GramaticaConstants.OPERADOR_MENOR_QUE:
			return "OPERADOR_MENOR_QUE";
		case GramaticaConstants.OPERADOR_MAYOR_QUE:
			return "OPERADOR_MAYOR_QUE";
		case GramaticaConstants.OPERADOR_INCREMENTO:
			return "OPERADOR_INCREMENTO";
		case GramaticaConstants.OPERADOR_DECREMENTO:
			return "OPERADOR_DECREMENTO";
		case GramaticaConstants.OPERADOR_SUMA:
			return "OPERADOR_SUMA";
		case GramaticaConstants.OPERADOR_RESTA:
			return "OPERADOR_RESTA";
		case GramaticaConstants.OPERADOR_MULTIPLICACION:
			return "OPERADOR_MULTIPLICACION";
		case GramaticaConstants.OPERADOR_DIVISION:
			return "OPERADOR_DIVISION";
		case GramaticaConstants.OPERADOR_MODULO:
			return "OPERADOR_MODULO";
		case GramaticaConstants.OPERADOR_ASIGNACION:
			return "OPERADOR_ASIGNACION";
		case GramaticaConstants.OPERADOR_AND:
			return "OPERADOR_AND";
		case GramaticaConstants.OPERADOR_OR:
			return "OPERADOR_OR";
		case GramaticaConstants.OPERADOR_NOT:
			return "OPERADOR_NOT";
		case GramaticaConstants.CONDICIONAL_IF:
			return "CONDICIONAL_IF";
		case GramaticaConstants.CONDICIONAL_ELSE:
			return "CONDICIONAL_ELSE";
		case GramaticaConstants.CONDICIONAL_SWITCH:
			return "CONDICIONAL_SWITCH";
		case GramaticaConstants.CASE_CONDICIONAL_SWITCH:
			return "CASE_CONDICIONAL_SWITCH";
		case GramaticaConstants.BLUCLE_FOR:
			return "BLUCLE_FOR";
		case GramaticaConstants.BUCLE_WHILE:
			return "BUCLE_WHILE";
		case GramaticaConstants.PUNTO_Y_COMA:
			return "PUNTO_Y_COMA";
		case GramaticaConstants.DOS_PUNTOS:
			return "DOS_PUNTOS";
		case GramaticaConstants.PARENTSIS_ABRE:
			return "PARENTESIS_ABRE";
		case GramaticaConstants.PARENTESIS_CIERRA:
			return "PARENTESIS_CIERRA";
		case GramaticaConstants.LLAVE_ABRE:
			return "LLAVE_ABRE";
		case GramaticaConstants.LLAVE_CIERRA:
			return "LLAVE_CIERRA";
		case GramaticaConstants.CORCHETE_ABRE:
			return "CORCHETE_ABRE";
		case GramaticaConstants.CORCHETE_CIERRA:
			return "CORCHETE_CIERRA";
		case GramaticaConstants.INICIO_DECLARACION_VARIABLE:
			return "INICIO_DECLARACION_VARIABLE";
		case GramaticaConstants.INICIO_DECLARACION_FUNCION:
			return "INICIO_DECLARACION_FUNCION";
		case GramaticaConstants.SALIDA:
			return "SALIDA";
		case GramaticaConstants.ENTRADA:
			return "ENTRADA";
		case GramaticaConstants.NUMERO_ENTERO:
			return "NUMERO_ENTERO";
		case GramaticaConstants.NUMERO_FLOTANTE:
			return "NUMERO_FLOTANTE";
		case GramaticaConstants.IDENTIFICADOR:
			return "IDENTIFICADOR";
		case GramaticaConstants.CADENA_DE_CARACTERES:
			return "CADENA_DE_CARACTERES";
		default : return("ERROR: Token desconocido (Kind: " + tokenKind + ")");
		}
	}

	public static void main(String[] args)
	{
		
		if (args.length == 0) {
	        err.println(colores.ROJO_NEGRITA + "Error: Falta el archivo a analizar.");
	        err.println("USO CORRECTO: java -jar coco.jar <ruta_al_archivo>");
	        return; // Se sale de coco sin mostrar un error de "nativo" de java
	    }
		
		String ruta = args[0];
		InputStream is = null;
		
		try 
		{
			is = new FileInputStream(ruta);
		} catch (FileNotFoundException e) {
			err.println( colores.ROJO_NEGRITA + "Error: Archivo '" + ruta + "' no encontrado.");
			return;
		}
		try 
		{
			SimpleCharStream stream = new SimpleCharStream(new InputStreamReader(is));
			GramaticaTokenManager tokenManager = new GramaticaTokenManager(stream);
			
			out.println( colores.AZUL_NEGRITA 
					+ "=================== =================== ===================");
			
			Token token;
			
			do 
			{
				try 
				{
					token = tokenManager.getNextToken();
										
					if (token.kind != GramaticaConstants.EOF)
					{
						String tokenKindName = getTokenName (token.kind, token.image);
						
						// String tokenKind = GramaticaConstants.tokenImage[token.kind];
						/*out.println( colores.VERDE_NEGRITA 
								+ "   " + tokenKindName + colores.RESET 
								+ " -> " + "Valor: " + colores.MORADO_NEGRITA + token.image + colores.RESET
								+ " -> " + "Linea: " + colores.UNDERLINE + token.beginLine + colores.RESET 
								+ " -> " + "Columna: " + colores.UNDERLINE + token.beginColumn + colores.RESET );*/
						
						out.println("  " 
								+ colores.MORADO_NEGRITA + token.image + colores.RESET
								+ " -> " + colores.VERDE_NEGRITA + tokenKindName + colores.RESET 
								+ " en " + colores.UNDERLINE + token.beginLine 
								+ ":" + colores.UNDERLINE + token.beginColumn + colores.RESET );
					}
				}
				catch (TokenMgrError e) 
				{					
					out.println( colores.ROJO_NEGRITA 
							+ " *** ERROR LEXICO *** \n" 
							+ e.getMessage()
							+ colores.RESET);
					
					out.println( colores.ROJO_NEGRITA 
							+ "=================== =================== ===================");
					out.println( colores.ROJO_NEGRITA + " --> Analisis lexico terminado con errores <-- ") ;
					return;
				}
			}
			while (token.kind != GramaticaConstants.EOF);
			
			out.println( colores.AZUL_NEGRITA 
					+ "=================== =================== ===================");
			out.println(" Analisis lexico terminado"
					+ colores.VERDE_NEGRITA + "\n NO SE ENCONTRARON ERRORES") ;
			
		}
		finally 
		{
			if (is != null) 
			{
				try 
				{
					is.close();
				} 
				catch (IOException e) 
				{
					err.println("Error al cerrar el archivo: " + e.getMessage());
				}
			}
		}
	}
}
