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
  // test comment 2
  @RequestMapping(method=RequestMethod.GET)
  public String index(ModelMap model)
  {
    if(dataHandlerReadBracelet.ReadAll().size() > 0) {
      model.addAttribute("braceletId", dataHandlerReadBracelet.ReadAll().get(0).getID().toString());
    }
    if(dataHandlerReadSticker.ReadAll().size() > 0) {
      model.addAttribute("stickerId", dataHandlerReadSticker.ReadAll().get(0).getID().toString());
    }
    if(dataHandlerReadDrawing.ReadAll().size() > 0) {
      model.addAttribute("drawingId", dataHandlerReadDrawing.ReadAll().get(0).getID().toString());
    }    
    if(dataHandlerReadTshirt.ReadAll().size() > 0) {
      model.addAttribute("tshirtId", dataHandlerReadTshirt.ReadAll().get(0).getID().toString());
    }
    return "index";
  }
}