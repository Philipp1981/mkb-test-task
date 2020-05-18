package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.AssessedValueDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CarService {
    boolean approve(CarDto dto);
    Car save(Car car);
    Optional<Car> load(Long id);
    Car fromDto(CarDto dto);
    CarDto toDTO(Car car);
    Long getId(Car car);
    List<Car> carList();
    Car addValue(Long id, AssessedValueDto valueDto);
    Car findById(Long id);
}
