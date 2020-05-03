package com.launchacademy.grouprework.seeders;

import com.launchacademy.grouprework.models.Creature;
import com.launchacademy.grouprework.models.CreatureTypes;
import com.launchacademy.grouprework.repositories.CreatureRepository;
import com.launchacademy.grouprework.repositories.CreatureTypesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatureSeeder{
  private CreatureRepository creatureRepository;
  private CreatureTypesRepository creatureTypesRepository;

  @Autowired
  public void setCreatureTypesRepository(CreatureTypesRepository creatureTypesRepository){
    this.creatureTypesRepository=creatureTypesRepository;
  }

  @Autowired
  public void setCreatureRepository(CreatureRepository creatureRepository){
    this.creatureRepository=creatureRepository;
  }

  public void seed() {
    List<CreatureTypes> creatureTypesList = creatureTypesRepository.findAll();
    CreatureTypes NyanCat = creatureTypesList.get(0);
    CreatureTypes Dragon = creatureTypesList.get(1);

    List<Creature> creatureList = new ArrayList();
    Creature creature1 = new Creature();
    creature1.setName("Nyan Nan");
    creature1.setImgUrl("https://upload.wikimedia.org/wikipedia/en/e/ed/Nyan_cat_250px_frame.PNG");
    creature1.setAge(6);
    creature1.setVaccinationStatus(false);
    creature1.setAdoptionStory("Was found at the end of a rainbow and is looking for a new sky home.");
    creature1.setAdoptionStatus("available");
    creature1.setCreatureTypes(creatureTypesRepository.findByType("Nyan Cat"));
    creatureList.add(creature1);

    Creature creature2 = new Creature();
    creature2.setName("'Shenron',");
    creature2.setImgUrl("https://i7.pngguru.com/preview/1013/312/896/shenron-goku-frieza-vegeta-dragon-ball-dragon.jpg");
    creature2.setAge(470);
    creature2.setVaccinationStatus(true);
    creature2.setAdoptionStory("He shall grant 3 wishes to anyone who finds all 7 of his Dragon Balls and recites the secret password.");
    creature2.setAdoptionStatus("available");
    creature2.setCreatureTypes(creatureTypesRepository.findByType("Dragon"));
    creatureList.add(creature2);

    if (creatureRepository.count() == 0) {
      for (Creature creature : creatureList) {
        creatureRepository.save(creature);
      }
    }
  }
}