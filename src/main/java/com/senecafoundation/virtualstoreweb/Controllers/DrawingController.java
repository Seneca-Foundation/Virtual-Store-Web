package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;
import java.util.List;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.Drawing;

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
@RequestMapping("drawing")
public class DrawingController {

    UUID ID;
    @Autowired
    RepoCreateData<Drawing> dataHandler;
    @Autowired
    RepoUpdateData<Drawing> dataHandlerUpdate;
    @Autowired
    RepoDeleteData<Drawing> dataHandlerDelete;
    @Autowired
    RepoReadData<Drawing> dataHandlerRead;
    
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String index()
    {
      return "drawing_index";
    }

    @GetMapping("/createform")
    public String showForm(Model model) {
        Drawing drawing = new Drawing();
        model.addAttribute("drawing", drawing);
        return "create_drawing";
    }

    @GetMapping("/categoryview")
    public String showCategoryView(Model model) {
        List<StoreItem> drawings = dataHandlerRead.ReadAll();
        model.addAttribute("drawing", drawings);
        return "category_drawings";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("drawing") Drawing drawing, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(drawing);
        model.addAttribute("drawing", drawing);
        return "drawing";
    }

     @RequestMapping(value = "/readform/{id}", method = RequestMethod.GET)
     public String read(@PathVariable("id") String Id, ModelMap model) {
         Drawing drawing = (Drawing) dataHandlerRead.Read(UUID.fromString(Id));
         model.addAttribute("drawing", drawing);
        return "drawing";
     }
    
    @RequestMapping(value = "/updateform/{id}", method = RequestMethod.GET)
     public String showUpdateForm(@PathVariable("id") String Id, Model model) {
        Drawing drawing = (Drawing) dataHandlerRead.Read(UUID.fromString(Id));
         model.addAttribute("drawing", drawing);
         return "create_drawing"; }

     @RequestMapping(value="/updateform", method = RequestMethod.PUT)
     public String change(@ModelAttribute("drawing") Drawing drawing, BindingResult result, ModelMap model) {
         if (result.hasErrors()) {
             return "error";
         }
         dataHandlerUpdate.Update(drawing);
         return "drawing";   
     }

     @GetMapping("/deleteform")
     public String showDeleteForm(Model model) {
         List<StoreItem> showItems = dataHandlerRead.ReadAll();
         model.addAttribute("itemsToDelete", showItems);
         return "delete_drawing";
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