/*
Esempio WireMock in mock-dev.vtlab.local SENZA json .. FUNZIONA
 */
package org.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WiremockwebaemTest {
    private static final String HOST = "mock-dev.vtlab.local";
    private static final int PORT = 8083;
    private static WireMockServer server = new WireMockServer(PORT);
    @BeforeClass
    public static void inizializzoServer() {
        server.start(); //start del sever
        WireMock.configureFor(HOST,PORT);   //configuro l'host e la porta

        ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
        mockResponse.withStatus(200); //risposta1
        mockResponse.withBody("hello"); //risposta2
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/prova")).willReturn(mockResponse));
    }
    @Test
    public void testing(){
        String testingApi = "http://mock-dev.vtlab.local:8083/prova";
        Response response = RestAssured.given().when().get(testingApi).then().extract().response();
        WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/prova")));
        Assert.assertEquals(response.getBody().asString(),"hello");
    }
    @AfterClass
    public static void chiudoServer(){
        if(server.isRunning() && null != server){
            server.shutdown();
        }
    }

}
