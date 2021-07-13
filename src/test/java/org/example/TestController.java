package org.example;

import org.example.web.AppController;
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

}
