package com.dio.sawcunha.beercontrol.entity;

import com.dio.sawcunha.beercontrol.enums.eLevelRoleType;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Table(name = "BIC_PERMISSIONS")
@Entity
public class Permissions {

    @Id
    @Column(name = "PERMISSIONS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PERMISSION")
    private String permission;

    @Column(name = "LEVEL_ROLE_TYPE")
    @Enumerated(value = EnumType.STRING)
    private eLevelRoleType levelRoleType;

    @Override
    public String toString() {
        return String.format("%s:%s",permission,levelRoleType);
    }
}
