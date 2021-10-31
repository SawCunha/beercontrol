package com.dio.sawcunha.beercontrol.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "BIC_Phone")
public class Phone {

    @Id
    @Column(name = "PHONE_ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_beer")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_Person_P"))
    private Person person;

    @Column(name = "PREFIX_INTERNATTIONAL")
    private Integer prefixInternattional;
    @Column(name = "PREFIX_NATIONA")
    private Integer prefixNational;
    @Column(name = "NUMBER_PHONE")
    private String numberPhone;

}
