package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.ProductObjects.BookObjects.ComicBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ComicBookRestController {
    
    @Autowired
    RepoCreateData<ComicBook> dataHandler;
    @Autowired
    RepoUpdateData<ComicBook> dataHandlerUpdate;
    @Autowired
    RepoDeleteData<ComicBook> dataHandlerDelete;
    @Autowired
    RepoReadData<ComicBook> dataHandlerRead;

    @PostMapping("/comicbooks")
        ComicBook newComicBook(@RequestBody ComicBook newComicBook) {
        UUID newId = dataHandler.Create(newComicBook);
        return newComicBook;
    }
}