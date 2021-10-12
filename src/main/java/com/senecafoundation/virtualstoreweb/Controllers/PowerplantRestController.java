package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.ProductObjects.Powerplant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PowerplantRestController {
    
    @Autowired
    RepoCreateData<Powerplant> dataHandler;
    @Autowired
    RepoUpdateData<Powerplant> dataHandlerUpdate;
    @Autowired
    RepoDeleteData<Powerplant> dataHandlerDelete;
    @Autowired
    RepoReadData<Powerplant> dataHandlerRead;

    @PostMapping("/powerplants")
        Powerplant newPowerplant(@RequestBody Powerplant newPowerplant) {
        UUID newId = dataHandler.Create(newPowerplant);
        return newPowerplant;
    }
    @DeleteMapping("/powerplants/{id}")
    void deletePowerplant(@PathVariable String id)
    {
        dataHandlerDelete.Delete(UUID.fromString(id));
    }
}