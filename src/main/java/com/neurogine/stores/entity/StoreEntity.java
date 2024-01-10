package com.neurogine.stores.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Stores_table")
@Getter
@Setter
public class StoreEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    private String name;
    private String emailAddress;
    private String description;
    private String imagePath;
    private String address;
    private String geoLocation;
    private String category;
}
