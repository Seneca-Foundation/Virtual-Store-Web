package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import com.senecafoundation.virtualstoreweb.DataHandlers.IUpdateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoUpdateData<T extends StoreItem> implements IUpdateData {

    @Autowired
    private StoreItemRepository<T> storeItemRepository;

    @Override
    public StoreItem Update(StoreItem item) {
        return this.storeItemRepository.save((T) item);
    }
    
}