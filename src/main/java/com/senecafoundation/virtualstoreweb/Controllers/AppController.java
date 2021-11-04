package com.senecafoundation.virtualstoreweb.Controllers;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.ProductObjects.Bracelet;
import com.senecafoundation.virtualstoreweb.ProductObjects.Drawing;
import com.senecafoundation.virtualstoreweb.ProductObjects.Sticker;
import com.senecafoundation.virtualstoreweb.ProductObjects.Tshirt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;

@Controller
@RequestMapping("/")
public class AppController
{
  @Autowired
  RepoReadData<Bracelet> dataHandlerReadBracelet;
  @Autowired
  RepoReadData<Sticker> dataHandlerReadSticker;
  @Autowired
  RepoReadData<Drawing> dataHandlerReadDrawing;
  @Autowired
  RepoReadData<Tshirt> dataHandlerReadTshirt;
  // wire up the other three

  @RequestMapping(method=RequestMethod.GET)
  public String index(ModelMap model)
  {
    model.addAttribute("braceletId", dataHandlerReadBracelet.ReadAll().get(0).getID().toString());
    model.addAttribute("stickerId", dataHandlerReadBracelet.ReadAll().get(0).getID().toString());
    model.addAttribute("drawingId", dataHandlerReadBracelet.ReadAll().get(0).getID().toString());
    model.addAttribute("tshirtId", dataHandlerReadBracelet.ReadAll().get(0).getID().toString());
    return "index";
  }
}