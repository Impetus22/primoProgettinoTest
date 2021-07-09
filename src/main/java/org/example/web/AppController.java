package org.example.web;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/fattoriale/{numero}")
    public  int Calcolofattoriale(@PathVariable("numero") int numero){
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

    @GetMapping("/potenza/{a}/{b}")
    public int potenza(@PathVariable("a") int a,@PathVariable("b")int b){
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

    @GetMapping("/coeffbinomiale/{n}/{k}")
    public  int binomiale(@PathVariable("n") int n,@PathVariable("k")int k){
        int n_fatt = Calcolofattoriale(n);
        int k_fatt = Calcolofattoriale(k);
        int n_k_fatt = Calcolofattoriale(n-k);
        return n_fatt/(k_fatt*n_k_fatt);
    }


}
