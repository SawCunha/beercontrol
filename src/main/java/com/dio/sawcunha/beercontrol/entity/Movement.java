package com.dio.sawcunha.beercontrol.entity;

import com.dio.sawcunha.beercontrol.enums.eMovementStatus;
import com.dio.sawcunha.beercontrol.enums.eMovementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MOVEMENT", indexes = {
        @Index(name = "IX_MOVENT", columnList = "MOVEMENT_TYPE, MOVEMENT_STATUS, WAREHOUSE_ID"),
        @Index(name = "IX_MOVEMENT_TYPE_MOVENT", columnList = "MOVEMENT_TYPE"),
        @Index(name = "IX_MOVEMENT_STATUS_MOVENT", columnList = "MOVEMENT_STATUS"),
        @Index(name = "IX_WAREHOUSE_ID_MOVENT", columnList = "WAREHOUSE_ID")
})
@Entity
public class Movement {

    @Id
    @SequenceGenerator(name="seq_movement",sequenceName="seq_movement_id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_movement")
    @Column(name = "MOVEMENT_ID")
    private Long id;

    @Column(name = "IDENTIFIER", nullable = false, unique = true)
    private UUID identifier;

    @Enumerated(EnumType.STRING)
    @Column(name = "MOVEMENT_TYPE", nullable = false)
    private eMovementType movementType;

    @Enumerated(EnumType.STRING)
    @Column(name = "MOVEMENT_STATUS", nullable = false)
    private eMovementStatus movementStatus;

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_WAREHOUSE_MOVEMENT"))
    private Warehouse warehouse;

    @Column(name = "QUANTITY", nullable = false)
    private Long quantity;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime created;

    @Column(name = "UPDATED_DATE", nullable = false)
    private LocalDateTime updated;

    @Column(name = "CONFIRMATION_DATE")
    private LocalDateTime confirmation;

    @Column(name = "AUTOMATIC", nullable = false)
    private boolean automatic;

}
