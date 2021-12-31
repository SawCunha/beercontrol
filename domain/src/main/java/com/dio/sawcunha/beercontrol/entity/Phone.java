package com.dio.sawcunha.beercontrol.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "BIC_Phone")
public class Phone {

    @Id
    @Column(name = "PHONE_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;

    @Column(name = "PREFIX_INTERNATTIONAL")
    private Integer prefixInternattional;
    @Column(name = "PREFIX_NATIONA")
    private Integer prefixNational;
    @Column(name = "NUMBER_PHONE")
    private String numberPhone;

}
