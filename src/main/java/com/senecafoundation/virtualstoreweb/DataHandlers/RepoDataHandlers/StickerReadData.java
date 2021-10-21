package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import java.util.ArrayList;
import java.util.List;

import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.Sticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StickerReadData extends RepoReadData<Sticker> {

    @Autowired
    public StoreItemRepository<Sticker> storeItemRepository;

    @Override
    public List<StoreItem> ReadAll() {
        ArrayList<StoreItem> listOfItemsToReturn = new ArrayList<StoreItem>();
        for (Sticker sticker : this.storeItemRepository.findAll()) {
            listOfItemsToReturn.add(sticker);
        }
        return listOfItemsToReturn;
    }   
}
