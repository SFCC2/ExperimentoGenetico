package AYUDAS_MASPARAENTENDER;


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
public class ejecutar_algortimo {

    /**
     * @param args the command line arguments
     */
    ///1234
    ///4321
    public static void main(String[] args) {

        //medio funciona en unsolo sentido
        /*     System.out.println("sumatoria2");
        int total = 0;
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < cantidad; j++) {
                if (i <= j) {

                    total = total + a[i][j];
                    // System.out.println("contenido de la filas: "+j+"es: "+a[i][j]);
                    System.out.println("la suma de la filas: " + j + " es: " + total);
                } else if (i > j) {
                    System.out.println("solo sumatoria de filas");
                }
            }
        }*/
        ejecutar_algortimo admin = new ejecutar_algortimo();
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingrese matriz como columnas  la canitdad"));
        int[][] a = admin.ingresar(cantidad);
        /* System.out.println("la matriz es: ");
        admin.mostrar(cantidad, a);

        System.out.println("la posicion de la fila matriz es");*/
        //admin.posicion(cantidad, a);
        admin.condicion(a);
        System.out.println("");
        admin.contadoe(a, cantidad);
    }

    public void condicion(int[][] a) {
        System.out.println("posiciones");
        int y = 0, x = 0, cont = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.print("|");
            for (int j = 0; j < a.length; j++) {
                x = j;
                cont = cont + x;
                System.out.print(x + " ");
            }
            System.out.println("|");
        }
        System.out.println("resltado de sumatoria: " + cont);
    }

    public void contadoe(int[][] a, int cantida) {
        System.out.println("posiciones");
        int y = 0, x = 0, cont = 0, tot=cantida-1;
        for (int i = 0; i < cantida; i++) {
            System.out.print("|");
            for (int j = 0; j < cantida; j++) {
                x = j;
                if (cont <= tot) {
                    cont = cont + x;
                    System.out.print(cont + " ");
                } else if (cont >tot) {
                    cont = 0;
                    cont = cont + x;
                    System.out.print(cont + " ");
                }
            }
            System.out.println("|");
        }

    }

//43
//21
    public void sumatoria(int cantidad, int[][] a, ejecutar_algortimo admin) {
        System.out.println("sumatoria2");
        int total = 0;
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < cantidad; j++) {
                if (i <= j) {

                    total = total + a[i][j];
                    admin.suma(total);
                } else if (i > j) {
                    System.out.println("solo sumatoria de filas");
                }
            }
        }
    }

    public void suma(int y) {
        int x = 0;
        System.out.println("suma= " + x + " + " + y);
        x = +y;
        System.out.println("suma=: " + x);

    }

    /*   public void condicion(int y, int cantidad, int[][] a) {
        int sum = 0, cantiTotal = cantidad - 1;
        System.out.println("");

        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < cantidad; j++) {

            }
        }
    }*/
    public void mostrar(int cantidad, int[][] a) {
        System.out.println("mostrar matriz: ");
        for (int i = 0; i < cantidad; i++) {
            System.out.print("|");
            for (int j = 0; j < cantidad; j++) {
                System.out.print(a[i][j] + " ");

            }
            System.out.println("|");
        }
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

    public void posicion(int cantidad, int[][] a) {
        System.out.println("posiciones");
        int y = 0, x = 0, cont = 0;
        for (int i = 0; i < cantidad; i++) {
            System.out.print("|");
            for (int j = 0; j < cantidad; j++) {
                x = j;
                System.out.print(x + " ");
            }
            System.out.println("|");
        }
    }
}
