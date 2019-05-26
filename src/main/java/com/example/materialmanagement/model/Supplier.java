package com.example.materialmanagement.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Supplier")
@EntityListeners(AuditingEntityListener.class)

public class Supplier implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @Getter @Setter private String firstName;

    @Getter @Setter private String lastName;

    @Getter @Setter private String trackingName;

    @Getter @Setter private String status;

    @OneToMany(mappedBy = "supplier")
    @Getter @Setter private List<address> address;

    @OneToMany(mappedBy = "supplier")
    @Getter @Setter private List<rawStock> rawStocks;

    @OneToMany(mappedBy = "supplier")
    @Getter @Setter private List<contactDetails> contactDetails;

    @OneToMany(mappedBy = "supplier")
    @Getter @Setter private List<enquiry> enquiry;

    public Supplier() {
    }
}
