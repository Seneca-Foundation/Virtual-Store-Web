package com.senecafoundation.virtualstoreweb.DataHandlers.Repository;

import com.senecafoundation.virtualstoreweb.ProductObjects.Bracelet;

import org.springframework.stereotype.Repository;

@Repository
public interface BraceletRepository<T extends Bracelet> extends StoreItemRepository<T> {   
}
