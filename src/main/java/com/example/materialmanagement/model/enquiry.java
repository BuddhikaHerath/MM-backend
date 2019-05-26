package com.example.materialmanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "enquiry")
@EntityListeners(AuditingEntityListener.class)
public class enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String status;

    @Getter
    @Setter
    private String placedDate;


    @Getter
    @Setter
    private String deliveryDate;

    @Getter
    @Setter
    private String completeDate;

    @ManyToOne
    @JoinColumn(name="supplier_id",referencedColumnName = "id")
    @Getter @Setter Supplier supplier;

    @OneToMany
    @Getter @Setter List<enquiryStockDetails> enquiryStockDetails;

}