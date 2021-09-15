package com.senecafoundation.virtualstoreweb.Controllers;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoCreateData;
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
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("comicbook")
public class ComicBookController {

    @Autowired
    RepoCreateData dataHandler;
    
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
    @RequestMapping(value="/createform", method = RequestMethod.PUT)
    public void updateComicBook(@ModelAttribute("comicbook") ComicBook comicBook, BindingResult result, ModelMap model) {
        
    }
    @RequestMapping(value="/createform", method = RequestMethod.DELETE)
    public void DeleteComicBook(@ModelAttribute("/comicbook")ComicBook comicBook, BindingResult result, ModelMap model) {
    
    }
}