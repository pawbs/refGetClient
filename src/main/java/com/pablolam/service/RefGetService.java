package com.pablolam.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.cli.*;
import org.springframework.beans.factory.annotation.Autowired;

public class RefGetService {

    public static final String ID_OPT = "i";
    public static final String ID_LONG_OPT = "id";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ENACramClient enaCramClient;

    public void getMetaData(String... args) {
        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        Options options = new Options();
        Option id = new Option(ID_OPT, ID_LONG_OPT, true, "A string specifying an identifier to retrieve metadata for using one of the defined checksum algorithms or a server-specific checksum algorithm.");
        id.setRequired(true);
        options.addOption(id);

        try {
            cmd = parser.parse(options, args);
            System.out.println(objectMapper.writeValueAsString(enaCramClient.getMetadata(cmd.getOptionValue("id"))));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("RefGetClient", options);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
