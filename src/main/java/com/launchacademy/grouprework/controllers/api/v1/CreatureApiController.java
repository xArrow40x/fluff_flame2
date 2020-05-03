package com.launchacademy.grouprework.controllers.api.v1;

import com.launchacademy.grouprework.models.Creature;
import com.launchacademy.grouprework.models.CreatureTypes;
import com.launchacademy.grouprework.models.PetSurrenderApplication;
import com.launchacademy.grouprework.repositories.CreatureRepository;
import com.launchacademy.grouprework.repositories.CreatureTypesRepository;
import com.launchacademy.grouprework.repositories.PetSurrenderApplicationRepository;
import java.util.List;
import java.util.Optional;
import javax.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CreatureApiController {

  @Autowired
  CreatureRepository creatureRepository;

  @Autowired
  CreatureTypesRepository creatureTypesRepository;

  @Autowired
  PetSurrenderApplicationRepository petSurrenderApplicationRepository;

  private class CreatureNotFoundException extends RuntimeException{};
  @ControllerAdvice
  private class CreatureNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CreatureNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String urlNotFoundHandler(CreatureNotFoundException ex) {return ex.getMessage();
    }
  }

  @GetMapping("/creature_types")
  public Iterable<CreatureTypes> getList(){
    return creatureTypesRepository.findAll();
  }

  @GetMapping("/creature_types/{type}")
  public List<Creature> getIndividualItem(@PathVariable String type){
    return creatureRepository.findByType(type);
  }

  @GetMapping("/creature_types/{type}/{id}")
  public Creature getIndividualItem(@PathVariable Integer id, @PathVariable String type){
    return creatureRepository.findByTypeAndId(type, id);
  }


//  @PutMapping("/{id}")
//  public Creature updateCreature(@RequestBody Creature newCreature, @PathVariable Integer id){
//    return creatureRepository.findById(id)
//        .map(Creature -> {
//          Creature.setName(newCreature.getName());
//          Creature.setName(newCreature.getName());
//          Creature.setName(newCreature.getName());
//          Creature.setName(newCreature.getName());
//          Creature.setName(newCreature.getName());
//          Creature.setName(newCreature.getName());
//
//          return creatureRepository.save(Creature);
//        }).orElseThrow(() -> new CreatureNotFoundException());
//  }
//
//  @DeleteMapping("/{id}")
//  public Iterable<Creature> deleteCreature(@PathVariable Integer id){
//    creatureRepository.deleteById(id);
//    return creatureRepository.findAll();
//  }

  @PostMapping("/new_creature")
  public PetSurrenderApplication submitForm(@RequestBody PetSurrenderApplication petSurrenderApplication){
    petSurrenderApplication.setApplicationStatus("pending");
    return petSurrenderApplicationRepository.save(petSurrenderApplication);
  }


}
