package com.launchacademy.grouprework.repositories;

import com.launchacademy.grouprework.models.Creature;
import com.launchacademy.grouprework.models.CreatureTypes;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@Repository
public interface CreatureTypesRepository extends PagingAndSortingRepository<CreatureTypes, Integer> {
  public List<CreatureTypes> findAll();

  CreatureTypes findByType(String type);
  public List<Creature> findAllByType(String type);
}
