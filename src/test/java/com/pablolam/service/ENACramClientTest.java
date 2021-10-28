package com.pablolam.service;

import com.pablolam.model.MetadataResponse;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

public class ENACramClientTest {

    @InjectMocks
    private ENACramClient fixture;

    @Mock
    private RestTemplate restTemplate;

    @Before
    public void setup() {
        fixture = new ENACramClient();
        MockitoAnnotations.openMocks(this);
        ReflectionTestUtils.setField(fixture, "enaCramUrl", "www.enacramurl.com");
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
}
