package com.dio.sawcunha.beercontrol.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BIC_WAREHOUSE", indexes = {
        @Index(name = "IX_BEER_WAREHOUSE", columnList = "BEER_ID")
})
@Entity
public class Warehouse {

    @Id
    @SequenceGenerator(name="seq_warehouse",sequenceName="seq_warehouse_id")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="seq_warehouse")
    @Column(name = "WAREHOUSE_ID")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BEER_ID", nullable = false, foreignKey = @ForeignKey(name = "FK_BEER_WAREHOUSE"), unique = true)
    private Beer beer;

    @Column(name = "QUANTITY_MIN", nullable = false)
    private Long quantityMin;

    @Column(name = "QUANTITY_MAX_EXPECTD", nullable = false)
    private Long quantityMaxExpectd;

    @Column(name = "QUANTITY", nullable = false)
    private Long quantity;

    @Column(name = "UPDATE_DATE", nullable = false)
    private LocalDateTime update;

}
