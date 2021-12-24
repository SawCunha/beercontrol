package com.dio.sawcunha.beercontrol.entity;

import com.dio.sawcunha.beercontrol.enums.eNotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BIC_NOTIFICATION_WAREHOUSE", indexes = {
        @Index(name = "IX_NOTIFICATION_WAREHOUSE", columnList = "NOTIFICATION_STATUS, WAREHOUSE_ID"),
        @Index(name = "IX_WAREHOUSE_ID_NW", columnList = "WAREHOUSE_ID"),
        @Index(name = "IX_MOVEMENT_ID_NW", columnList = "MOVEMENT_ID"),
        @Index(name = "IX_NOTIFICATION_STATUS_NW", columnList = "NOTIFICATION_STATUS")
})
@Entity
public class NotificationWarehouse {

    @Id
    @SequenceGenerator(name="seq_notification_warehouse",sequenceName="seq_notification_warehouse_id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_notification_warehouse")
    @Column(name = "NOTIFICATION_WAREHOUSE_ID", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_WAREHOUSE_NW"))
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "MOVEMENT_ID", foreignKey = @ForeignKey(name = "FK_MOVEMENT_NW"))
    private Movement movement;

    @Column(name = "NOTIFICATION_STATUS", nullable = false)
    @Enumerated(EnumType.STRING)
    private eNotificationStatus notificationStatus;

    @Column(name = "MESSAGE", nullable = false)
    private String message;

    @Column(name = "CODE")
    private Integer code;

    @Column(name = "SUCCESS")
    private boolean success;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime created;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime update;

}
