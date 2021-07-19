package org.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
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
import java.util.Scanner;

public class secondoStub {
    private String convertResponseToString(HttpResponse response) throws IOException {
        InputStream responseStream = response.getEntity().getContent();
        Scanner scanner = new Scanner(responseStream, "UTF-8");
        String responseString = scanner.useDelimiter("\\Z").next();
        scanner.close();
        return responseString;
    }
    private static final String HOST = "localhost";
    private static final int PORT = 8080;
    private static WireMockServer server = new WireMockServer(PORT);
    @BeforeClass
    public static void inizializzoServer() {
        server.start();
        WireMock.configureFor(HOST,PORT);
        //imposto la response
        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/fattoriale/5")).willReturn(WireMock.aResponse().withBody("testo del body")));
    }
        @Test
        public void testSecondo() throws IOException {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet("http://localhost:8080/fattoriale/5");
            HttpResponse httpResponse = httpClient.execute(request);
            String responseString = convertResponseToString(httpResponse);
            // verifico che il server ha ricevuto una chiamata al corretto url
            WireMock.verify(WireMock.getRequestedFor(WireMock.urlEqualTo("/fattoriale/5")));
            Assert.assertEquals("testo del body", responseString);
        }
    @AfterClass
    public static void chiudoServer(){
        if(server.isRunning() && null != server){
            server.shutdown();
        }
    }

}
