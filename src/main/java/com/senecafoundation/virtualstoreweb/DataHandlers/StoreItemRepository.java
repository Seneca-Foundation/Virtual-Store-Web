package com.senecafoundation.virtualstoreweb.DataHandlers;

import java.util.Optional;
import java.util.UUID;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreItemRepository extends JpaRepository<StoreItem, UUID> {
    
}

    //Optional<StoreItem> findFirst(UUID iD);}
