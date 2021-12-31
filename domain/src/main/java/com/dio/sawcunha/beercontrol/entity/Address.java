package com.dio.sawcunha.beercontrol.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "BIC_ADDRESS")
public class Address {

    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", nullable = false)
    private Person person;

    @Column(name = "ZIP_CODE")
    private String zipCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "ADDRESS_NAME")
    private String addressName;
    @Column(name = "STATE")
    private String state;
    @Column(name = "STREET")
    private String street;
    @Column(name = "BLOCK")
    private String block;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "NUMBER")
    private Integer number;
    @Column(name = "COMPLEMENT")
    private String complement;
    @Column(name = "REFERENCE")
    private String reference;

}
