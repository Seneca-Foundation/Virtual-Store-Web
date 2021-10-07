package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.ICreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoCreateData<T extends StoreItem> implements ICreateData {

    @Autowired
    private StoreItemRepository<T> storeItemRepository;

    @Override
    public UUID Create(StoreItem item) {
        return this.storeItemRepository.save((T) item).getID();
    }
    
}
