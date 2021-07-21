/*
Esempio WireMock in localhost CON json .. FUNZIONA
 */
package org.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WiremockLocalHostFromJSONTest {
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static WireMockServer server = new WireMockServer(PORT);
    @BeforeClass
    public static void inizializzoServer() {
        server.start();
        WireMock.configureFor(HOST,PORT);
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/prova"))
                .willReturn(WireMock.aResponse().withStatus(200)
                        .withHeader("Content-Type", "application/json").withBodyFile("index.json")));

    }
    @Test
    public void testing(){
        String testingApi = "http://localhost:8080/prova";
        Response response = RestAssured.given().when().get(testingApi).then().extract().response();
       // WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/prova")));
          Assert.assertEquals(response.jsonPath().get("profileData.hashedUsername"),"75c3d038ad8dae2825012e1b1e024b2d");
        //Assert.assertEquals(response.jsonPath().get("profileData.colaList[0]"),"Lista12");
    }
    @AfterClass
    public static void chiudoServer(){
        if(server.isRunning() && null != server){
            server.shutdown();
        }
    }
}
