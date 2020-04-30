package com.launchacademy.grouprework.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CreatureController {
  @GetMapping(value = "/**/{path:[^\\.]*}")
  public String forward() {
    return "forward:/";
  }
}