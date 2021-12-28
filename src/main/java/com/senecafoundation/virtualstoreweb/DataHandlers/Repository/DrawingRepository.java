package com.senecafoundation.virtualstoreweb.DataHandlers.Repository;

import com.senecafoundation.virtualstoreweb.ProductObjects.Drawing;

import org.springframework.stereotype.Repository;

@Repository
public interface DrawingRepository<T extends Drawing> extends StoreItemRepository<T>{

}