package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.service.AssessedValueService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;


@NoArgsConstructor

public class CarAdapter implements CollateralObject {
    private CarDto carDto;

    @Autowired
    private AssessedValueService assessedValueService;

    @Override
    public BigDecimal getValue() {
        return carDto.getValues().get(carDto.getValues().size()).getValue();
    }

    @Override
    public Short getYear() {
        return carDto.getYear();
    }

    @Override
    public LocalDate getDate() {
        // Для автомобилей дата оценки не используется, поэтому всегда берем текущую
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return CollateralType.CAR;
    }

    public CarAdapter(CarDto carDto){
        this.carDto=carDto;
    }
}
