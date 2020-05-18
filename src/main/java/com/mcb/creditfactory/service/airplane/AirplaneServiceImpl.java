package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.AssessedValueDto;
import com.mcb.creditfactory.external.ExternalApproveService;
import com.mcb.creditfactory.model.Airplane;
import com.mcb.creditfactory.model.AssessedValue;
import com.mcb.creditfactory.repository.AirplaneRepository;
import com.mcb.creditfactory.service.AssessedValueAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {
    @Autowired
    private ExternalApproveService approveService;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private AssessedValueAdapter assessedValueAdapter;

    @Override
    public boolean approve(AirplaneDto airplaneDto) {
        return approveService.approve(new AirplaneAdapter(airplaneDto)) == 0;
    }

    @Override
    public Airplane save(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> load(Long id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane fromDto(AirplaneDto airplaneDto) {
        return new Airplane(
                airplaneDto.getId(),
                airplaneDto.getBrand(),
                airplaneDto.getModel(),
                airplaneDto.getManufacturer(),
                airplaneDto.getYear(),
                airplaneDto.getFuelCapacity(),
                airplaneDto.getSeats(),
                airplaneDto.getValues()
        );
    }

    @Override
    public AirplaneDto toDTO(Airplane airplane) {
        return new AirplaneDto(
                airplane.getId(),
                airplane.getBrand(),
                airplane.getModel(),
                airplane.getManufacturer(),
                airplane.getYear(),
                airplane.getFuelCapacity(),
                airplane.getSeats(),
                airplane.getValues()
        );
    }

    @Override
    public Long getId(Airplane airplane) {
        return airplane.getId();
    }

    @Override
    public List<Airplane> airplaneList(){return (List<Airplane>) airplaneRepository.findAll();}

    @Override
    public Airplane addValue(Long id, AssessedValueDto valueDto) {
        Airplane airplane = airplaneRepository.findById(id).get();
        AssessedValue assessedValue = assessedValueAdapter.fromDto(valueDto);
        airplane.getValues().add(assessedValue);
        return airplaneRepository.save(airplane);
    }

    public Airplane findById(Long id){
        return airplaneRepository.findById(id).get();
    }
}
