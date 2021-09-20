package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.ProductObjects.Computer;
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
@RequestMapping("computer")
public class ComputerController {

    UUID ID;
    @Autowired
    RepoCreateData dataHandler;
    @Autowired
    RepoUpdateData dataHandlerUpdate;
    @Autowired
    RepoDeleteData dataHandlerDelete;
    
    @GetMapping("/createform")
    public String showForm(Model model) {
        Computer computer = new Computer();
        model.addAttribute("computer", computer);
        return "create_computer";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("computer") Computer computer, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(computer);
        //repo.save(shadowElf);
        model.addAttribute("computer", computer);
        return "computer";
    }
    @RequestMapping(value ="/updateform", method = RequestMethod.PUT)
    public String change(@ModelAttribute("computer") Computer computer, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerUpdate.Update(computer);
        return "computer";   
    }
    @RequestMapping(value="/deleteform", method = RequestMethod.DELETE)
    public String erase(@ModelAttribute("computer")Computer computer,UUID ID, BindingResult result, ModelMap model) {
        this.ID = ID;
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerDelete.Delete(ID);
        return "computer";
    }
}