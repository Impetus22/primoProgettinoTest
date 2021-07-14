package org.example;

import org.springframework.stereotype.Service;

/**
 * Hello world!
 */
@Service
public class App {
    public static void main(String[] args) {

    }

    /**
     * <p> Metodo che svolge il fattoriale</p>
     *
     * @param numero numero che vogliamo
     * @return il fattoriale del numero desiderato
     */
    public static int fattoriale(int numero) {
        int fatt = 1;

        if (numero == 0) {
            return 1;
        } else {
            for (int i = 1; i <= numero; i++) {
                fatt = fatt * i;
            }
        }
        return fatt;
    }

    /**
     * <p> Metodo che svolge la potenza</p>
     *
     * @param a base
     * @param b esponente
     * @return a elevato b
     */
    public int potenza(int a, int b) {
        int pot = 1;
        if (b == 0) {
            return 1;
        } else {

            for (int k = b; k > 0; k--) {
                pot = pot * a;
            }
        }
        return pot;
    }
    //terzo metodo: Coefficiente binomiale (n k) = (n!)/(k!*(n-k)!) n,k interi >=0

    /**
     * <p> Metodo che svolge il coefficiente binomiale</p>
     *
     * @param n primo numero
     * @param k secondo numero
     * @return il coefficiente binomiale
     */
    public int binomiale(int n, int k) {
        int nFatt = fattoriale(n);
        int kFatt = fattoriale(k);
        int nkFatt = fattoriale(n - k);
        return nFatt / (kFatt * nkFatt);
    }

}

