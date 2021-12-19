package com.dio.sawcunha.beercontrol.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "BIC_PROFILE")
public class Profile {

    @Id
    @SequenceGenerator(name="seq_beer",sequenceName="seq_beer_id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_beer")
    @Column(name = "PROFILE_ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "ACTIVE")
    private boolean active;

    @Column(name = "PERMISSIONS")
    @ManyToMany
    @JoinTable(name="BIC_PROFILE_PERMISSIONS", joinColumns=
            {@JoinColumn(name="PROFILE_ID")}, inverseJoinColumns=
            {@JoinColumn(name="PERMISSIONS_ID")})
    private Set<Permissions> permissions;
}
