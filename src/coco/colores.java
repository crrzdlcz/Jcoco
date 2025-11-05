package coco;

public class colores 
{
	public static final String RESET = "\033[0m";
	public static final String ROJO = "\033[0;31m";
	public static final String VERDE = "\033[032m";
	public static final String MORADO = "\033[035m";
	public static final String AZUL = "\033[034m";
	public static final String UNDERLINE = "\033[4m";
	public static final String NEGRITAS = "\033[1m";
	
	// COMBINADOS
	public static final String ROJO_NEGRITA = colores.ROJO + colores.NEGRITAS;
	public static final String VERDE_NEGRITA = colores.VERDE + colores.NEGRITAS;
	public static final String AZUL_NEGRITA = colores.AZUL + colores.NEGRITAS;
	public static final String MORADO_NEGRITA = colores.MORADO + colores.NEGRITAS;
	
	public static final String Limpiar_Pantalla = "\033[H\033[2J";
}
