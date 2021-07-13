package org.example;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;


import static org.mockito.Mockito.*;

/*BREVE TEORIA

1)si creano dei mock in due modi, in modo statico usando mock() oppure tramite annotation @Mock
2)Principalmente si crea un mock di una classe perchè magari istanziarla non è comodo, oppure posono esserci
metodi che non sono facili da implementare
quindi creando un mock e usando when() e thenReturn() io simulo già il funzionamento del metodo e posso usarlo per continuare il mio test
guarda esempio con assertEquals()
3)dato che il mock registra tutte le interazioni, è molto utile per verificare quante volte un metodo viene chiamato
guarda l'esempio introduttivo
*/
public class MockitoTestingStatic {

            @Test
            public void firstMockitoTest(){
                App mockedList = mock(App.class); // STATIC MOCK della classe App da testare
                //NB. i metodi della classe mock-ata non devono essere static/private!!
                when(mockedList.fattoriale(3)).thenReturn(6);
                System.out.println(mockedList.fattoriale(3)); // questo sa farlo perchè l'ho detto sopra
                // System.out.println(mockedList.fattoriale(2)); // questo no

                //per questa riga, metto il language 8 nel modulo del progetto
                //doAnswer(invocation -> "inserire numero positivo").when(mockedList).fattoriale(-3);


            }

            @Test
            public void secondMockitoTest(){
                App mockedList = mock(App.class);
                //avvio il metodo
                mockedList.binomiale(5,2);
                //verifico che il metodo sia partito
                //verify(mockedList).binomiale(5,2); // esempio che funziona
                //verify(mockedList).binomiale(3,2); //esempio che non funziona
                // verify(mockedList).fattoriale(5); // esempio di errore dove però mi mostra una interazione con .binomiale(5,2);
                // se ora aggiungo il seguente codice :
                // mockedList.binomiale(7,5);
                // facendo rieseguire
                // verify(mockedList).fattoriale(5); // mi dice che ho 2 interazioni
            }
            @Test
            public void invocationsMockitoTest(){
                App mockedList = mock(App.class);
                //invoco 5 volte (?)
                verify(mockedList, times(5));

            }
}
