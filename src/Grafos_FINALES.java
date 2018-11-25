

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
public class Grafos_FINALES {

    public static void main(String[] args) {
        Grafos_FINALES admin = new Grafos_FINALES();
        Random r = new Random();
        ejemplo_Matriz admincion = new ejemplo_Matriz();
        int d = Integer.parseInt(JOptionPane.showInputDialog("ingrese numero para incializar el grafo"));

        long[][] t = admin.ingresar_gRafo(r, d);
        System.out.println("mostrar");
        admin.mostrar(t);
        System.out.println("sumar");
        admin.sumar_filas(t);
        System.out.println("mutar");
        long[][] a = admin.disminuir(t, d);
        admin.mostrar(a);
        System.out.println("cambiadar");
        admin.cambiar(a);
        System.out.println("");
        System.out.println("mostrar");
        admin.mostrar(a);
        admin.sumar_filas(a);
        System.out.println("");
    }

    public long[][] ingresar_gRafo(Random r, int cantidad) {
        //  int cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad para iniciar el grafo"));
        long matriz[][] = new long[cantidad][cantidad];

        for (int i = 0; i < cantidad; i++) {
            for (int j = i; j < cantidad; j++) {
                int ran = r.nextInt(10);
                int ran1 = r.nextInt(100);
                if (i == j) {
                    matriz[i][j] = 0;
                    matriz[j][i] = 0;
                } else if (i != j) {
                    if (ran < 5) {
                        matriz[i][j] = 0;
                        matriz[j][i] = 0;
                    } else if (ran > 5) {
                        matriz[i][j] = ran1;
                        matriz[j][i] = ran1;
                    }
                }
            }
        }
        return matriz;
    }

    public void mostrar(long mat[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println("");
        }
    }

    public void sumar_filas(long mat[][]) {
        long sumf;
        for (int i = 0; i < mat.length; i++) {
            sumf = 0;
            for (int j = 0; j < mat[i].length; j++) {
                sumf = sumf + mat[i][j];
            }
            System.out.println("La suma de los valores de la fila " + (i) + " es:      " + sumf);
        }
        System.out.println("");
    }

    public long[][] disminuir(long mat[][], long sumf) {
        long[][] a = mat;
        long s = 0, y = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                sumf = sumf + mat[i][j];
                s = mat[i][j];
                y = s + y;
                if (y <= 150) {
                    a[i][j] = mat[i][j];
                } else if (y > 150) {
                    a[i][j] = -1;
                }
            }
            System.out.println("La suma de los valores de la fila " + (i) + " es:      " + y);
            y = 0;
        }
        System.out.println(sumf);
        return a;
    }

    public long[][] cambiar(long mat[][]) {
        long[][] a = mat;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (a[i][j] <0) {
                    a[i][j] = 0;
                }else{
                    System.out.println("no hay cambio");
                }
            }
        }
        return a;
    }
    
}