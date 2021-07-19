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

public class WiremockTest {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static WireMockServer server = new WireMockServer(PORT);
    @BeforeClass
    public static void inizializzoServer(){
        server.start();
        WireMock.configureFor(HOST,PORT);
        // ora imposto le risposte
        ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
        mockResponse.withStatus(201);
        mockResponse.withStatusMessage("Hello");
        mockResponse.withHeader("token", "11");
        mockResponse.withBody("testo nel body");
        WireMock.givenThat(WireMock.get("/fattoriale/5").willReturn(mockResponse)); // associo la mia Api
    }
    @Test
    public void testing(){
        String testingApi = "http://localhost:"+PORT+"fattoriale/5";
        Response response = RestAssured.given().get("http://localhost:8080/fattoriale/5").then().statusCode(201).extract().response();
        WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/fattoriale/5")));
        Assert.assertEquals(response.getHeader("token"),"11");
        Assert.assertEquals(response.getBody().asString(),"testo nel body");

    }
    @AfterClass
    public static void chiudoServer(){
        if(server.isRunning() && null != server){
            server.shutdown();
        }
    }
}
