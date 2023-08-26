package com.leyvadev.coordcontrol.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.util.ArrayList;
@Data
public class AddressComponent{
    @JsonProperty("long_name")
    private String longName;
    @JsonProperty("short_name")
    private String shortName;
    private ArrayList<String> types;
}