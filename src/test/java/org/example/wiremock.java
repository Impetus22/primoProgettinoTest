package org.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.client.WireMock;

import io.restassured.RestAssured;

import io.restassured.response.Response;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Scanner;

public class wiremock{
    private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }
    private static final String HOST = "mock-dev.vtlab.local";
    private static final int PORT = 8083;
    private static WireMockServer server = new WireMockServer(PORT);
    @BeforeClass
    public static void inizializzoServer(){
        server.start();

        ResponseDefinitionBuilder mockResponse = new ResponseDefinitionBuilder();
        mockResponse.withStatus(205);


        WireMock.configureFor(HOST,PORT);

        WireMock.stubFor(WireMock.get("/v100/profile").willReturn(mockResponse));

       // WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/v1/profile")).willReturn(WireMock.aResponse()
                //.withHeader("Content-Type", "text/plain")
                //.withBody("testo")));

    }
    @Test
    public void testing() throws IOException {
        String testingApi = "http://mock-dev.vtlab.local:8083/v100/profile";
        RestAssured.given().when().get(new URL(testingApi)).then().assertThat().statusCode(200);
    }
    @AfterClass
    public static void chiudoServer(){
        if(server.isRunning() && null != server){
            server.shutdown();
        }
    }
}
