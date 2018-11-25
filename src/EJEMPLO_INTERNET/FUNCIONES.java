/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJEMPLO_INTERNET;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Sulay2016
 */
public class FUNCIONES {
     public static void main(String[] args) {
        
FUNCIONES admin= new FUNCIONES();

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


