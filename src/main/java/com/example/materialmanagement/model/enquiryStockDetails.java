package com.example.materialmanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "enquiry_stock_details")
@EntityListeners(AuditingEntityListener.class)
public class enquiryStockDetails {

  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;


    @Getter
    @Setter
    private String quantity;

    @ManyToOne
    @JoinColumn(name="enquiry_id",referencedColumnName = "id")
    @Getter @Setter enquiry enquiry;

    @ManyToOne
    @JoinColumn(name="stock_details_id",referencedColumnName = "id")
    @Getter @Setter rawStock rawStock;
}