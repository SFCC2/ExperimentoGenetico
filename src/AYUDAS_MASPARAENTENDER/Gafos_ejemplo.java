/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AYUDAS_MASPARAENTENDER;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Sulay2016
 */
public class Gafos_ejemplo {

    //Metodo para determinar todo los caminos Floyd
    /*
    metodo que recibe dos nodos, si hay camino o no
    cual es el peso o la distancia de los caminos 
    metodo que retorne una lista de los vecinos
     */
    public static void main(String[] args) {
        

    }/*
       public void ejecutarDinamico(Grafos_ejemplo admin) {
          Random r = new Random();
        //admin.ingresar_gRafo(r);
        long matriz[][] = admin.ingresar_gRafo(r);
        admin.mostrar(matriz);
        String camino[][] = admin.algoritmo(matriz);
        String y = "ayudame a seguir en la materia";
        admin.caminos(0, 0, camino, y);
}*/

    public long[][] ingresar_gRafo(Random r) {
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("ingrese la cantidad para iniciar el grafo"));
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
                    } else {
                        if (ran > 5) {
                            matriz[i][j] = ran1;
                            matriz[j][i] = ran1;
                        }
                    }
                }
            }
        }  return matriz;
    }

 
      public long[][] mostrar(long matriz[][]) {
        for (int k = 0; k < matriz.length; k++) {
            System.out.print("|");
            for (int l = 0; l < matriz[k].length; l++) {
                System.out.print(matriz[k][l] + " ");
                if (l != matriz[k].length - 1) {
                    // System.out.print("\t");
                    System.out.print("\t");
                }
            }
            System.out.println("|");
        }
        return matriz;
    }
      
       public String[][] algoritmo(long[][] matriz) {
        int vertice = matriz.length;
        long matrizAdyacencia[][] = matriz;
        String caminos[][] = new String[vertice][vertice];
        String caminosAuxiliar[][] = new String[vertice][vertice];
        String caminoRecorrido = "", cadena = "", caminitos = "";
        float temporal1, temporal2, temporal3, temporal4, minmo;
        for (int i = 0; i < vertice; i++) {
            for (int j = 0; j < vertice; j++) {
                caminos[i][j] = "";
                caminosAuxiliar[i][j] = "";
            }
        }
        for (int k = 0; k < vertice; k++) {
            for (int i = 0; i < vertice; i++) {
                for (int j = 0; j < vertice; j++) {
                    temporal1 = matrizAdyacencia[i][j];
                    temporal2 = matrizAdyacencia[i][k];
                    temporal3 = matrizAdyacencia[k][j];
                    temporal4 = temporal2 + temporal3;
                    minmo = Math.min(temporal1, temporal4);
                    if (temporal1 != temporal4) {
                        if (minmo == temporal4) {
                            caminoRecorrido = "";
                            caminosAuxiliar[i][j] = k + "";
                            caminos[i][j] = caminos(i, k, caminosAuxiliar, caminoRecorrido) + (k + 1);
                        }
                    }
                    matrizAdyacencia[i][j] = (long) minmo;
                }
            }
            //Agregando el camino a cadena
            for (int i = 0; i < vertice; i++) {
                for (int j = 0; j < vertice; j++) {
                    cadena = cadena + "[" + matrizAdyacencia[i][j] + "]";
                }
                cadena = cadena + "\n";
            }
            ////////////////////////////
            for (int i = 0; i < vertice; i++) {
                for (int j = 0; j < vertice; j++) {
                    if (matrizAdyacencia[i][j] != 1000000000) {
                        if (i != j) {
                            if (caminos[i][j].equals("")) {
                                caminitos += "De (" + (i + 1) + "----->" + (j + 1) + ")  Irse por ....(" + (i + 1) + "," + (j + 1) + ")\n";
                            } else {
                                caminitos += "De (" + (i + 1) + "----->" + (j + 1) + ")  Irse por ....(" + (i + 1) + "," + caminos[i][j] + "," + (j + 1) + ")\n";
                            }
                        }
                    }
                }
            }
        }
        System.out.println("\nLa matriz de caminos mas cortos entres los diferentes vertices es:\n" + cadena + "\nLos diferentes caminos mas cortos entre vertices son:\n" + caminitos);
        return caminos;
    }

    public String caminos(int i, int k, String[][] caminosAuxiliar, String caminoRecorrido) {
        if (caminosAuxiliar[i][k].equals("")) {
            return "";
        } else {
            caminoRecorrido += caminos(i, Integer.parseInt(caminosAuxiliar[i][k].toString()), caminosAuxiliar, caminoRecorrido) + (Integer.parseInt(caminosAuxiliar[i][k].toString() + 1)) + ",";
            return caminoRecorrido;
        }
    }
}


