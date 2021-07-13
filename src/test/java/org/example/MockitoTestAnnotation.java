package org.example;
import static org.mockito.Mockito.*;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

// aggiungo questa annotazione
@RunWith(MockitoJUnitRunner.class)
public class MockitoTestAnnotation {

    @Mock
    App mockedList;

    @Test
    public void binomialeMockitoTest(){
        mockedList.binomiale(5,2);
        verify(mockedList).binomiale(5,2);
        when(mockedList.binomiale(3,3)).thenReturn(1);
        Assertions.assertEquals(mockedList.binomiale(3,3),1);

    }
    @Test
    public void coeffBinMockitoTest(){
        when(mockedList.fattoriale(5)).thenReturn(120);
        when(mockedList.fattoriale(4)).thenReturn(24);
        when(mockedList.fattoriale(1)).thenReturn(1);
        mockedList.binomiale(5,4);
    }



}
