package coco;
import parser.Gramatica;
import static java.lang.System.out;
import static java.lang.System.err;
import parser.TokenMgrError;
import arbol.Arbol;
import java.io.*;

public class main
{
	public static void main(String[] args)
	{

		/**
		 *      ___ ___   ___ ___
		 *     / __/ _ \ / __/ _ \
		 *    | (_| (_) | (_| (_) |
		 *     \___\___/ \___\___/
		 *
		 */
		
		/*out.printf(colores.Limpiar_Pantalla);		
		
		out.println(colores.VERDE_NEGRITA
				+ "\n\t  🥥 Coco 🥥"
				+ colores.RESET
				);
		out.println(colores.VERDE_NEGRITA
				+ "  ==========================="
				+ colores.RESET
				);
		*/
		
        try {
          //  Gramatica.main(args); 
            
    	/*	out.printf(colores.Limpiar_Pantalla);		
    		
    		out.println(colores.VERDE_NEGRITA
    				+ "\n\t  🥥 Coco 🥥"
    				+ colores.RESET
    				);
    		out.println(colores.VERDE_NEGRITA
    				+ "  ==========================="
    				+ colores.RESET
    				); */
    		
        	out.printf(colores.Limpiar_Pantalla);		
    		
    		out.println(colores.VERDE_NEGRITA
    				+ "\n\t  🥥 Coco 🥥"
    				+ colores.RESET
    				);
    		out.println(colores.VERDE_NEGRITA
    				+ "  ==========================="
    				+ colores.RESET
    				);
        
    		
    		//Gramatica.main(args); 
    		
            if (args.length == 0) {
                err.println("ERROR: Se requiere la ruta del archivo fuente...");
                System.exit(1);
            }
            
            out.print(colores.VERDE_NEGRITA + " --> Análisis terminado exitosamente <-- ");
            out.println(colores.RESET);
            
            String rutaArchivo = args[0];
            
            InputStream is = entrada.leerCodigoFuente(rutaArchivo);
            Gramatica parser = new Gramatica(is);

            Arbol arbol = parser.Coco();
            is.close();
            
            coco.Tabla tablaDeSimbolos = Gramatica.getTabla();
            String rutaSalidaTabla = rutaArchivo + ".simbolos.txt";
            guardarTablaEnArchivo(tablaDeSimbolos, rutaSalidaTabla);
            
            
            if (arbol != null) {
            	String rutaSalida = rutaArchivo + ".arbol.txt";
                guardarArbolEnArchivo(arbol, rutaSalida);
            }
            
            //out.println(colores.RESET);
    		
    		
    		
        }
        
            
        catch (TokenMgrError e) { // Errores Léxicos
        	
    		out.printf(colores.Limpiar_Pantalla);		
    		
    		out.println(colores.ROJO_NEGRITA
    				+ "\n\t  🥥 Coco 🥥"
    				+ colores.RESET
    				);
    		out.println(colores.ROJO_NEGRITA
    				+ "  ==========================="
    				+ colores.RESET
    				);
        	
            // Para formatear el mensaje...
            String mensaje = e.getMessage();
            String[] lineas = mensaje.split("\n");
            
            err.println(colores.ROJO_NEGRITA + "\n *** ERROR LEXICO ***");
            err.println(" " + lineas[0].trim());  // La linea y la columna
            err.println(" " + lineas[1].trim());  // Lo que se encontro
            err.println(colores.RESET);
            err.println(colores.ROJO_NEGRITA + "========================================");
            err.println(" --> Análisis terminado con errores <-- ");
            err.println(colores.RESET);
        }
        catch (parser.ParseException e) {
        	
    		out.printf(colores.Limpiar_Pantalla);		
    		
    		out.println(colores.MORADO_NEGRITA
    				+ "\n\t  🥥 Coco 🥥"
    				+ colores.RESET
    				);
    		out.println(colores.MORADO_NEGRITA
    				+ "  ==========================="
    				+ colores.RESET
    				);
    		err.println(colores.MORADO_NEGRITA + "\n *** ERROR SINTÁCTICO ***");
            err.println(colores.MORADO_NEGRITA + "Error sintáctico: " + e.getMessage() + "\n" + colores.RESET);
            err.println(colores.MORADO_NEGRITA + "========================================");
            err.println(" --> Análisis terminado con errores <-- ");
            err.println(colores.RESET);
        }
        catch (Exception e) {
        	
    		out.printf(colores.Limpiar_Pantalla);		
    		
    		out.println(colores.AZUL_NEGRITA	
    				+ "\n\t  🥥 Coco 🥥"
    				+ colores.RESET
    				);
    		out.println(colores.AZUL_NEGRITA
    				+ "  ==========================="
    				+ colores.RESET
    				);
        	
            err.println(colores.AZUL_NEGRITA + "  ERROR INESPERADO: " + e.getMessage() + colores.RESET);
        }
		
		// Esto se queda por si acaso xd
		//out.println(colores.Limpiar_Pantalla);
		//lexer.main(args);
        
        
        

	}
	
	
	private static void guardarArbolEnArchivo(Arbol arbol, String rutaSalida) {
        if (arbol == null) return;
        
        java.io.PrintStream consolaOriginal = System.out;
        try {

        	System.setOut(new java.io.PrintStream(rutaSalida));
            
            arbol.imprimirArbol(0);

            System.out.flush();
            System.setOut(consolaOriginal);
            
            out.println(colores.VERDE_NEGRITA + "Árbol guardado en: " + rutaSalida + colores.RESET);
            
        } catch (FileNotFoundException e) {
            System.setOut(consolaOriginal);
            err.println(colores.ROJO_NEGRITA + "Error al crear archivo: " + e.getMessage() + colores.RESET);
        } catch (Exception e) {
            System.setOut(consolaOriginal);
            throw e;
        }
    }
	
	
	
private static void guardarTablaEnArchivo(coco.Tabla tabla, String rutaSalida) {
        
        java.io.PrintStream consolaOriginal = System.out;
        try {
        	
            java.io.PrintStream archivoSalida = new java.io.PrintStream(rutaSalida);
            
            tabla.imprimirTabla(archivoSalida);
            
            archivoSalida.close();
            
            System.setOut(consolaOriginal);
            
            out.println(colores.VERDE_NEGRITA + "Tabla de Símbolos guardada en: " + rutaSalida + colores.RESET);
            
        } catch (FileNotFoundException e) {
            System.setOut(consolaOriginal); 
            err.println(colores.ROJO_NEGRITA + "Error al crear archivo de símbolos: " + e.getMessage() + colores.RESET);
        } catch (Exception e) {
            System.setOut(consolaOriginal); 
            throw e;
        }
    }

}

