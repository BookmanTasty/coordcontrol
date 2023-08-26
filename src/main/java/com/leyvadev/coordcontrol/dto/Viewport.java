package com.leyvadev.coordcontrol.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class Viewport{
    private Location northeast;
    private Location southwest;
}