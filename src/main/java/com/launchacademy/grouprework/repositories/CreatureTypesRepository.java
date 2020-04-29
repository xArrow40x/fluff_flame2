package com.launchacademy.grouprework.repositories;

import com.launchacademy.grouprework.models.CreatureTypes;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface CreatureTypesRepository extends PagingAndSortingRepository<CreatureTypes, Integer> {

}
