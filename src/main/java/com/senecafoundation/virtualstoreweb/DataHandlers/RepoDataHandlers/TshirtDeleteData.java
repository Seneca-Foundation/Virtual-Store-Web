package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.ProductObjects.Tshirt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TshirtDeleteData extends RepoDeleteData<Tshirt> {

    @Autowired
    public StoreItemRepository<Tshirt> storeItemRepository;
}