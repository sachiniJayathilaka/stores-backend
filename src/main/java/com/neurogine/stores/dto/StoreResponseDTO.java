package com.neurogine.stores.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreResponseDTO {
    private Long id;
    private String name;
    private String emailAddress;
    private String description;
    private String imagePath;
    private String address;
    private String geoLocation;
    private String category;
}
