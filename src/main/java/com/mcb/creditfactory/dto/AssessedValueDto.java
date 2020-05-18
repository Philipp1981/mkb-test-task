package com.mcb.creditfactory.dto;

import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessedValueDto {

    private Long id;
    private Long collateralId;
    private BigDecimal value;
    private LocalDateTime dateTime;

}