package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import java.util.ArrayList;
import java.util.List;

import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.Bracelet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BraceletReadData extends RepoReadData<Bracelet> {

    @Autowired
    public StoreItemRepository<Bracelet> storeItemRepository;

    @Override
    public List<StoreItem> ReadAll() {
        ArrayList<StoreItem> listOfItemsToReturn = new ArrayList<StoreItem>();
        for (Bracelet bracelet : this.storeItemRepository.findAll()) {
            listOfItemsToReturn.add(bracelet);
        }
        return listOfItemsToReturn;
    }   
}
