package com.launchacademy.grouprework.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="pet_surrender_applications")
public class PetSurrenderApplication {
  @Id
  @SequenceGenerator(name="pet_surrender_applications_generator", sequenceName="pet_surrender_applications_id_seq", allocationSize = 1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pet_surrender_applications_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotNull
  @Column(name="name")
  private String name;

  @NotNull
  @Column(name="phone_number")
  private String phoneNumber;

  @NotNull
  @Email
  @Column(name="email")
  private String email;

  @NotNull
  @Column(name="pet_name")
  private String petName;

  @NotNull
  @Min(value=0)
  @Column(name="pet_age")
  private Integer petAge;

  @NotNull
  @Column(name="pet_type_id")
  private Integer petTypeId;

  @NotNull
  @Column(name="pet_img_url")
  private String petImgUrl;

  @NotNull
  @Column(name="vaccination_status")
  private boolean vaccinationStatus;
}