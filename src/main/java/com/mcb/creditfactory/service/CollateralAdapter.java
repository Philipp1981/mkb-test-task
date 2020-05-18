package com.mcb.creditfactory.service;

import com.mcb.creditfactory.dto.Collateral;
import com.mcb.creditfactory.external.CollateralObject;
import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
public class CollateralAdapter implements CollateralObject {

    private Collateral collateral;

    @Override
    public BigDecimal getValue() {
        return collateral.getValues().get(collateral.getValues().size()).getValue();
    }

    @Override
    public Short getYear() {
        return collateral.getYear();
    }

    @Override
    public LocalDate getDate() {
        return LocalDate.now();
    }

    @Override
    public CollateralType getType() {
        return collateral.getType();
    }

}
