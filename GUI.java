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
    private JButton selsort,boton2,boton3,boton4,creartxt,leertxt,copiartxt;
	private PrintWriter escribir;
	ArrayList<Integer> arreglo;
	
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
        selsort=new JButton("Selection sort");
        selsort.setBounds(185,150,130,23);
        add(selsort);
        selsort.addActionListener(this);
        
        boton2=new JButton("Quick Sort");
        boton2.setBounds(185,180,130,23);
        add(boton2);
        boton2.addActionListener(this);
        
        boton3=new JButton("Insertion Sort");
        boton3.setBounds(185,210,130,23);
        add(boton3);
        boton3.addActionListener(this);       
        
        boton4=new JButton("Cebolla Sort");
        boton4.setBounds(185,240,130,23);
        add(boton4);
        boton4.addActionListener(this);   
        
        creartxt=new JButton("Crear txt de "+String.valueOf(cantidad)+ " numeros");
        creartxt.setBounds(150,33,200,23);
        add(creartxt);
        creartxt.addActionListener(this); 
        
        leertxt=new JButton("Txt a arreglo");
        leertxt.setBounds(150,72,200,23);
        add(leertxt);
        leertxt.addActionListener(this); 
        
        copiartxt=new JButton("Arreglo a txt");
        copiartxt.setBounds(150,108,200,23);
        add(copiartxt);
        copiartxt.addActionListener(this);         
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==selsort) {
        	SelectionSort();
            setTitle("Selection Sort");
        }
        else
        if (e.getSource()==boton2) {
            setTitle("boton 2");
        }
        else
        if (e.getSource()==boton3) {
            setTitle("boton 3");
        }
        else
        if (e.getSource()==boton4) {
            setTitle("boton 4");
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
    }
    
    public static void main(String[] ar){
        GUI formulario1=new GUI();
        formulario1.setBounds(0,0,500,500);
        formulario1.setVisible(true);
    }  
    
}