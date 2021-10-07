package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.ProductObjects.Computer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ComputerRestController {
    
    @Autowired
    RepoCreateData<Computer> dataHandler;
    @Autowired
    RepoUpdateData<Computer> dataHandlerUpdate;
    @Autowired
    RepoDeleteData<Computer> dataHandlerDelete;
    @Autowired
    RepoReadData<Computer> dataHandlerRead;

    @PostMapping("/computers")
        Computer newComputer(@RequestBody Computer newComputer) {
        UUID newId = dataHandler.Create(newComputer);
        return newComputer;
    }
}
