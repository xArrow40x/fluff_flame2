package com.launchacademy.grouprework.seeders;

import com.launchacademy.grouprework.models.Creature;
import com.launchacademy.grouprework.models.CreatureTypes;
import com.launchacademy.grouprework.repositories.CreatureRepository;
import com.launchacademy.grouprework.repositories.CreatureTypesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreatureSeeder implements CommandLineRunner {
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

  @Override
  public void run(String... args) throws Exception {
    List<CreatureTypes> creatureTypesList = creatureTypesRepository.findAll();
    CreatureTypes NyanCat = creatureTypesList.get(0);

    List<Creature> creatureList = new ArrayList();

    if(creatureRepository.count()==0){
      Creature NyanNan = new Creature();
      NyanNan.setName("Nyan Nan");
      NyanNan.setImgUrl("https://upload.wikimedia.org/wikipedia/en/e/ed/Nyan_cat_250px_frame.PNG");
      NyanNan.setAge(6);
      NyanNan.setVaccinationStatus(false);
      NyanNan.setAdoptionStory("Was found at the end of a rainbow and is looking for a new sky home.");
      NyanNan.setAdoptionStatus("available");
      NyanNan.setCreatureTypes(NyanCat);

      creatureRepository.save(NyanNan);
    }
  }
}
