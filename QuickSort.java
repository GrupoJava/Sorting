	
public class QuickSort {

	int arreglo[];
	int tamano;
	int aux;
	
	public void datos (int [] entrada ){
			
		if (entrada.length == 0){
			return;
		}
			this.arreglo = entrada;
			tamano = entrada.length;
			//Se llama a quick con parametros de 0 --> el tamano del arreglo
			quick.(0, tamano-1);
		}
		
	private void quick (int primero, int ultimo){
	
		int p = primero;	//Para realizar el recorrido del primer al ultimo elemento
		int u = ultimo;		//Para realizar el recorrido del utlimo al primer elemento
		// Se coloca el pivote como el numero de en medio
		int pivote = arreglo[(primero+ultimo)/2]; 	
		
		//Estas instruccinoes ayudan a dividir el arreglo
		while (p <= u){
			/*
			Se verificaran los numeros a la izquierda del pivote que sean mayores que el 
			y los numero a la derecha del pivote que sean menores a el. Cuando se identifiquen
			se hará un intercambio de valores
			*/
			while (arreglo[p] < pivote){p++;}	//Busca elementos mayores al pivote
			while (arreglo[u] > pivote){u--;}	//Busca elementos menores al pivote
			
			//Se realiza el intercambio de numeros utilizando una variable auxiliar
			if (p <= u){
				aux = arreglo[p];
				arreglo[p] = arreglo[u];
				arreglo[j] = aux;
					
				//Mueve a la siguiente posicion
				p++;
				u--:
			}
		//Vuelve a llamar quick
		if (primero < u){quick (primero, u);}
		if (p < ultimo) {quick (p, ultimo);}
		
			
		}
		
	}
	
	
}