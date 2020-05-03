package com.launchacademy.grouprework.repositories;

import com.launchacademy.grouprework.models.Creature;
import com.launchacademy.grouprework.models.CreatureTypes;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@Repository
public interface CreatureRepository extends PagingAndSortingRepository<Creature, Integer> {

  List<Creature> findAll();
//  List<Creature> findAllByType(@Param("type") String types);
//
  @Query("SELECT a FROM Creature a JOIN CreatureTypes p ON a.typeId = p.id WHERE p.type = :type AND a.id = :id")
  public Creature findByTypeAndId(@Param("type") String type, @Param("id") Integer id);

  @Query("SELECT a FROM Creature a JOIN CreatureTypes p ON a.typeId = p.id WHERE p.type = :type")
  public List<Creature> findByType(@Param("type") String type);
}
