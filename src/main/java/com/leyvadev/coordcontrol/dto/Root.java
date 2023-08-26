package com.leyvadev.coordcontrol.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Data
public class Root{
    @JsonProperty("plus_code")
    private PlusCode plusCode;
    private ArrayList<Result> results;
    private String status;
}
