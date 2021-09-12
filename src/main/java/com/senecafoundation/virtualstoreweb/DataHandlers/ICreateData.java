package com.senecafoundation.virtualstoreweb.DataHandlers;

import java.util.UUID;

import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;

public interface ICreateData{
    public UUID Create(StoreItem item);
}
