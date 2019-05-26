package com.example.materialmanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
@Entity
@Table(name = "address")
@EntityListeners(AuditingEntityListener.class)


public class address{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String address;

    @Getter
    @Setter
    private String city;


    @Getter
    @Setter
    private String province;


    @Getter
    @Setter
    private String zip_code;


    @Getter
    @Setter
    private String country;


    @Getter
    @Setter
    private String type;

    @ManyToOne
    @JoinColumn(name="supplier_id",referencedColumnName = "id")
    @Getter @Setter Supplier supplier;


}
