package org.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WiremockStub {
    private static final String HOST = "mock-dev.vtlab.local";
    private static final int PORT = 8083;
    private static WireMockServer server = new WireMockServer(PORT);
    @BeforeClass
    public static void initServer(){
        server.start();
        WireMock.configureFor(HOST,PORT);
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/v1/profile")).willReturn(WireMock.aResponse().withBodyFile("src/test/resources/__files")));


    }
    @Test
    public void testing(){
        String testingApi = "http://mock-dev.vtlab.local:8083/v1/profile";
        Response response = RestAssured.given().when().get(testingApi).then().extract().response();
        WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/v1/profile")));
        Assert.assertEquals(response.jsonPath().get("profileData.hashedUsername"),"75c3d038ad8dae2825012e1b1e024b2c");
    }
    @AfterClass
    public static void chiudoServer(){
        if(server.isRunning() && null != server){
            server.shutdown();
        }
    }
}
