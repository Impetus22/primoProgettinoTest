package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("ciao");
    }


    // primo metodo: FATTORIALE
    public int fattoriale(int numero){
        int fatt = 1;
        if(numero ==0)
        {
            return 1;
        }
        else{
            for (int i = 1; i <= numero; i++)
            {
                fatt = fatt * i;
            }
        }
        return fatt;
    }
    //secondo metodo: ELEVAMENTO A POTENZA ( numeri interi per comodità ) a^b (a,b) interi
    public int potenza(int a, int b){
        int pot = 1;
        if(b==0){
            return 1;
        }
        else{

            for(int k=b;k>0;k--){
                pot = pot*a;
            }
        }
        return pot;
}
    //terzo metodo: Coefficiente binomiale (n k) = (n!)/(k!*(n-k)!) n,k interi >=0
    public  int binomiale(int n, int k){
        int n_fatt = fattoriale(n);
        int k_fatt = fattoriale(k);
        int n_k_fatt = fattoriale(n-k);
        return n_fatt/(k_fatt*n_k_fatt);
    }
}

