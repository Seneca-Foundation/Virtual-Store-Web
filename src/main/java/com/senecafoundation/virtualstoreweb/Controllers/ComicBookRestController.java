package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.BookObjects.ComicBook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/comicbooks")
    List<StoreItem> allComicbooks() {
        return dataHandlerRead.ReadAll();
    }

    @PostMapping("/comicbooks")
    ComicBook newComicBook(@RequestBody ComicBook newComicBook) {
        UUID newId = dataHandler.Create(newComicBook);
        return newComicBook;
    }
    
    @PutMapping("/comicbooks/{id}")
    ComicBook replaceComicBook(@RequestBody ComicBook newComicBook, @PathVariable String id) {
        ComicBook comicbook = (ComicBook) dataHandlerRead.Read(UUID.fromString(id));
        dataHandlerUpdate.Update(newComicBook);
        return newComicBook;
    }
    
    @DeleteMapping("/comicbooks/{id}")
    void deleteComicBook(@PathVariable String id)
    {
        dataHandlerDelete.Delete(UUID.fromString(id));
    }
}