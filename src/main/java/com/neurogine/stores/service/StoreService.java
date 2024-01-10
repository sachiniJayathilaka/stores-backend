package com.neurogine.stores.service;

import com.neurogine.stores.dto.StoreFilterDTO;
import com.neurogine.stores.dto.StoreResponseDTO;

import java.util.List;

public interface StoreService {

    List<StoreResponseDTO> getAllStores(StoreFilterDTO storeFilterDTO);
}
