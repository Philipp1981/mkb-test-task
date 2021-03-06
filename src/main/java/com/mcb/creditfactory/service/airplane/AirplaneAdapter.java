package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@NoArgsConstructor

public class AirplaneAdapter implements CollateralObject {
    private AirplaneDto airplaneDto;

    @Override
    public BigDecimal getValue() {
        return airplaneDto.getValues().get(airplaneDto.getValues().size()).getValue();
    }

    @Override
    public Short getYear() {
        return airplaneDto.getYear();
    }

    @Override
    public LocalDate getDate() {
        // Для самолетов дата оценки не используется, поэтому всегда берем текущую
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.AIRPLANE;
    }

    public AirplaneAdapter(AirplaneDto airplaneDto){
        this.airplaneDto=airplaneDto;
    }
}
