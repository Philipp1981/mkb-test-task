package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.*;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.AssessedValue;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.service.airplane.AirplaneService;
import com.mcb.creditfactory.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// TODO: reimplement this
@Service
public class CollateralService {
    @Autowired
    private CarService carService;

    @Autowired
    private AirplaneService airplaneService;

    @Autowired
    private AssessedValueAdapter assessedValueAdapter;



    @SuppressWarnings("ConstantConditions")
    public Long saveCollateral(Collateral object) {
        if (object instanceof CarDto) {
            CarDto car = (CarDto) object;
            boolean approved = carService.approve(car);
            if (!approved) {
                return null;
            }
            return Optional.of(car).map(carService::fromDto).map(carService::save).map(carService::getId).orElse(null);
        }
        if (object instanceof AirplaneDto) {
            AirplaneDto airplaneDto = (AirplaneDto) object;
            boolean approved = airplaneService.approve(airplaneDto);
            if (!approved) {
                return null;
            }
            return Optional.of(airplaneDto).map(airplaneService::fromDto).map(airplaneService::save).map(airplaneService::getId).orElse(null);
        }
        return null;
    }

    public Collateral getInfo(Collateral object) {
        if (object instanceof CarDto) {
            return Optional.of((CarDto) object)
                    .map(carService::fromDto)
                    .map(carService::getId)
                    .flatMap(carService::load)
                    .map(carService::toDTO)
                    .orElse(null);
        }else if (object instanceof AirplaneDto) {
            return Optional.of((AirplaneDto) object).map(airplaneService::fromDto).map(airplaneService::getId).flatMap(airplaneService::load).map(airplaneService::toDTO).orElse(null);
        }
        else return null;
    }


    public Collateral addValue(Long collateralId, AssessedValueDto valueDto) {
        Car car=carService.findById(collateralId);
        Airplane airplane=airplaneService.findById(collateralId);
        if (car!=null) {
            AssessedValue assessedValue = assessedValueAdapter.fromDto(valueDto);
            car.getValues().add(assessedValue);
            return (Collateral) carService.save(car);
        }
        if (airplane!=null) {
            AssessedValue assessedValue = assessedValueAdapter.fromDto(valueDto);
            airplane.getValues().add(assessedValue);
            return (Collateral) airplaneService.save(airplane);
        }
        return null;
    }
}





