package org.example;


import org.example.web.AppController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;


public class TestController {
    @Test
    public void firstTest(){
        App mockedList = mock(App.class); // creo mock della classe App ( che rappresenta il mio servizio con i metodi )
        //given
        when(mockedList.fattoriale(4)).thenReturn(24);
        //when
        AppController appController = new AppController(mockedList);
        int numero = appController.Calcolofattoriale(4);
        //then
        verify(mockedList,times(1)).fattoriale(4);

        //invece scrivendo:         verify(mockedList,times(2)).fattoriale(4);
        //ottengo errore perchè non ho invocato 2 volte il metodo, ma 1 volta
    }
    //Quindi il senso è che io avendo il @Service ho dei metodi, che possono anche non essere implementati, dunque utilizzando
    //mockito posso simularne il comportamento e continuare il test.
    //verifico inoltre quante volte il metodo viene invocato

    //se infatti in App.java vado a canellare il calcolo del fattoriale, scrivendo un return 0, se faccio un
    //        System.out.println(numero);    ottengo comunque 24


    @Test
    public void secondTest(){
        App mockedList = mock(App.class);

        //given
        when(mockedList.binomiale(4,3)).thenReturn(4);

        //when
        AppController appController = new AppController(mockedList);
        appController.Coefficientebinomiale(4,3);

        //then
        verify(mockedList,times(1)).binomiale(4,3);

    }

    @Test
    public void thirdTest(){
        App mockedList = mock(App.class);

        //given
        when(mockedList.potenza(2,3)).thenReturn(8);

        //when
        AppController appController = new AppController(mockedList);
        int valore = appController.Elevamentopotenza(2,3);

        //then
        verify(mockedList,times(1)).potenza(2,3);
        int atteso = 8;
        Assertions.assertEquals(atteso,valore);
    }

    //Esempio di ERRORE
    @Test
    public void fourthTest(){
        App mockedList = mock(App.class);

        //given
        when(mockedList.potenza(2,3)).thenReturn(8);

        //when
        AppController appController = new AppController(mockedList);
        int valore = appController.Elevamentopotenza(2,4);

        //then
        verify(mockedList,times(1)).potenza(2,3);
        int atteso = 8;
        Assertions.assertEquals(atteso,valore);
    }
}
