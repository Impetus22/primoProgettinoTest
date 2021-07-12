/*
//ERRORE: cannot access java.util.function.Predicate
//  class file for java.util.function.Predicate not found
// il problema è assert

package org.example;


import static org.assertj.core.api.Assertions.assertThat;


import org.example.web.AppController;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDiAvvioVerificato {

    @Autowired
    private AppController controller;

    @Test
    public void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
    }
}
*/