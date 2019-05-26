package com.example.materialmanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "raw_stock")
@EntityListeners(AuditingEntityListener.class)
public class rawStock {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String description;


    @Getter
    @Setter
    private String quantity;

    @Getter
    @Setter
    private String reorderLevel;

    @Getter
    @Setter
    private String reorderQuantity;

    @Getter
    @Setter
    private String leadTime;

    @ManyToOne
    @JoinColumn(name="supplier_id",referencedColumnName = "id")
    @Getter @Setter Supplier supplier;

    @OneToMany(mappedBy = "rawStock")
    @Getter @Setter List<rawStockProduct> rawStockProduct;

    @OneToMany(mappedBy = "rawStock")
    @Getter @Setter List<enquiryStockDetails> enquiryStockDetails;
}