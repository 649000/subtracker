package com.subtracker.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Currency;
import java.util.UUID;

@Data
@Entity
@Table
@EntityListeners(AuditingEntityListener.class)
@JsonApiResource(type = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonApiId
    @NotNull
    private UUID subscriptionID;

    @CreatedDate
    @JsonProperty
    @NotNull
    @Column(nullable = false)
    private LocalDate createdDate;

    @LastModifiedDate
    @JsonProperty
    @Column
    private LocalDate modifiedDate;

    @JsonProperty
    @NotNull
    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @JsonProperty
    @NotNull
    @Column(nullable = false)
    private Currency currency;

    @JsonProperty
    @NotNull
    @PositiveOrZero
    @Digits(integer = 10, fraction = 2)
    @Column
    private BigDecimal amount;

    //In days: 1 = 1 day, 30 = 1 month
    @JsonProperty
    @NotNull
    @PositiveOrZero
    @Column(nullable = false)
    private int cycle;

    @JsonProperty
    @Column
    private String information;

}
