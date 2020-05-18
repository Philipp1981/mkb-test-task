package com.mcb.creditfactory.service.car;

import com.mcb.creditfactory.dto.AssessedValueDto;
import com.mcb.creditfactory.dto.CarDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.AssessedValue;
import com.mcb.creditfactory.model.Car;
import com.mcb.creditfactory.repository.CarRepository;
import com.mcb.creditfactory.service.AssessedValueAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private AssessedValueAdapter assessedValueAdapter;

    @Override
    public boolean approve(CarDto carDto) {
        return approveService.approve(new CarAdapter(carDto)) == 0;
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> load(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public Car fromDto(CarDto carDto) {
        return new Car(
                carDto.getId(),
                carDto.getBrand(),
                carDto.getModel(),
                carDto.getPower(),
                carDto.getYear(),
                carDto.getValues()
        );
    }

    @Override
    public CarDto toDTO(Car car) {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModel(),
                car.getPower(),
                car.getYear(),
                car.getValues()
        );
    }

    @Override
    public Long getId(Car car) {
        return car.getId();
    }

    @Override
    public List<Car> carList(){return (List<Car>) carRepository.findAll();}


    @Override
    public Car addValue(Long id, AssessedValueDto valueDto) {
        Car car = carRepository.findById(id).get();
        AssessedValue assessedValue = assessedValueAdapter.fromDto(valueDto);
        car.getValues().add(assessedValue);
        return carRepository.save(car);
    }

    @Override
    public Car findById(Long id){
        return carRepository.findById(id).get();
    }
}
