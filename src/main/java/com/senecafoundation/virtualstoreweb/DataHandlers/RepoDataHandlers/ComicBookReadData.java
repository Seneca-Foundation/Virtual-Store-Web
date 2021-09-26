package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import java.util.ArrayList;
import java.util.List;

import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.BookObjects.ComicBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComicBookReadData extends RepoReadData<ComicBook> {

    @Autowired
    public StoreItemRepository<ComicBook> storeItemRepository;

    @Override
    public List<StoreItem> ReadAll() {
        ArrayList<StoreItem> listOfItemsToReturn = new ArrayList<StoreItem>();
        for (ComicBook comicBook : this.storeItemRepository.findAll()) {
            listOfItemsToReturn.add(comicBook);
        }
        return listOfItemsToReturn;
    }   
}
