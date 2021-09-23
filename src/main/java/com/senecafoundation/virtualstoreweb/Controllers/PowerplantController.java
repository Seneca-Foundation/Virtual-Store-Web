package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;
import java.util.List;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.Powerplant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("powerplant")
public class PowerplantController {
    
    UUID ID;
    @Autowired
    RepoCreateData dataHandler;
    @Autowired
    RepoUpdateData dataHandlerUpdate;
    @Autowired
    RepoDeleteData dataHandlerDelete;
    @Autowired
    RepoReadData dataHandlerRead;
    
    @GetMapping("/createform")
    public String showForm(Model model) {
        Powerplant powerPlant = new Powerplant();
        model.addAttribute("energy", powerPlant);
        return "create_powerplant";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("energy") Powerplant powerPlant, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(powerPlant);
        //repo.save(shadowElf);
        model.addAttribute("energy", powerPlant);
        return "powerplant";
    }
    @RequestMapping(value ="/updateform", method = RequestMethod.PUT)
    public String change(@ModelAttribute("energy") Powerplant powerPlant, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerUpdate.Update(powerPlant);
        return "powerplant";    
    }
    @GetMapping("/deleteform")
    public String showDeleteForm(Model model) {
        List<StoreItem> showItems = dataHandlerRead.ReadAll();
        model.addAttribute("itemsToDelete", showItems);
        return "delete_powerplant";
    }
    @RequestMapping(value="/deleteform", method = RequestMethod.DELETE)
    public String erase(@ModelAttribute("energy")Powerplant powerPlant, UUID ID, BindingResult result, ModelMap model) {
        this.ID = ID;
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerDelete.Delete(ID);
        return "powerplant";
    }
}