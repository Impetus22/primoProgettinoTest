//funziona non fa nulla

package org.example;


import org.example.web.AppController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestDiAvvio {

    @Autowired
    private App app;

    @Autowired
    private AppController appController;

    @Test
    public void contextLoads() {
        Assertions.assertNotNull(app);
        Assertions.assertNotNull(appController);
    }
}
