package org.example;

import static org.junit.Assert.assertTrue;



import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void fattorialeTest() {
        App oggetto = new App();
        int numero = oggetto.fattoriale(5);
        // non mi prende Assertions ma solo Assert
        Assert.assertNotNull(numero);
        Assert.assertEquals(120,numero);
    }
    @Test
    public void potenzaTest() {
        App oggetto = new App();
        int numero = oggetto.potenza(2,5);
// esempio di errore    expected 31, actual 32
        Assert.assertEquals(31,numero);
        //test corretto
        Assert.assertEquals(32,numero);
        Assert.assertNotNull(numero);
        // ho lasciato apposta che nella funzione potenza non controllo i numeri negativi
        // provo infatti con a=-2 e b = 5, expected 32 actual -32
    }
    @Test
    public void binomialeTest(){
        App oggetto = new App();
        int prova = oggetto.binomiale(3,5);
        // mi aspetto che numero sia sempre 0 quando a<b
        Assert.assertEquals(0,prova);
        int prova2= oggetto.binomiale(4,2);
        //mi aspetto che prova2 non sia mai nullo quando ho a>=b
        Assert.assertNotNull(prova2);
    }


}
