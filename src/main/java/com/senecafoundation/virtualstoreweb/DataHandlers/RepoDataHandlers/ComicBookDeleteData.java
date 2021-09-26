package com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers;

import com.senecafoundation.virtualstoreweb.DataHandlers.Repository.StoreItemRepository;
import com.senecafoundation.virtualstoreweb.ProductObjects.BookObjects.ComicBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComicBookDeleteData extends RepoDeleteData<ComicBook> {

    @Autowired
    public StoreItemRepository<ComicBook> storeItemRepository;
}
