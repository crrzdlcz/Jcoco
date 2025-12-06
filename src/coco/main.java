package coco;
import parser.Gramatica;
import static java.lang.System.out;
import static java.lang.System.err;
import parser.TokenMgrError;

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
            Gramatica.main(args);
            
    		out.printf(colores.Limpiar_Pantalla);		
    		
    		out.println(colores.VERDE_NEGRITA
    				+ "\n\t  🥥 Coco 🥥"
    				+ colores.RESET
    				);
    		out.println(colores.VERDE_NEGRITA
    				+ "  ==========================="
    				+ colores.RESET
    				);
    		out.println(colores.VERDE_NEGRITA + " --> Análisis terminado exitosamente <-- ");
            out.println(colores.RESET);
    		
        }
        catch (TokenMgrError e) { 
        	
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
}
