package com.senecafoundation.virtualstoreweb.Controllers;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoCreateData;
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

    @Autowired
    RepoCreateData dataHandler;
    
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

    @RequestMapping(value ="/updateform", method = RequestMethod.PUT)
    public void UpdateBook(@ModelAttribute("book") Book book, BindingResult result, ModelMap model) {
        
    }
    @RequestMapping(value="/deleteform", method = RequestMethod.DELETE)
    public void DeleteBook(@ModelAttribute("book")Book book, BindingResult result, ModelMap model) {

    }
}