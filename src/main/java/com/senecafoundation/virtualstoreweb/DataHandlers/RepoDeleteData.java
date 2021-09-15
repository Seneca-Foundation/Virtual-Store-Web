package com.senecafoundation.virtualstoreweb.DataHandlers;

import java.util.UUID;
//import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoDeleteData implements IDeleteData {

    @Autowired
    private StoreItemRepository storeItemRepository;

    @Override
    public void Delete(UUID IDToRemove) {
        this.storeItemRepository.deleteById(IDToRemove);
    }
    
}
