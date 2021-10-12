package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.Computer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/computers")
    List<StoreItem> allComputers() {
        return dataHandlerRead.ReadAll();
    }

    @PostMapping("/computers")
    Computer newComputer(@RequestBody Computer newComputer) {
        UUID newId = dataHandler.Create(newComputer);
        return newComputer;
    }
    @PutMapping("/computers/{id}")
    Computer replaceComputer(@RequestBody Computer newComputer, @PathVariable String id) {
        Computer computer = (Computer) dataHandlerRead.Read(UUID.fromString(id));
        
        dataHandlerUpdate.Update(newComputer);
        return newComputer;
    }


    @DeleteMapping("/computers/{id}")
    void deleteComputer(@PathVariable String id)
    {
        dataHandlerDelete.Delete(UUID.fromString(id));
    }
}
