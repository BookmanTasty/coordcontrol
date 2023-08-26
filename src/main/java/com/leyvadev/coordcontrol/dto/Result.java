package com.leyvadev.coordcontrol.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
@Data
public class Result {
    @JsonProperty("address_components")
    private ArrayList<AddressComponent> addressComponents;
    @JsonProperty("formatted_address")
    private String formattedAddress;
    private Geometry geometry;
    @JsonProperty("place_id")
    private String placeId;
    @JsonProperty("plus_code")
    private PlusCode plusCode;
    private ArrayList<String> types;
}
