package com.leyvadev.coordcontrol.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Data
public class Location{
    private BigDecimal lat;
    private BigDecimal lng;
}