package com.pablolam.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.cli.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class RefGetService {

    public static final String ID_OPT = "i";
    public static final String ID_LONG_OPT = "id";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ENACramClient enaCramClient;

    @Autowired
    private HelpFormatter helpFormatter;

    @Value("${id.arg.description}")
    private String idArgDescription;

    public void getMetaData(String... args) {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        Options options = new Options();
        Option id = new Option(ID_OPT, ID_LONG_OPT, true, idArgDescription);
        id.setRequired(true);
        options.addOption(id);

        try {
            cmd = parser.parse(options, args);
            System.out.println(objectMapper.writeValueAsString(enaCramClient.getMetadata(cmd.getOptionValue("id"))));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            helpFormatter.printHelp("RefGetClient", options);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
