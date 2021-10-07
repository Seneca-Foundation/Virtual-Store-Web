package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.IDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;

//import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoDeleteData<T extends StoreItem> implements IDeleteData {

    UUID IDToRemove;
    @Autowired
    private StoreItemRepository<T> storeItemRepository;

    @Override
    public void Delete(UUID IDToRemove) {
        this.IDToRemove = IDToRemove;
        this.storeItemRepository.deleteById(IDToRemove);
    }
    
}
