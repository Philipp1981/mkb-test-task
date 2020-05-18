package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.AssessedValueDto;
import com.mcb.creditfactory.model.AssessedValue;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AssessedValueAdapter {

    public AssessedValue fromDto(AssessedValueDto assessedValueDto) {
        return new AssessedValue(
                assessedValueDto.getId(),
                assessedValueDto.getCollateralId(),
                assessedValueDto.getValue(),
                assessedValueDto.getDateTime()
        );
    }

    public AssessedValueDto toDto(AssessedValue assessedValue) {
        return new AssessedValueDto(
                assessedValue.getId(),
                assessedValue.getCollateralId(),
                assessedValue.getValue(),
                assessedValue.getDateTime()
        );
    }

    public List<AssessedValue> fromDtoList(List<AssessedValueDto> assessedValueDtoList) {
        List<AssessedValue> assessedValueList = new ArrayList<>();
        for (AssessedValueDto dto : assessedValueDtoList) {
            assessedValueList.add(fromDto(dto));
        }
        return assessedValueList;
    }

    public List<AssessedValueDto> toDtoList(List<AssessedValue> assessedValuelList) {
        List<AssessedValueDto> assessedValueDtoList = new ArrayList<>();
        for (AssessedValue asv : assessedValuelList) {
            assessedValueDtoList.add(toDto(asv));
        }
        return assessedValueDtoList;
    }
}
