package com.launchacademy.grouprework.repositories;

import com.launchacademy.grouprework.models.Creature;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CreatureRepository extends PagingAndSortingRepository<Creature, Integer> {
}
