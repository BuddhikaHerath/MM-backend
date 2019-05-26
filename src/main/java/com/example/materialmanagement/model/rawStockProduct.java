package com.example.materialmanagement.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "raw_stock_product")
@EntityListeners(AuditingEntityListener.class)
public class rawStockProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter @Setter private int quantity;

    @ManyToOne
    @JoinColumn(name="stock_details_id",referencedColumnName = "id")
    @Getter @Setter rawStock rawStock;

    @ManyToOne
    @JoinColumn(name="product_id",referencedColumnName = "id")
    @Getter @Setter product product;

    public rawStockProduct() {
    }
}
