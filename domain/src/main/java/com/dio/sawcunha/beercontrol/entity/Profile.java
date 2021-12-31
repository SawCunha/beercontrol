package com.dio.sawcunha.beercontrol.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "BIC_PROFILE")
public class Profile {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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
