package com.neurogine.stores.respository;

import com.neurogine.stores.entity.StoreEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

    List<StoreEntity> getStoreEntitieByNameLikeIgnoreCaseAndDescriptionLikeIgnoreCase(String name, String description, Pageable pageable);

}
