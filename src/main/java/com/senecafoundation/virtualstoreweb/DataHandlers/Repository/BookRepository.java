package com.senecafoundation.virtualstoreweb.DataHandlers.Repository;

import com.senecafoundation.virtualstoreweb.ProductObjects.BookObjects.Book;

import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository<T extends Book> extends StoreItemRepository<T> {

}  
