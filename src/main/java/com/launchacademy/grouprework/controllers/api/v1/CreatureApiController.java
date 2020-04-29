package com.launchacademy.grouprework.controllers.api.v1;

import com.launchacademy.grouprework.models.Creature;
import com.launchacademy.grouprework.repositories.CreatureRepository;
import javax.persistence.PostUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/v1/creatures")
public class CreatureApiController {

  @Autowired
  CreatureRepository creatureRepository;

  private class CreatureNotFoundException extends RuntimeException{};
  @ControllerAdvice
  private class CreatureNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(CreatureNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String urlNotFoundHandler(CreatureNotFoundException ex) {return ex.getMessage();
    }
  }

  @GetMapping
  public Page<Creature> getList(Pageable pageable){
    return (Page<Creature>) creatureRepository.findAll(pageable);
  }

  @GetMapping("/{id}")
  public Creature getIndividualItem(@PathVariable Integer id){
    return creatureRepository.findById(id).orElseThrow(() -> new CreatureNotFoundException());
  }

  @PutMapping("/{id}")
  public Creature updateCreature(@RequestBody Creature newCreature, @PathVariable Integer id){
    return creatureRepository.findById(id)
        .map(Creature -> {
          Creature.setName(newCreature.getName());
          Creature.setName(newCreature.getName());
          Creature.setName(newCreature.getName());
          Creature.setName(newCreature.getName());
          Creature.setName(newCreature.getName());
          Creature.setName(newCreature.getName());

          return creatureRepository.save(Creature);
        }).orElseThrow(() -> new CreatureNotFoundException());
  }

  @DeleteMapping("/{id}")
  public Iterable<Creature> deleteCreature(@PathVariable Integer id){
    creatureRepository.deleteById(id);
    return creatureRepository.findAll();
  }
}
