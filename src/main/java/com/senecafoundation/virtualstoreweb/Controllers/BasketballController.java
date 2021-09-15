package com.senecafoundation.virtualstoreweb.Controllers;

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
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("basketball")
public class BasketballController {

    @Autowired
    RepoCreateData dataHandler;

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

    @RequestMapping(value = "/createform", method = RequestMethod.GET)
    public String get(@ModelAttribute("basketball") Basketball basketball, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        RequestMapping(value ="/createform", method = RequestMethod.PUT)

    public void UpdateBasketball(@ModelAttribute("basketball") Basketball basketball, BindingResult result,
            ModelMap model) {

    }
    RequestMapping(value ="/createform", method = RequestMethod.DELETE)
    public void DeleteBasketball(@ModelAttribute("basketball") Basketball basketball, BindingResult result, ModelMap model) {
        
}
