package com.senecafoundation.virtualstoreweb.DataHandlers.Repository;

import com.senecafoundation.virtualstoreweb.ProductObjects.Tshirt;

import org.springframework.stereotype.Repository;

@Repository
public interface TshirtRepository<T extends Tshirt> extends StoreItemRepository<T>{

}