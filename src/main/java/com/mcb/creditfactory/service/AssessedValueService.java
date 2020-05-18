package com.mcb.creditfactory.service;


import com.mcb.creditfactory.external.CollateralType;
import com.mcb.creditfactory.model.AssessedValue;
import com.mcb.creditfactory.repository.AssessedValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessedValueService {

    private AssessedValueRepository assessedValueRepository;

    @Autowired
    public void setAssessedValueRepository(AssessedValueRepository assessedValueRepository) {
        this.assessedValueRepository = assessedValueRepository;
    }

    public List<AssessedValue> findByCollId(Long collateralId) {
        return assessedValueRepository.findAllByCollateralId(collateralId);
    }

    public List<AssessedValue> findAll(){
        return (List<AssessedValue>) assessedValueRepository.findAll();
    }

   public AssessedValue findFirst(Long collateralId) {
      return assessedValueRepository.findFirstByCollateralIdOrderByDateTimeDesc(collateralId);
   }

    public AssessedValue save(AssessedValue assessedValue) {
        return assessedValueRepository.save(assessedValue);
    }


}
