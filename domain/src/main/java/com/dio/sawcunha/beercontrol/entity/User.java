package com.dio.sawcunha.beercontrol.entity;


import com.dio.sawcunha.beercontrol.enums.eUserStatus;
import com.dio.sawcunha.beercontrol.enums.eUserType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BIC_USER")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "FIRST_ACCESS")
    private boolean firstAccess;

    @Column(name = "CREATED")
    private LocalDateTime created;

    @Column(name = "LAST_ACESS")
    private LocalDateTime lastAcess;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_STATUS")
    private eUserStatus userStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_TYPE")
    private eUserType userType;

    @Column(name = "BLOCKED")
    private boolean blocked;

    @Column(name = "NUMBER_ATTEMPTS")
    private int numberAttempts;

    @Column(name = "IDENTIFIER")
    private UUID identifier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID")
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFILE_ID", nullable = false)
    private Profile profile;

}
