package com.launchacademy.grouprework.dtos;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class PetSurrenderApplicationDto {
  private String name;
  private String phoneNumber;
  private String email;
  private String petName;
  private String petAge;
  private String petType;
  private String petImgUrl;
  private Boolean vaccinationStatus;
}