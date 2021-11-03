package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.ProductObjects.Bracelet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BraceletDeleteData extends RepoDeleteData<Bracelet> {

    @Autowired
    public StoreItemRepository<Bracelet> storeItemRepository;
}
