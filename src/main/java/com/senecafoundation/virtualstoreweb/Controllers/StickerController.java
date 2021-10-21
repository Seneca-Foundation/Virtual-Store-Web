package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;
import java.util.List;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.Sticker;

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
@RequestMapping("sticker")
public class StickerController {

    UUID ID;
    @Autowired
    RepoCreateData<Sticker> dataHandler;
    @Autowired
    RepoUpdateData<Sticker> dataHandlerUpdate;
    @Autowired
    RepoDeleteData<Sticker> dataHandlerDelete;
    @Autowired
    RepoReadData<Sticker> dataHandlerRead;
    
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index()
    {
      return "sticker_index";
    }

    @GetMapping("/createform")
    public String showForm(Model model) {
        Sticker sticker = new Sticker();
        model.addAttribute("sticker", sticker);
        return "create_sticker";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("sticker") Sticker sticker, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(sticker);
        model.addAttribute("sticker", sticker);
        return "sticker";
    }

     @RequestMapping(value = "/readform/{id}", method = RequestMethod.GET)
     public String read(@PathVariable("id") String Id, ModelMap model) {
         Sticker sticker = (Sticker) dataHandlerRead.Read(UUID.fromString(Id));
         model.addAttribute("sticker", sticker);
        return "sticker";
     }
    
    @RequestMapping(value = "/updateform/{id}", method = RequestMethod.GET)
     public String showUpdateForm(@PathVariable("id") String Id, Model model) {
        Sticker sticker = (Sticker) dataHandlerRead.Read(UUID.fromString(Id));
         model.addAttribute("sticker", sticker);
         return "create_sticker"; }

     @RequestMapping(value="/updateform", method = RequestMethod.PUT)
     public String change(@ModelAttribute("sticker") Sticker sticker, BindingResult result, ModelMap model) {
         if (result.hasErrors()) {
             return "error";
         }
         dataHandlerUpdate.Update(sticker);
         return "sticker";   
     }

     @GetMapping("/deleteform")
     public String showDeleteForm(Model model) {
         List<StoreItem> showItems = dataHandlerRead.ReadAll();
         model.addAttribute("itemsToDelete", showItems);
         return "delete_sticker";
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