package org.example.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; // uso getmapping
import org.springframework.web.bind.annotation.RestController;

import org.example.App;

@RestController
public class AppController {

    private final App app;

    public AppController(App app) {

        this.app = app;

    }

    @GetMapping("/fattoriale/{numero}")
    public int calcoloFattoriale(@PathVariable("numero") int numero) {
        return app.fattoriale(numero);
    }

    @GetMapping("/potenza/{a}/{b}")
    public int elevamentoPotenza(@PathVariable("a") int a, @PathVariable("b") int b) {
        return app.potenza(a, b);
    }

    @GetMapping("/coeffbinomiale/{n}/{k}")
    public int coefficienteBinomiale(@PathVariable("n") int n, @PathVariable("k") int k) {
        return app.binomiale(n, k);
    }

    //funzione di test /
    @RequestMapping("/")
    public String doHello() {
        return "Hello World, this is a random text";
    }

}
