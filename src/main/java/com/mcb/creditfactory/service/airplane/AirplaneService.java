package com.mcb.creditfactory.service.airplane;

import com.mcb.creditfactory.dto.AirplaneDto;
import com.mcb.creditfactory.dto.AssessedValueDto;
import com.mcb.creditfactory.model.Airplane;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AirplaneService {
    boolean approve(AirplaneDto airplaneDto);
    Airplane save(Airplane airplane);
    Optional<Airplane> load(Long id);
    Airplane fromDto(AirplaneDto airplaneDto);
    AirplaneDto toDTO(Airplane airplane);
    Long getId(Airplane airplane);
    List<Airplane> airplaneList();
    Airplane addValue(Long id, AssessedValueDto valueDto);
    Airplane findById(Long id);
}
