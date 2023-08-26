package com.leyvadev.coordcontrol.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class Geometry{
    private Location location;
    @JsonProperty("location_type")
    private String locationType;
    private Viewport viewport;
    private Bounds bounds;
}