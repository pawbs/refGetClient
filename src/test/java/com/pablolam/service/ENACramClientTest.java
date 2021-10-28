package com.pablolam.service;

import com.pablolam.model.MetadataResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ENACramClientTest {

    @InjectMocks
    private ENACramClient fixture;

    @Mock
    private RestTemplate restTemplate;

    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        fixture = new ENACramClient();
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(fixture, "enaCramUrl", "www.enacramurl.com");
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void tc01_givenId_getMetadata_returnsMetadata() {
        // MOCK
        MetadataResponse metadataResponse = new MetadataResponse();
        Mockito.when(restTemplate.getForObject("https://www.enacramurl.com/sequence/id/metadata", MetadataResponse.class))
                .thenReturn(metadataResponse);

        // EXECUTION & INPUT
        MetadataResponse actual = fixture.getMetadata("id");

        // OUTPUT
        assertEquals(actual, metadataResponse);
    }

    @Test
    public void tc02_givenUnknownId_getMetaData_returnsError() {
        MetadataResponse metadataResponse = new MetadataResponse();
        Mockito.when(restTemplate.getForObject("https://www.enacramurl.com/sequence/badId/metadata", MetadataResponse.class))
                .thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        MetadataResponse actual = fixture.getMetadata("badId");

        assertEquals("ERROR: id badId not found\n", errContent.toString());
        assertEquals(actual, metadataResponse);
    }
}
