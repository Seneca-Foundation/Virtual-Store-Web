package com.senecafoundation.virtualstoreweb.DataHandlers;

import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoUpdateData implements IUpdateData {

    @Autowired
    private StoreItemRepository storeItemRepository;

    @Override
    public StoreItem Update(StoreItem item) {
        return this.storeItemRepository.save(item);
    }
    
}