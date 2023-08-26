package com.leyvadev.coordcontrol.model;

import com.leyvadev.coordcontrol.dto.AddressComponent;
import com.leyvadev.coordcontrol.dto.Result;
import io.hypersistence.utils.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "points_of_interest")
@Getter
@Setter
public class PointOfInterest {
    @Id
    @GeneratedValue(generator = "uuid2")
    private UUID id;
    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "lat")
    private BigDecimal lat;
    @Column(name = "lng")
    private BigDecimal lng;
    @Column(name = "address")
    private String address;
    @Column(name = "formatted_address")
    @Type(JsonBinaryType.class)
    private ArrayList<AddressComponent> addressComponents = new ArrayList<>();
    @Column(name = "optional_address")
    @Type(JsonBinaryType.class)
    private List<Result> optionalAddress = new ArrayList<>();
}
