package com.senecafoundation.virtualstoreweb.DataHandlers.Repository;

import com.senecafoundation.virtualstoreweb.ProductObjects.Computer;

import org.springframework.stereotype.Repository;

@Repository
public interface ComputerRepository<T extends Computer> extends StoreItemRepository<T> {
    
}
