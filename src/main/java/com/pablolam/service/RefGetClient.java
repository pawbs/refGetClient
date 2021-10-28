package com.pablolam.service;

import com.pablolam.model.Metadata;
import com.pablolam.model.MetadataResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

public class RefGetClient {

    @Autowired
    private RestTemplate restTemplate;

    public MetadataResponse getMetadata(String id) {
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", id);

        String url = UriComponentsBuilder
                .newInstance()
                .scheme("https")
                .host("www.ebi.ac.uk/ena/cram")
                .path("sequence")
                .pathSegment("{id}")
                .path("metadata")
                .buildAndExpand(uriVariables)
                .toUriString();

        return restTemplate.getForObject(url, MetadataResponse.class);
    }
}
