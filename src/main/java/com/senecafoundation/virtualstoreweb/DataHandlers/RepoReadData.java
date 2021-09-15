package com.senecafoundation.virtualstoreweb.DataHandlers;

import java.util.List;
import java.util.UUID;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoReadData implements IReadData {

    UUID ID;
    @Autowired
    private StoreItemRepository storeItemRepository;

    @Override
    public StoreItem Read(UUID ID) {
        this.ID = ID;
        return this.storeItemRepository.findFirst(ID).orElse(null);
    }

    @Override
    public List<StoreItem> ReadAll() {
        return this.storeItemRepository.findAll();
    }
    
}
