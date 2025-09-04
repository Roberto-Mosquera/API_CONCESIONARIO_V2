package org.example.api_concesionaria.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
import java.time.LocalTime;

import java.util.UUID;

@Entity
@Table(name = "sold_car")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SoldCarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_sold_car")
    private UUID id;

    @Column(nullable = false,name = "sold_date")
    private LocalDate soldDate;

    @Column(nullable = false,name = "sold_time")
    private LocalTime soldTime;

    @Column(nullable = false,name = "amount")
    private Double amount;

    @ManyToOne(
            cascade = {
                    CascadeType.REFRESH,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "id_car",
            referencedColumnName = "id_car"
    )
    private CarEntity car;

    @ManyToOne(
            cascade = {
                    CascadeType.REFRESH,
                    CascadeType.MERGE
            },
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "id_customer",
            referencedColumnName = "id_customer"
    )
    private CustomerEntity customer;
}
