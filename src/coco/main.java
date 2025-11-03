package coco;
import parser.Gramatica;
import static java.lang.System.out;
import static java.lang.System.err;

public class main
{
	public static void main(String[] args)
	{

		/**
		 *
		 *      ___ ___   ___ ___
		 *     / __/ _ \ / __/ _ \
		 *    | (_| (_) | (_| (_) |
		 *     \___\___/ \___\___/
		 *
		 *
		 */

		out.println(colores.VERDE_NEGRITA
				+ "\n\t  🥥 Coco 🥥"
				+ colores.RESET);
		out.println(colores.VERDE_NEGRITA
				+ "  ==========================="
				+ colores.RESET);
		
		try 
		{
			Gramatica.main(args);
		}
		catch (parser.ParseException e)
		{
			err.println(colores.ROJO_NEGRITA + "Error: " + e.getMessage());
		}
		catch (Exception e)
		{
			err.println(colores.MORADO + "Error general: " + e.getMessage()
				+ colores.RESET);
		}

	}
}