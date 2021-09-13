package com.senecafoundation.virtualstoreweb;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoCreateData;
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

@Controller
@RequestMapping("computer")
public class ComputerController {

    @Autowired
    RepoCreateData dataHandler;
    
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
}