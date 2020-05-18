package com.mcb.creditfactory.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValue;

import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CarDto.class),
        @JsonSubTypes.Type(value = AirplaneDto.class)
})

public interface Collateral {
    Long getId();
    CollateralType getType();
    Short getYear();
    List<AssessedValue> getValues();

}
