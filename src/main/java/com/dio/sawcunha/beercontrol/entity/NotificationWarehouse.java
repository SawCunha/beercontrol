package com.dio.sawcunha.beercontrol.entity;

import com.dio.sawcunha.beercontrol.enums.eNotificationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "NOTIFICATION_WAREHOUSE", indexes = {
        @Index(name = "IX_NOTIFICATION_WAREHOUSE", columnList = "NOTIFICATION_STATUS, WAREHOUSE_ID"),
        @Index(name = "IX_WAREHOUSE_ID_NW", columnList = "WAREHOUSE_ID"),
        @Index(name = "IX_NOTIFICATION_STATUS_NW", columnList = "NOTIFICATION_STATUS")
})
@Entity
public class NotificationWarehouse {

    @Id
    @SequenceGenerator(name="seq_notification_warehouse",sequenceName="seq_notification_warehouse_id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_notification_warehouse")
    @Column(name = "NOTIFICATION_WAREHOUSE_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_WAREHOUSE_NW"))
    private Warehouse warehouse;

    @Column(name = "NOTIFICATION_STATUS")
    @Enumerated(EnumType.STRING)
    private eNotificationStatus notificationStatus;

    @Column(name = "MESSAGE")
    private String message;

    @Column(name = "CREATED_DATE")
    private LocalDateTime created;

    @Column(name = "UPDATE_DATE")
    private LocalDateTime update;

}
