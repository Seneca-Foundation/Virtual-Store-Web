package com.senecafoundation.virtualstoreweb.DataHandlers.Repository;

import com.senecafoundation.virtualstoreweb.ProductObjects.Sticker;

import org.springframework.stereotype.Repository;

@Repository
public interface StickerRepository<T extends Sticker> extends StoreItemRepository<T>{

}