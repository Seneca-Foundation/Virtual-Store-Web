package com.senecafoundation.virtualstoreweb.Controllers;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoUpdateData;
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

    @Autowired
    RepoCreateData dataHandler;
    @Autowired
    RepoUpdateData dataHandlerUpdate;
    
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
        return "energy";    
    }
    @RequestMapping(value="/deleteform", method = RequestMethod.DELETE)
    public void DeleteEnergy(@ModelAttribute("/energy")Powerplant powerPlant, BindingResult result, ModelMap model) {
    }
}
