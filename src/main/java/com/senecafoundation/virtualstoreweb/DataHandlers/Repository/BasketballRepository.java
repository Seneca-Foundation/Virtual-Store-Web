package com.senecafoundation.virtualstoreweb.DataHandlers.Repository;

package com.senecafoundation.virtualstoreweb.DataHandlers.Repository;

import com.senecafoundation.virtualstoreweb.ProductObjects.Basketball;

import org.springframework.stereotype.Repository;

@Repository
public interface BasketballRepository<T extends Basketball> extends StoreItemRepository<T> {   
}

