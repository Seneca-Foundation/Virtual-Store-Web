package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.UUID;
import java.util.List;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoCreateData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoDeleteData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoUpdateData;
import com.senecafoundation.virtualstoreweb.FundamentalObjects.StoreItem;
import com.senecafoundation.virtualstoreweb.ProductObjects.BookObjects.Book;
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
@RequestMapping("book")
public class BookController {

    UUID ID;
    @Autowired
    RepoCreateData<Book> dataHandler;
    @Autowired
    RepoUpdateData<Book> dataHandlerUpdate;
    @Autowired
    RepoDeleteData<Book> dataHandlerDelete;
    @Autowired
    RepoReadData<Book> dataHandlerRead;
    
    @GetMapping("/createform")
    public String showForm(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "create_book";
    }

    @RequestMapping(value = "/createform", method = RequestMethod.POST)
    public String submit(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandler.Create(book);
        //repo.save(shadowElf);
        model.addAttribute("book", book);
        return "book";
    }

    @GetMapping("/updateform")
    public String showUpdateForm(Model model) {
        List<StoreItem> showItems = dataHandlerRead.ReadAll();
        model.addAttribute("itemsToShow", showItems);
        return "update_book";
    }

    @RequestMapping(value ="/updateform", method = RequestMethod.PUT)
    public String change(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerUpdate.Update(book);
        return "book";  
    }
    @GetMapping("/deleteform")
    public String showDeleteForm(Model model) {
        List<StoreItem> showItems = dataHandlerRead.ReadAll();
        model.addAttribute("itemsToDelete", showItems);
        return "delete_book";
    }
    @RequestMapping(value="/deleteform", method = RequestMethod.DELETE)
    public String erase(@ModelAttribute("book")Book book, UUID ID, BindingResult result, ModelMap model) {
        this.ID = ID;
        if (result.hasErrors()) {
            return "error";
        }
        dataHandlerDelete.Delete(ID);
        return "book";
    }
}