package com.launchacademy.grouprework.controllers;

import com.launchacademy.grouprework.repositories.CreatureRepository;
import com.launchacademy.grouprework.repositories.CreatureTypesRepository;
import com.launchacademy.grouprework.repositories.PetSurrenderApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class CreatureController {
  @Autowired
  CreatureRepository creatureRepository;

  @Autowired
  CreatureTypesRepository creatureTypesRepository;

  @Autowired
  PetSurrenderApplicationRepository petSurrenderApplicationRepository;

  @GetMapping
  public String getCreatureTypes(Model model){
    model.addAttribute("creatureTypes", creatureTypesRepository.findAll());
    return "creatures/creatureTypes";
  }
}
