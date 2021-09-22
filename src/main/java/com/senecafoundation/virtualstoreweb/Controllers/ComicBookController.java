package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.List;
import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.BookObjects.ComicBook;
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
@RequestMapping("comicbook")
public class ComicBookController {

    UUID ID;
    @Autowired
    RepoCreateData dataHandler;
    @Autowired
    RepoUpdateData dataHandlerUpdate;
    @Autowired
    RepoDeleteData dataHandlerDelete;
    @Autowired
    RepoReadData dataHandlerRead;
    
    @GetMapping("/createform")
    public String showForm(Model model) {
        ComicBook comicBook = new ComicBook();
        model.addAttribute("comicbook", comicBook);
        return "create_comicbook";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("comicbook") ComicBook comicBook, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(comicBook);
        //repo.save(shadowElf);
        model.addAttribute("comicbook", comicBook);
        return "comicbook";
    }
    //PUT
    @RequestMapping(value="/updateform", method = RequestMethod.PUT)
    public String change(@ModelAttribute("comicbook") ComicBook comicBook, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerUpdate.Update(comicBook);
        return "comicbook";   
    }

    @GetMapping("/deleteform")
    public String showDeleteForm(Model model) {
        //ComicBook comicBook = new ComicBook();
        List<StoreItem> showItems = dataHandlerRead.ReadAll();
        model.addAttribute("itemsToDelete", showItems);
        return "delete_comicbook";
    }

    @RequestMapping(value="/deleteform", method = RequestMethod.DELETE)
    public String erase(@ModelAttribute("comicbook")ComicBook comicBook, UUID ID, BindingResult result, ModelMap model) {
        this.ID = ID;
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerDelete.Delete(ID);
        return "comicbook";
    }
}