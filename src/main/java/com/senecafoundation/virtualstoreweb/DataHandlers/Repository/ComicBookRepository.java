package com.senecafoundation.virtualstoreweb.DataHandlers.Repository;

import com.senecafoundation.virtualstoreweb.ProductObjects.BookObjects.ComicBook;

import org.springframework.stereotype.Repository;

@Repository
public interface ComicBookRepository<T extends ComicBook> extends StoreItemRepository<T> {   
}