package com.mcb.creditfactory.model;

import com.mcb.creditfactory.external.CollateralType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ASSESSED_VALUE")
public class AssessedValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "collateral_id")
    private Long collateralId;

    @Column(name = "assessed_cost")
    private BigDecimal value;

    @Column(name = "date_time")
    private LocalDateTime dateTime;
}
