package com.launchacademy.grouprework.seeders;

import com.launchacademy.grouprework.models.CreatureTypes;
import com.launchacademy.grouprework.repositories.CreatureRepository;
import com.launchacademy.grouprework.repositories.CreatureTypesRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CreatureTypeSeeder implements CommandLineRunner {
  private CreatureRepository creatureRepository;
  private CreatureTypesRepository creatureTypesRepository;

  @Autowired
  public void setCreatureRepository(CreatureRepository creatureRepository){
    this.creatureRepository=creatureRepository;
  }

  @Autowired
  public void setCreatureTypesRepository(CreatureTypesRepository creatureTypesRepository){
    this.creatureTypesRepository=creatureTypesRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    List<CreatureTypes> creatureTypesList = new ArrayList();

    CreatureTypes NyanCat = new CreatureTypes();
    NyanCat.setType("Nyan Cat");
    NyanCat.setDescription("A mystical flying space feline in the shape of a pop tart.");
    NyanCat.setImgUrlType("https://i.pinimg.com/originals/93/e4/cd/93e4cd939da891cba51e740039b4f4d2.png");

    CreatureTypes Dragon = new CreatureTypes();
    Dragon.setType("Dragon");
    Dragon.setDescription("A powerful reptile in varied sizes with magical abilities.A mystical flying space feline in the shape of a pop tart.");
    Dragon.setImgUrlType("https://i.imgur.com/0Z6wZmr.jpg");

    CreatureTypes Chimera = new CreatureTypes();
    Chimera.setType("Chimera");
    Chimera.setDescription("A fire-breathing monster with a lion head, goat body, and a serpent tail.");
    Chimera.setImgUrlType("https://i.imgur.com/7y2M1yY.jpg");

    CreatureTypes Kelpi = new CreatureTypes();
    Kelpi.setType("Kelpi");
    Kelpi.setDescription("A shape-shifting water spirit inhabiting the lochs and pools of Scotland.");
    Kelpi.setImgUrlType("https://i.quotev.com/img/q/u/17/10/12/jzdw4y5vue.jpg");

    CreatureTypes Phoenix = new CreatureTypes();
    Phoenix.setType("Phoenix");
    Phoenix.setDescription("A phoenix is a long-lived bird that cyclically regenerates or is otherwise born again.");
    Phoenix.setImgUrlType("https://i.imgur.com/StnBqkP.jpg");

    CreatureTypes Griffin = new CreatureTypes();
    Griffin.setType("Griffin");
    Griffin.setDescription("A legendary creature with the body, tail, and back legs of a lion. Once considered the \"King of Beasts\".");
    Griffin.setImgUrlType("https://i.pinimg.com/originals/80/2a/13/802a130ab2fe02ebd93eed4c68c5fed1.jpg");

    CreatureTypes Merfolk = new CreatureTypes();
    Merfolk.setType("Merfolk");
    Merfolk.setDescription("Legendary water-dwelling human-like beings.");
    Merfolk.setImgUrlType("https://i.pinimg.com/originals/31/98/6d/31986d15d7188faa4659a5ea81b5f4c3.jpg");

    creatureTypesRepository.save(NyanCat);
    creatureTypesRepository.save(Dragon);
    creatureTypesRepository.save(Chimera);
    creatureTypesRepository.save(Kelpi);
    creatureTypesRepository.save(Phoenix);
    creatureTypesRepository.save(Griffin);
    creatureTypesRepository.save(Merfolk);
  }
}
