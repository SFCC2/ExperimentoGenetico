


import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sulay2016
 */
public class ejemplo_Matriz {
    
    public static void main(String[] args) {
        /*int fila= Integer.parseInt(JOptionPane.showInputDialog("ingrese matriz como fila  la canitdad"));;
int columna= Integer.parseInt(JOptionPane.showInputDialog("ingrese matriz como columnas  la canitdad"));;*/
        
        
        ejemplo_Matriz admin = new ejemplo_Matriz();
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingrese matriz como columnas  la canitdad"));
        int[][] a = admin.ingresar(cantidad);
        Random r = new Random();
        
        
        admin.mostrar(a);
        System.out.println("sumatora de filas");
        admin.sumar_filas(a);
    }
    
    
    
    
    public int[][] ingresar(int cantidad) {
        int[][] a = new int[cantidad][cantidad];
        
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < cantidad; j++) {
                int b = Integer.parseInt(JOptionPane.showInputDialog("ingrese el contenido de la matriz posicion "));
                a[i][j] = b;
            }
        }
        return a;
    }
    
    public void mostrar(int mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println("");
        }
    }
    
    
    
    

    public void sumar_filas(int mat[][]) {
        int sumf;
        for (int i = 0; i < mat.length; i++) {            
            sumf = 0;            
            for (int j = 0; j < mat[i].length; j++) {                
                sumf = sumf + mat[i][j];                
            }            
            System.out.println("La suma de los valores de la fila " + (i + 1) + " es:      " + sumf);            
        }        
        System.out.println("");        
    }
    
    public void sumar_columna(int mat[][]){
        int sumc;  
        for (int i = 0; i < mat[0].length; i++) {  
       sumc=0;  
      for (int j = 0; j < mat.length; j++) {  
        sumc=sumc+mat[j][i];  
        }  
        System.out.println("La suma de los valores de la columna "+(i+1)+" es: "+sumc);  
      }  
     System.out.println("");  
    }
    public void Suma_diagonal (int mat[][],int fila, int columna){
         int sumd=0; 
         if (fila-columna==0){  
       for (int i = 0; i < mat.length; i++) {     
          sumd=sumd+mat[i][i];   
        }  
      System.out.println("La suma de la diagonal principal es: "+sumd);  
     }  
     System.out.println("");  
    }
    public void Suma_diagonal_Inversa (int mat[][],int fila, int columna){
        int sumdi=0; 
        if (fila-columna==0){  
        for(int i = 0; i < mat.length; i++){  
          for(int j = 0; j < mat[i].length; j++){  
           if( i+j == mat.length - 1){  
           sumdi = sumdi + mat[i][j];  
          }  
        }  
      }  
        System.out.println("La suma de la diagonal secundaria es: "+sumdi);  
      }  
    }
}
