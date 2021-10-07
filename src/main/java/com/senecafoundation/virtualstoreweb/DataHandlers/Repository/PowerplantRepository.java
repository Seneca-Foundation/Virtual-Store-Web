package com.senecafoundation.virtualstoreweb.DataHandlers.Repository;

import com.senecafoundation.virtualstoreweb.ProductObjects.Powerplant;

import org.springframework.stereotype.Repository;

@Repository
public interface PowerplantRepository<T extends Powerplant> extends StoreItemRepository<T> {   
}