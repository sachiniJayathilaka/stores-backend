package com.neurogine.stores.service;

import com.neurogine.stores.dto.StoreFilterDTO;
import com.neurogine.stores.dto.StoreResponseDTO;
import com.neurogine.stores.entity.StoreEntity;
import com.neurogine.stores.respository.StoreRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoreServiceImpl implements StoreService{
    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<StoreResponseDTO> getAllStores(StoreFilterDTO storeFilterDTO) {
        List<StoreResponseDTO> storeResponseDTOS = new ArrayList<>();
        Pageable pageable = PageRequest.of(0, 10);
        try {
            List<StoreEntity> storeEntities =  storeRepository.getStoreEntitieByNameLikeIgnoreCaseAndDescriptionLikeIgnoreCase(storeFilterDTO.getName(), storeFilterDTO.getDescription(), pageable);
            if (!storeEntities.isEmpty()) {
                storeResponseDTOS =  mapEntitiesToDTOs(storeEntities);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return storeResponseDTOS;
    }

// Map entities to dtos
    List<StoreResponseDTO> mapEntitiesToDTOs(List<StoreEntity> storeEntities) {
        List<StoreResponseDTO> storeResponseDTOS =  new ArrayList<>();
        if (!storeEntities.isEmpty()) {
            storeResponseDTOS =  storeEntities.stream().map(storeEntity -> {
                StoreResponseDTO storeResponseDTO =  new StoreResponseDTO();
                storeResponseDTO.setId(storeEntity.getId());
                storeResponseDTO.setCategory(storeEntity.getCategory());
                storeResponseDTO.setAddress(storeEntity.getAddress());
                storeResponseDTO.setDescription(storeEntity.getDescription());
                storeResponseDTO.setGeoLocation(storeEntity.getGeoLocation());
                storeResponseDTO.setEmailAddress(storeEntity.getEmailAddress());
                storeResponseDTO.setImagePath(storeEntity.getImagePath());
                return storeResponseDTO;
            }).collect(Collectors.toList());
        }
        return  storeResponseDTOS;
    }
}
