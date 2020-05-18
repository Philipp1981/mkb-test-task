package com.mcb.creditfactory.repository;

import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssessedValueRepository extends CrudRepository<AssessedValue, Long> {

    List<AssessedValue> findAllByCollateralId (Long collateralId);
    AssessedValue findFirstByCollateralIdOrderByDateTimeDesc (Long collateralId);

 }
