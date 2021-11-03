package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.ProductObjects.Drawing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrawingDeleteData extends RepoDeleteData<Drawing> {

    @Autowired
    public StoreItemRepository<Drawing> storeItemRepository;
}
