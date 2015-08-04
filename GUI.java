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

public class GUI extends JFrame implements ActionListener{
	
	final private int cantidad = 100;
    private JButton Bselsort,Bquicksort,Binsertsort,Bmergesort,Bradixsort,creartxt,leertxt,copiartxt;
	private PrintWriter escribir;
	ArrayList<Integer> arreglo = null;
	
	public void habilitar(){
		boolean a = false;
		if ((arreglo!=null)&&(arreglo.size()>1))
			a = true;
		Bselsort.setVisible(a);
		Bquicksort.setVisible(a);
		Binsertsort.setVisible(a);
		Bmergesort.setVisible(a);
		Bradixsort.setVisible(a);
		copiartxt.setVisible(a);	

		
	}
	
    public void intercambiar(int pos1, int pos2){
    	int cambio = arreglo.get(pos1);
    	arreglo.set(pos1, arreglo.get(pos2));
    	arreglo.set(pos2, cambio);    	
    }
    
    public void SelectionSort(){
    	for (int i=0;i<=cantidad-2;i++){
    		int minimo = i;
    		for (int j=i+1;j<=cantidad-1;j++){
    			if (arreglo.get(j)<arreglo.get(minimo))
    				minimo=j;
    		}
    	intercambiar(i,minimo);    		
    	}    	
    }
	
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
        
        habilitar();
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==Bselsort) {
        	SelectionSort();
            setTitle("Selection Sort");
        }
        else
        if (e.getSource()==Bquicksort) {
            setTitle("Quick Sort");
        }
        else
        if (e.getSource()==Binsertsort) {
            setTitle("Insertion Sort");
        }
        else
        if (e.getSource()==Bmergesort) {
            setTitle("Merge Sort");
        }  
        else
        if (e.getSource()==creartxt) {
            try {
    			escribir = new PrintWriter("numeros.txt", "UTF-8");
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
            arreglo = new ArrayList<Integer>();
            try {
				for (String line : Files.readAllLines(Paths.get("numeros.txt"))) {
					Integer i = Integer.valueOf(line);
			        arreglo.add(i);
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
 				escribir.println(arreglo.get(i-1));
 			escribir.close();           	
            setTitle("Copiar txt");
        }       
        habilitar();
    }
    
    public static void main(String[] ar){
        GUI formulario1=new GUI();
        formulario1.setBounds(0,0,500,500);
        formulario1.setVisible(true);
    }  
    
}