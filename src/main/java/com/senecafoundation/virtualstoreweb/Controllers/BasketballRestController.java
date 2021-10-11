package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.ProductObjects.Basketball;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class BasketballRestController {
    
    @Autowired
    RepoCreateData<Basketball> dataHandler;
    @Autowired
    RepoUpdateData<Basketball> dataHandlerUpdate;
    @Autowired
    RepoDeleteData<Basketball> dataHandlerDelete;
    @Autowired
    RepoReadData<Basketball> dataHandlerRead;

    @PostMapping("/basketballs")
    Basketball newBasketball(@RequestBody Basketball newBasketball) {
        UUID newId = dataHandler.Create(newBasketball);
        return newBasketball;
    }
    @PostMapping("/basketballdelete")
    (@RequestBody UUID ID)
    {
        dataHandlerDelete.Delete(ID);
    }
}