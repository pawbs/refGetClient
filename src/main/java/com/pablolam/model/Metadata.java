package com.pablolam.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Metadata {
    private String md5;
    private String TRUNC512;
    private Integer length;
    private ArrayList<Alias> aliases;
}
