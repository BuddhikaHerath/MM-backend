package com.example.materialmanagement.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;


@Entity
@Table(name = "contact_details")
@EntityListeners(AuditingEntityListener.class)
public class contactDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private String contactNo;

    @Getter
    @Setter
    private String email;

    @ManyToOne
    @JoinColumn(name="supplier_id",referencedColumnName = "id")
    @Getter @Setter Supplier supplier;
}