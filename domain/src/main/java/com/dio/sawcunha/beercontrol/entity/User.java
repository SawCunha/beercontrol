package com.dio.sawcunha.beercontrol.entity;


import com.dio.sawcunha.beercontrol.enums.eUserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BIC_USER")
@Entity
public class User {

    @Id
    @SequenceGenerator(name="seq_beer",sequenceName="seq_beer_id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_beer")
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

    @Column(name = "USER_STATUS")
    private eUserStatus userStatus;

    @Column(name = "BLOCKED")
    private boolean blocked;

    @Column(name = "NUMBER_ATTEMPTS")
    private int numberAttempts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSON_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_PERSON"))
    private Person person;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROFILE_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_USER_PROFILE"))
    private Profile profile;

}
