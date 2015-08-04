import javax.swing.*;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;

/**
 * Universidad del Valle de Guatemala 
 * Algoritmos y Estructura de Datos
 * Seccion 10 
 * @author Andre Rodas
 * @author Delbert Custodio
 * @author Josemite Noe 
 * @author Rudy Garrido
 * La clase <GUI> posee todos los atributos del JFrame la interfaz <ActionListener> para el manejo de evento del click en el boton
 */
public class GUI extends JFrame implements ActionListener{
	
	final private int cantidad = 5;
    private JButton Bselsort,Bquicksort,Binsertsort,Bmergesort,Bradixsort,creartxt,leertxt,copiartxt;
	private PrintWriter escribir;
	private Sorts mySort;
	
	
	/**
	 * Este procedimiento esconde o no los botones para evitar de que se realize un sort con el arreglo vacio
	 * <a>: es true si esta vacio, se chequea si el arreglo esta null y su tamaño es mayor a uno
	 */
	public void habilitar(){
		boolean a = false;
		if (mySort.vacio())
			a = true;
		Bselsort.setVisible(a);
		Bquicksort.setVisible(a);
		Binsertsort.setVisible(a);
		Bmergesort.setVisible(a);
		Bradixsort.setVisible(a);
		copiartxt.setVisible(a);			
	}
		
    /**
     * Clase constructora, se crean 8 botones con ActionListener y se llama al constructor de la clase <Sorts> 
     */
    public GUI() {
        setLayout(null);
        Bselsort=new JButton("Selection sort");
        Bselsort.setBounds(185,150,130,23);
        add(Bselsort);
        Bselsort.addActionListener(this);
        
        Bquicksort=new JButton("Quick Sort");
        Bquicksort.setBounds(185,180,130,23);
        add(Bquicksort);
        Bquicksort.addActionListener(this);
        
        Binsertsort=new JButton("Insertion Sort");
        Binsertsort.setBounds(185,210,130,23);
        add(Binsertsort);
        Binsertsort.addActionListener(this);       
        
        Bmergesort=new JButton("Merge Sort");
        Bmergesort.setBounds(185,240,130,23);
        add(Bmergesort);
        Bmergesort.addActionListener(this);   
        
        Bradixsort=new JButton("Radix Sort");
        Bradixsort.setBounds(185,270,130,23);
        add(Bradixsort);
        Bradixsort.addActionListener(this);   
        
        creartxt=new JButton("Crear txt de "+String.valueOf(cantidad)+ " numeros");
        creartxt.setBounds(150,33,200,23);
        add(creartxt);
        creartxt.addActionListener(this); 
        
        leertxt=new JButton("Txt a arreglo");
        leertxt.setBounds(150,72,200,23);
        add(leertxt);
        leertxt.addActionListener(this); 
        
        copiartxt=new JButton("Arreglo a txt");
        copiartxt.setBounds(150,320,200,23);
        add(copiartxt);
        copiartxt.addActionListener(this);   
        
        mySort = new Sorts(cantidad);
        
        habilitar();
    }
    

    /* (non-Javadoc)
     * Se realiza una diferente tarea dependiendo del .getSource del boton
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Bselsort) {
        	mySort.SelectionSort();
            setTitle("Selection Sort");
        }
        else
        if (e.getSource()==Bquicksort) {
        	mySort.QuickSort();
            setTitle("Quick Sort");
        }
        else
        if (e.getSource()==Binsertsort) {
        	mySort.InsertionSort();
            setTitle("Insertion Sort");
        }
        else
        if (e.getSource()==Bmergesort) {
        	mySort.MergeSort();
            setTitle("Merge Sort");
        }  
        else
        if (e.getSource()==Bradixsort) {
           	mySort.RadixSort();
            setTitle("Radix Sort");
        }  
            else
        if (e.getSource()==creartxt) {
            try {
    			escribir = new PrintWriter("numeros.txt", "UTF-8");							//Crea archivo de textoS
    		} catch (FileNotFoundException | UnsupportedEncodingException m) {
    			m.printStackTrace();
    		}
			Random rnd = new Random(); 
			for (int i=1;i<=cantidad;i++)
				escribir.println(rnd.nextInt(cantidad));
			escribir.close();   
			setTitle("Crear txt");
        }  
        else
        if (e.getSource()==leertxt) {
            try {
				for (String line : Files.readAllLines(Paths.get("numeros.txt"))) {			//Permite la lectura del todo el archivo, lee linea por linea
					Integer i = Integer.valueOf(line);					
			        mySort.agregar(i);
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
            setTitle("Leer txt");
        }  
        else
        if (e.getSource()==copiartxt) {
        	try {
        		escribir = new PrintWriter("numeros.txt", "UTF-8");
     		} catch (FileNotFoundException | UnsupportedEncodingException m) {
     			m.printStackTrace(); 
     		}
 			for (int i=1;i<=cantidad;i++)
 				escribir.println(mySort.obtener(i-1));										//Se obtiene los datos del arreglo de MySort y se copia en un archivo de texto nuevo
 			escribir.close();           	
            setTitle("Copiar txt");
        }       
        habilitar();
    }
    
    /**
     * Se inicializan el constructor de <GUI> para crear el <JFrame> con sus respectivos elementos
     */
    public static void main(String[] ar){
        GUI formulario1=new GUI();
        formulario1.setBounds(0,0,500,500);
        formulario1.setVisible(true);
    }  
    
}