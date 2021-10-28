package com.pablolam.service;

import com.pablolam.model.MetadataResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;


public class RefGetClientTest {

    @InjectMocks
    private RefGetClient fixture;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setup() {
        fixture = new RefGetClient();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void tc01_givenId_getMetadata_returnsMetadata() {
        MetadataResponse metadataResponse = new MetadataResponse();
        Mockito.when(restTemplate.getForObject("https://www.ebi.ac.uk/ena/cram/sequence/id/metadata", MetadataResponse.class))
                .thenReturn(metadataResponse);

        MetadataResponse actual = fixture.getMetadata("id");
        assertEquals(actual, metadataResponse);
    }
}
