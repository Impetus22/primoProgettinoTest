package org.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import net.minidev.json.JSONObject;
import org.eclipse.jetty.util.ajax.JSON;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReadResponseFromFileTest {
    private static final String HOST = "mock-dev.vtlab.local";
    private static final int PORT = 8083;
    private static WireMockServer server = new WireMockServer(PORT);
    @BeforeClass
    public static void inizializzoServer(){
        server.start();
        WireMock.configureFor(HOST,PORT);
        // ora imposto le risposte
        ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
        mockResponse.withStatus(201);

        mockResponse.withBodyFile("src/test/resources/__files/json/index.json"); //file json

        WireMock.givenThat(WireMock.get("/v1/profile").willReturn(mockResponse)); // associo la mia Api
    }
    @Test
    public void testing(){
        String testingApi = "http://mock-dev.vtlab.local:"+PORT;
        String response = RestAssured.given().get(testingApi).then().statusCode(201).extract().response().asString();
        // verifico che il server ha ricevuto una chiamata al corretto url
        WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/v1/profile")));
        // alcune verifiche
       // Assert.assertEquals(response.jsonPath().get("profileData.hashedUsername"),"75c3d038ad8dae2825012e1b1e024b2c");
    }
    @AfterClass
    public static void chiudoServer(){
        if(server.isRunning() && null != server){
            server.shutdown();
        }
    }
}
