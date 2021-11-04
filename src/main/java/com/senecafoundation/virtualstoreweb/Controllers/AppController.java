package com.senecafoundation.virtualstoreweb.Controllers;

import java.util.ArrayList;
import java.util.UUID;

import com.senecafoundation.virtualstoreweb.DataHandlers.RepoDataHandlers.RepoReadData;
import com.senecafoundation.virtualstoreweb.ProductObjects.Bracelet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AppController
{
  @Autowired
  RepoReadData<Bracelet> dataHandlerReadBracelet;
  // wire up the other three

  @RequestMapping(method=RequestMethod.GET, ModelMap model)
  public String index()
  {

    model.addAttribute("braceletId", dataHandlerReadBracelet.ReadAll().get(0).getID().toString());
    // do that for the other four categories

    return "index";
  }

}