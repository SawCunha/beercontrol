package com.dio.sawcunha.beercontrol.entity;

import com.dio.sawcunha.beercontrol.enums.eSex;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "BIC_PERSON")
public class Person {

    @Id
    @Column(name = "PERSON_ID")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_beer")
    private Long id;

    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "BIRTHDAY")
    private LocalDate birthday;
    @Column(name = "TAX_IDENTIFIER", unique = true)
    private String cpf;
    @Column(name = "GENDER")
    @Enumerated(value = EnumType.STRING)
    private eSex sex;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Address> addresses;
    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Phone> phones;
}
