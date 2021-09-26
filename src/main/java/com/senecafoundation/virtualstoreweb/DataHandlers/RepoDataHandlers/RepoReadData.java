package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.IReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoReadData<T extends StoreItem> implements IReadData {

    @Autowired
    private StoreItemRepository<T> storeItemRepository;

    @Override
    public StoreItem Read(UUID ID) {
        //findFirst().orElse(null) should give you the object or null if it's not present
       return this.storeItemRepository.findById(ID).orElseThrow();
    }

    @Override
    public List<StoreItem> ReadAll() {
        List<StoreItem> items = new ArrayList<StoreItem>();
        items = (List<StoreItem>) this.storeItemRepository.findAll();
        return items;
    }
    
}

