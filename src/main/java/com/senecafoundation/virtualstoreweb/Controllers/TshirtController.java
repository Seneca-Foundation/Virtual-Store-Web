package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;
import java.util.List;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.Tshirt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("tshirt")
public class TshirtController {

    UUID ID;
    @Autowired
    RepoCreateData<Tshirt> dataHandler;
    @Autowired
    RepoUpdateData<Tshirt> dataHandlerUpdate;
    @Autowired
    RepoDeleteData<Tshirt> dataHandlerDelete;
    @Autowired
    RepoReadData<Tshirt> dataHandlerRead;
    
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index()
    {
      return "tshirt_index";
    }

    @GetMapping("/createform")
    public String showForm(Model model) {
        Tshirt tshirt = new Tshirt();
        model.addAttribute("tshirt", tshirt);
        return "create_tshirt";
    }

    @GetMapping("/categoryview")
    public String showCategoryView(Model model) {
        List<StoreItem> tshirt = dataHandlerRead.ReadAll();
        model.addAttribute("tshirt", tshirt);
        return "category_tshirt";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("tshirt") Tshirt tshirt, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(tshirt);
        model.addAttribute("tshirt", tshirt);
        return "tshirt";
    }

     @RequestMapping(value = "/readform/{id}", method = RequestMethod.GET)
     public String read(@PathVariable("id") String Id, ModelMap model) {
         Tshirt tshirt = (Tshirt) dataHandlerRead.Read(UUID.fromString(Id));
         model.addAttribute("tshirt", tshirt);
        return "tshirt";
     }
    
    @RequestMapping(value = "/updateform/{id}", method = RequestMethod.GET)
     public String showUpdateForm(@PathVariable("id") String Id, Model model) {
        Tshirt tshirt = (Tshirt) dataHandlerRead.Read(UUID.fromString(Id));
         model.addAttribute("tshirt", tshirt);
         return "create_tshirt"; }

     @RequestMapping(value="/updateform", method = RequestMethod.PUT)
     public String change(@ModelAttribute("tshirt") Tshirt tshirt, BindingResult result, ModelMap model) {
         if (result.hasErrors()) {
             return "error";
         }
         dataHandlerUpdate.Update(tshirt);
         return "tshirt";   
     }

     @GetMapping("/deleteform")
     public String showDeleteForm(Model model) {
         List<StoreItem> showItems = dataHandlerRead.ReadAll();
         model.addAttribute("itemsToDelete", showItems);
         return "delete_tshirt";
     }
    
     @RequestMapping(value = "/deleteform/{id}", method = RequestMethod.DELETE)
     public String delete(@PathVariable("id") String Id, ModelMap model) {
         try {
             dataHandlerDelete.Delete(UUID.fromString(Id));
         } catch (Exception e) {
             e.printStackTrace();
         }
         model.addAttribute("Id", Id);
         return "itemdelete";
     }
}