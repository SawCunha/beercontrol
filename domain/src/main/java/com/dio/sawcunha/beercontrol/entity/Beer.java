package com.dio.sawcunha.beercontrol.entity;

import com.dio.sawcunha.beercontrol.enums.eBeerType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BIC_BEER")
@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "BEER_ID")
    private Long id;

    @Column(name = "IDENTIFIER", unique = true, nullable = false)
    private String identifier;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @Lob
    @Column(name = "IMAGE", unique = false, nullable = false, length = 1000000)
    private byte[] image;

    @Column(name = "BRAND", nullable = false)
    private String brand;

    @Enumerated(EnumType.STRING)
    @Column(name = "BEER_TYPE", nullable = false)
    private eBeerType beerType;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime created;

}
