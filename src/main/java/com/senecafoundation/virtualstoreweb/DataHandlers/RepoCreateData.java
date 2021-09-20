package com.senecafoundation.virtualstoreweb.DataHandlers;

import java.util.UUID;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoCreateData implements ICreateData {

    @Autowired
    private StoreItemRepository storeItemRepository;

    @Override
    public UUID Create(StoreItem item) {
        return this.storeItemRepository.save(item).getID();
    }
    
}
