package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;
import java.util.List;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.Basketball;
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
@RequestMapping("basketball")
public class BasketballController {

    UUID ID;
    @Autowired
    RepoCreateData<Basketball> dataHandler;
    @Autowired
    RepoUpdateData<Basketball> dataHandlerUpdate;
    @Autowired
    RepoDeleteData<Basketball> dataHandlerDelete;
    @Autowired
    RepoReadData<Basketball> dataHandlerRead;

    @GetMapping("/createform")
    public String showForm(Model model) {
        Basketball basketball = new Basketball();
        model.addAttribute("basketball", basketball);
        return "get_basketball";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("basketball") Basketball basketball, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(basketball);
        model.addAttribute("basketball", basketball);
        return "create_basketball";
    }
    @GetMapping("/updateform")
    public String showUpdateForm(Model model) {
        List<StoreItem> showItems = dataHandlerRead.ReadAll();
        model.addAttribute("itemsToShow", showItems);
        return "basketball";
    }
    @RequestMapping(value ="/updateform", method = RequestMethod.PUT)
    public String change(@ModelAttribute("basketball") Basketball basketball, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerUpdate.Update(basketball);
        return "update_basketball"; 
    }
    @GetMapping("/deleteform")
    public String showDeleteForm(Model model) {
        List<StoreItem> showItems = dataHandlerRead.ReadAll();
        model.addAttribute("itemsToDelete", showItems);
        return "basketball";
    }
    @RequestMapping(value ="/deleteform", method = RequestMethod.DELETE)
    public String erase(@ModelAttribute("basketball") Basketball basketball, UUID ID, BindingResult result, ModelMap model) {
        this.ID = ID;
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerDelete.Delete(ID);
        return "delete_basketball";
    }

}

