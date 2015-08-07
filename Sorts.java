import java.util.ArrayList;


/**
 * Clase Sorts que contiene metodos de ordenamiento y como variables el <dim> para saber el tamano del arreglo y <arreglo> que es donde se guardan los numeros
 * @author Andre Rodas
 * @author Delbert Custodio
 * @author Yosemite Melendez 
 * @author Rudy Garrido
 */
public class Sorts {
	
	private int dim;
	private ArrayList<Comparacion> arreglo = null;
	private int aux;
	private int tamano;
	/** 
	 * Metodo constructor
	 * @param tamano Es el size del arreglo, se realiza una resta con 1 <dim> ya que los arreglo comienzan en la posicion 0 
	 */
	public Sorts(int tamano) {
		dim = tamano-1;
        arreglo = new ArrayList<Comparacion>();
	}
	
	/**
	 * Metodo publico para agregar numeros 
	 * @param num es el numero que se quiere agregar al <arreglo>
	 */
	public void agregar(int num){
		arreglo.add(new Comparacion(num));
	}
	
	/**
	 * Funcion publica para obtener el valor en cierta posicion del arreglo
	 * @param pos es la posicion donde se quiere obtener
	 * @return numero que contiene el arreglo en la posicion pos
	 */
	public int obtener(int pos){
		return (arreglo.get(pos).getValor());
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
    	Comparacion cambio = arreglo.get(pos1);
    	arreglo.set(pos1, arreglo.get(pos2));
    	arreglo.set(pos2, cambio);    	
    }
    
    public void SelectionSort(){
    	for (int i=0;i<=dim-1;i++){
    		int minimo = i;
    		for (int j=i+1;j<=dim;j++){
    			if (arreglo.get(j).compareTo(arreglo.get(minimo))==1) /* < igual 1 en comparacion*/
    				minimo=j;
    		}
    	intercambiar(i,minimo);    		
    	}    	
    }
    
    
    public void InsertionSort(){	
    	for(int posicion =0; posicion < arreglo.size(); posicion++){
			int numeroTemporal= arreglo.get(posicion).getValor();
			int posicionPosible=posicion;
			while(posicionPosible>0 && arreglo.get(posicionPosible-1).compareTo(new Comparacion(numeroTemporal)) ==1 ){
				arreglo.set(posicionPosible, arreglo.get(posicionPosible-1));
				posicionPosible--;
			}
			arreglo.set(posicionPosible, new  Comparacion(numeroTemporal));
		}
    }
    
    @SuppressWarnings("unused")
   	public  ArrayList<Comparacion> MergeSort(ArrayList<Comparacion> P){
       	
    	
    	//Se crean estos vectores de tipo ArrayList para poder llevar a cabo la recursion
       	ArrayList<Comparacion> v = new ArrayList<Comparacion>();
       	ArrayList<Comparacion> v2 = new ArrayList<Comparacion>();
       	ArrayList<Comparacion> v3 = new ArrayList<Comparacion>();
       	int i;
       
       	//Si el vector que se ordena slo tiene un elemento, se devuelve el mismo; caso trivial
       	if (P.size() == 1){
       		return P;
       	}
       	
       	//Se copia hasta la mitad el vector
       	for (i=0; i<P.size()/2; i++){
       		v2.add(P.get(i));
       	}
       	//Se copia de la mitad en adelante del vector
       	for (i=P.size()/2; i<P.size(); i++){
       		v3.add(P.get(i));
       	}
       		//Recursion; sirve para separar los vectores hasta llegar al caso trivial
       		v2 = MergeSort(v2);
       		v3 = MergeSort(v3);
           
       		//Intercambio de los vectores ya ordenados
           	int cont1 = 0;
           	int cont2 = 0;
           	i = v2.size()+v3.size();//Contador de elementos a ordenar
           	while (i>0){
           		//Si se llega al tope de un vector, solo se agregan los elementos
           		//ya ordenados del otro vector
           		if (cont2 == v3.size()){
           			v.add( v2.get(cont1) );
           			cont1++;
           			i--;
           		}
           		else
           			if (cont1 == v2.size()){
           				v.add(v3.get(cont2));
           				cont2++;
           				i--;
           			}
           			else //Intercambio
           				if ((v2.get(cont1).getValor()) < (v3.get(cont2).getValor()) ){
           						v.add(v2.get(cont1));
           						cont1++;
           						i--;
           				}
           				else{
           					v.add(v3.get(cont2));
           					cont2++;
           					i--;
           				}
           	}
           	return v; //Se devuelve el vector
       }
    
	public void QuickSort (int primero, int ultimo){
	
		int p = primero;	//Para realizar el recorrido del primer al ultimo elemento
		int u = ultimo;		//Para realizar el recorrido del utlimo al primer elemento
		// Se coloca el pivote como el numero de en medio
		int pivote = arreglo.get((primero+ultimo)/2).getValor(); 	
		
		//Estas instruccinoes ayudan a dividir el arreglo
		while (p <= u){
			/*
			Se verificaran los numeros a la izquierda del pivote que sean mayores que el 
			y los numero a la derecha del pivote que sean menores a el. Cuando se identifiquen
			se hará un intercambio de valores
			*/
			while (arreglo.get(p).getValor() < pivote){p++;}	//Busca elementos mayores al pivote
			while (arreglo.get(u).getValor() > pivote){u--;}	//Busca elementos menores al pivote
			
			//Se realiza el intercambio de numeros utilizando una variable auxiliar
			if (p <= u){
				aux = arreglo.get(p).getValor();
				arreglo.set(p, arreglo.get(u));
				arreglo.set(u, new Comparacion(aux));
				arreglo.set(u, new Comparacion(aux));
					
				//Mueve a la siguiente posicion
				p++;
				u--;
			}
		//Vuelve a llamar quick
		if (primero < u){QuickSort (primero, u);}
		if (p < ultimo) {QuickSort (p, ultimo);}
		
		}
		
	}
    
    
    public ArrayList<Comparacion> getV(){
    	return arreglo;
    }
    
    public void setArreglo(ArrayList<Comparacion> P){
    	arreglo = P;
    }
    
    
    

}
