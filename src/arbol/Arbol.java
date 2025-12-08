package arbol;
import java.util.ArrayList;
import java.util.List;

/**
 *         _         _           _ 
 *        / \   _ __| |__   ___ | |
 *       / _ \ | '__| '_ \ / _ \| |
 *      / ___ \| |  | |_) | (_) | |  
 *     /_/   \_\_|  |_.__/ \___/|_| Aqui solo se crean los metodos
 *                                 
 */

public class Arbol 
{
	
    String nombre_produccion;
    List<Arbol> hijos = new ArrayList<>();

    public Arbol(String nombre_produccion)
    {
    	this.nombre_produccion = nombre_produccion;
    }
    
    public void agregarHijo(Arbol hijo)
    {
    	if (hijo != null) 
    	{
    		hijos.add(hijo);
    	}
    }
    
    // Métodos getters
    public String getNombreProduccion()
    {
    	return nombre_produccion;
    }
    
    public List<Arbol> getHijos()
    {
    	return hijos;
    }
    
    // Para saber si es una hoja (no tiene hijos) 
    public boolean esHoja() {
        return hijos.isEmpty();
    }
    
    // Para obtener un "mejor string"
    @Override
    public String toString() {
        return nombre_produccion;
    }
    
    
    public void imprimirArbol(int nivel) 
    {
        StringBuilder indentacion = new StringBuilder();
        for (int i = 0; i < nivel; i++) 
        {
            indentacion.append("|  "); 
        }
        System.out.println(indentacion.toString() + "-> " + this.nombre_produccion);

        for (Arbol hijo : hijos) 
        {
            hijo.imprimirArbol(nivel + 1);
        }
    }
    
}






