package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeName("airplane")
public class AirplaneDto implements Collateral {
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Short year;
    private Integer fuelCapacity;
    private Integer seats;
    private List<AssessedValue> values;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Short getYear() {
        return year;
    }

    @Override
    public List<AssessedValue> getValues() {
        return values;
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }
}