package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

// aggiungo questa annotazione
@ExtendWith(MockitoExtension.class)
public class MockitoTestAnnotation {

    @Mock
    App mockedList;

    @Test
    public void binomialeMockitoTest() {
        mockedList.binomiale(5, 2);
        verify(mockedList).binomiale(5, 2);
        when(mockedList.binomiale(3, 3)).thenReturn(1);
        Assertions.assertEquals(mockedList.binomiale(3, 3), 1);
    }

    @Test
    public void coeffBinMockitoTest() {
        //when(mockedList.fattoriale(5)).thenReturn(120);
        //when(mockedList.fattoriale(4)).thenReturn(24);
        //when(mockedList.fattoriale(1)).thenReturn(1);
        mockedList.binomiale(5, 4);
    }
}
