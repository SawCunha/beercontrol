package com.dio.sawcunha.beercontrol.entity;

import com.dio.sawcunha.beercontrol.enums.eBeerType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BEER")
@Entity
public class Beer {

    @Id
    @SequenceGenerator(name="seq_beer",sequenceName="seq_beer_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_beer")
    @Column(name = "BEER_ID")
    private Long id;

    @Column(name = "IDENTIFIER", unique = true, nullable = false)
    private String identifier;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Column(name = "BRAND", nullable = false)
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "BEER_TYPE", nullable = false)
    private eBeerType beerType;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime created;

}
