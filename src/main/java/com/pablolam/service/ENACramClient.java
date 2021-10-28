package com.pablolam.service;

import com.pablolam.model.MetadataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

public class ENACramClient {

    public static final String PATH_SEGMENT_ID = "id";
    public static final String PATH_SEGMENT_ID_VARIABLE = "{id}";
    public static final String HTTPS_SCHEME = "https";
    public static final String SEQUENCE_PATH = "sequence";
    public static final String METADATA_PATH = "metadata";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${ws.cram.url}")
    private String enaCramUrl;

    public MetadataResponse getMetadata(String id) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put(PATH_SEGMENT_ID, id);

        String url = UriComponentsBuilder
                .newInstance()
                .scheme(HTTPS_SCHEME)
                .host(enaCramUrl)
                .path(SEQUENCE_PATH)
                .pathSegment(PATH_SEGMENT_ID_VARIABLE)
                .path(METADATA_PATH)
                .buildAndExpand(uriVariables)
                .toUriString();

        return restTemplate.getForObject(url, MetadataResponse.class);
    }
}
