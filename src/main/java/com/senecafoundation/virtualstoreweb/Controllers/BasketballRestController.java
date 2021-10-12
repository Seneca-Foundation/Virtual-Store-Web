package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.Basketball;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/basketballs")
    List<StoreItem> allBasketballs() {
        return dataHandlerRead.ReadAll();
    }

    @PostMapping("/basketballs")
    Basketball newBasketball(@RequestBody Basketball newBasketball) {
        UUID newId = dataHandler.Create(newBasketball);
        return newBasketball;
    }
    @PutMapping("/basketballs/{id}")
    Basketball replaceBasketball(@RequestBody Basketball newBasketball, @PathVariable String id) {
        Basketball basketball = (Basketball) dataHandlerRead.Read(UUID.fromString(id));
        
        dataHandlerUpdate.Update(newBasketball);
        return newBasketball;
    }


    @DeleteMapping("/basketballs/{id}")
    void deleteBasketball(@PathVariable String id)
    {
        dataHandlerDelete.Delete(UUID.fromString(id));
    }
}