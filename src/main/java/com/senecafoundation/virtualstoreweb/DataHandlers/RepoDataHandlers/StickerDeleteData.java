package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.ProductObjects.Sticker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StickerDeleteData extends RepoDeleteData<Sticker> {
        
    @Autowired
    public StoreItemRepository<Sticker> storeItemRepository;
}