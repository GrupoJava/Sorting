import java.util.ArrayList;


/**
 * Clase Sorts que contiene metodos de ordenamiento y como variables el <dim> para saber el tamano del arreglo y <arreglo> que es donde se guardan los numeros
 * @author Andre Rodas
 * @author Delbert Custodio
 * @author Josemite Noe 
 * @author Rudy Garrido
 */
public class Sorts {
	
	private int dim;
	private ArrayList<Integer> arreglo = null;

	/** 
	 * Metodo constructor
	 * @param tamano Es el size del arreglo, se realiza una resta con 1 <dim> ya que los arreglo comienzan en la posicion 0 
	 */
	public Sorts(int tamano) {
		dim = tamano-1;
        arreglo = new ArrayList<Integer>();
	}
	
	/**
	 * Metodo publico para agregar numeros 
	 * @param num es el numero que se quiere agregar al <arreglo>
	 */
	public void agregar(int num){
		arreglo.add(num);
	}
	
	/**
	 * Funcion publica para obtener el valor en cierta posicion del arreglo
	 * @param pos es la posicion donde se quiere obtener
	 * @return numero que contiene el arreglo en la posicion pos
	 */
	public int obtener(int pos){
		return (arreglo.get(pos));
	}
	
	/**
	 * Chequea si no esta vacio y si es mayor a 1 elemento el contenido del arreglo
	 * @return Devuelve verdadero o falso
	 */
	public boolean vacio() {
		if (!arreglo.isEmpty() && arreglo.size()>1)
			return true;
		else
			return false;
	}
	
    /**
     * Intercambia elementos a partir de 2 posiciones en el arreglo
     * @param pos1	posicion 1
     * @param pos2	posicion 2
     */
    public void intercambiar(int pos1, int pos2){
    	int cambio = arreglo.get(pos1);
    	arreglo.set(pos1, arreglo.get(pos2));
    	arreglo.set(pos2, cambio);    	
    }
    
    public void SelectionSort(){
    	for (int i=0;i<=dim-1;i++){
    		int minimo = i;
    		for (int j=i+1;j<=dim;j++){
    			if (arreglo.get(j)<arreglo.get(minimo))
    				minimo=j;
    		}
    	intercambiar(i,minimo);    		
    	}    	
    }
    
    public void QuickSort(){	
    }
    
    public void InsertionSort(){	
    }
    
    public void MergeSort(){	
    }
    
    public void RadixSort(){	
    }

}
