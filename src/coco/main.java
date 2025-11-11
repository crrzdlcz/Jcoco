package coco;
import parser.Gramatica;
import static java.lang.System.out;
import static java.lang.System.err;

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
		
		out.printf(colores.Limpiar_Pantalla);		
		
		out.println(colores.VERDE_NEGRITA
				+ "\n\t  🥥 Coco 🥥"
				+ colores.RESET
				);
		out.println(colores.VERDE_NEGRITA
				+ "  ==========================="
				+ colores.RESET
				);
		
		
		/*try 
		{
			Gramatica.main(args);
		}
		catch (parser.ParseException e)
		{
			err.println(colores.ROJO_NEGRITA + "\n ERROR: " + e.getMessage() + "\n");
		}
		catch (Exception e)
		{
			err.println(colores.MORADO + "  ERROR INESPERADO: " + e.getMessage()
				+ colores.RESET);
		}
		*/
		
		//out.println(colores.Limpiar_Pantalla);
		lexer.main(args);

	}
}
