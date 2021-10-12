package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.ProductObjects.BookObjects.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookRestController {
    
    @Autowired
    RepoCreateData<Book> dataHandler;
    @Autowired
    RepoUpdateData<Book> dataHandlerUpdate;
    @Autowired
    RepoDeleteData<Book> dataHandlerDelete;
    @Autowired
    RepoReadData<Book> dataHandlerRead;

    @PostMapping("/books")
        Book newBook(@RequestBody Book newBook) {
        UUID newId = dataHandler.Create(newBook);
        return newBook;
    }
    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable String id)
    {
        dataHandlerDelete.Delete(UUID.fromString(id));
    }
}

