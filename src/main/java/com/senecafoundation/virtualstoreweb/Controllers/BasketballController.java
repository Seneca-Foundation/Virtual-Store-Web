package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;
import java.util.List;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoUpdateData;
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
    RepoCreateData dataHandler;
    @Autowired
    RepoUpdateData dataHandlerUpdate;
    @Autowired
    RepoDeleteData dataHandlerDelete;
    @Autowired
    RepoReadData dataHandlerRead;
    //private String value;

    @GetMapping("/createform")
    public String showForm(Model model) {
        Basketball basketball = new Basketball();
        model.addAttribute("basketball", basketball);
        return "create_basketball";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("basketball") Basketball basketball, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(basketball);
        // repo.save(shadowElf);
        model.addAttribute("basketball", basketball);
        return "basketball";
    }
/*
    @RequestMapping(value = "/createform", method = RequestMethod.GET)
    public String GetBasketball(@ModelAttribute("basketball") Basketball basketball, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error"; 
        }
        return "basketball";
    }
    */
    @RequestMapping(value ="/updateform", method = RequestMethod.PUT)
    public String change(@ModelAttribute("basketball") Basketball basketball, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerUpdate.Update(basketball);
        return "basketball"; 
    }
    @GetMapping("/deleteform")
    public String showDeleteForm(Model model) {
        List<StoreItem> showItems = dataHandlerRead.ReadAll();
        model.addAttribute("itemsToDelete", showItems);
        return "delete_basketball";
    }
    @RequestMapping(value ="/deleteform", method = RequestMethod.DELETE)
    public String erase(@ModelAttribute("basketball") Basketball basketball, UUID ID, BindingResult result, ModelMap model) {
        this.ID = ID;
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerDelete.Delete(ID);
        return "basketball";
    }

}

