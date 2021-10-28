package com.pablolam.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pablolam.model.Metadata;
import com.pablolam.model.MetadataResponse;
import org.apache.commons.cli.HelpFormatter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

public class RefGetServiceTest {

    @InjectMocks
    private RefGetService fixture;

    @Mock
    private ENACramClient enaCramClient;

    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private HelpFormatter helpFormatter;

    @Before
    public void setup() {
        fixture = new RefGetService();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void tc01_givenArgs_getMetadata_callsENACramClient() throws JsonProcessingException {
        // INPUT
        String id = "someId";
        Metadata metadata = new Metadata();
        metadata.setMd5(id);
        MetadataResponse metadataResponse = new MetadataResponse();
        metadataResponse.setMetadata(metadata);

        // MOCK
        Mockito.when(enaCramClient.getMetadata(id)).thenReturn(metadataResponse);

        // EXECUTION
        fixture.getMetaData("--id", id);

        // OUTPUT
        verify(objectMapper).writeValueAsString(metadataResponse);
        verifyNoInteractions(helpFormatter);
    }

    @Test
    public void tc02_badArgs_getMetadata_returnsHelp() {
        // EXECUTION
        fixture.getMetaData();

        // OUTPUT
        verify(helpFormatter).printHelp(eq("RefGetClient"), any());
        verifyNoInteractions(objectMapper);
    }
}
