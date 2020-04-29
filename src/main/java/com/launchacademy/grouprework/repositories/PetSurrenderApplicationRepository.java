package com.launchacademy.grouprework.repositories;

import com.launchacademy.grouprework.models.PetSurrenderApplication;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetSurrenderApplicationRepository extends PagingAndSortingRepository<PetSurrenderApplication, Integer> {

}
