package com.senecafoundation.virtualstoreweb;
 
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoCreateData;
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

@Controller
@RequestMapping("basketballtickets")
public class BasketballticketsController {

    @Autowired
    RepoCreateData dataHandler;
    
    @GetMapping("/createform")
    public String showForm(Model model) {
        BasketballTickets basketballTickets = new BasketballTickets();
        model.addAttribute("basketballtickets", basketballTickets);
        return "create_basketballtickets";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("basketballtickets") Basketball basketballTickets, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(basketballTickets);
        //repo.save(shadowElf);
        model.addAttribute("basketballtickets", basketballTickets);
        return "basketballtickets";
    }
}