package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.senecafoundation.virtualstoreweb.ProductObjects.Powerplant;
import org.springframework.stereotype.Service;

@Service
public class PowerplantDeleteData extends RepoDeleteData<Powerplant> {

    @Autowired
    public StoreItemRepository<Powerplant> storeItemRepository;
}
