package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    // non mi prende Assertions ma solo Assert
    @Test
    public void fattorialeTest() {
        App oggetto = new App();
        int numero = oggetto.fattoriale(0);
        //controllo che sia 1 il fattoriale di 0
        Assertions.assertEquals(1, numero);
        //controllo che non sia mai nullo, qualsiasi valore
        Assertions.assertNotNull(numero);
        //controllo randomico per vedere se funziona
        Assertions.assertEquals(120, numero);

    }

    @Test
    public void potenzaTest() {
        App oggetto = new App();
        int numero = oggetto.potenza(2, 5);
        // esempio di errore    expected 31, actual 32
        Assertions.assertEquals(31, numero);
        //test corretto
        Assertions.assertEquals(32, numero);
        Assertions.assertNotNull(numero);
        //controllo che se b = 0, allora mi ritorna 1
        int numero2 = oggetto.potenza(2, 0);
        Assertions.assertEquals(1, numero2);
        //controllo che se a = 0; allora mi ritorna 0
        int numero3 = oggetto.potenza(0, 5);
        Assertions.assertEquals(0, numero3);
        //controllo che se a = e b = 0, mi ritorna 1;
        int numero4 = oggetto.potenza(0, 0);
        Assertions.assertEquals(1, numero4);
    }

    @Test
    public void binomialeTest() {
        App oggetto = new App();
        int prova = oggetto.binomiale(3, 5);
        // mi aspetto che numero sia sempre 0 quando a<b
        Assertions.assertEquals(0, prova);
        //mi aspetto che prova2 non sia mai nullo quando ho a>=b
        int prova2 = oggetto.binomiale(4, 2);
        Assertions.assertNotNull(prova2);
        //mi aspetto che se a = b, allora mi restituisca 1
        int prova3 = oggetto.binomiale(5, 5);
        Assertions.assertEquals(1, prova3);
    }
}
