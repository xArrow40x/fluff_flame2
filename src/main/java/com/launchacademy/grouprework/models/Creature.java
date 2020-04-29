package com.launchacademy.grouprework.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="adoptable_creatures")
public class Creature {
  @Id
  @SequenceGenerator(name="adoptable_creatures_generator", sequenceName="adoptable_creatures_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="adoptable_creatures_generator")
  @Column(name = "id", nullable = false, unique = true)
  private Integer id;

  @NotNull
  @Column(name="name")
  private String name;

  @NotNull
  @Column(name="creature_img")
  private String imgUrl;

  @NotNull
  @Min(value = 0)
  @Column(name="age")
  private Integer age;

  @NotNull
  @Column(name="vaccination_status")
  private boolean vaccinationStatus;

  @NotNull
  @Column(name="adoption_story")
  private String adoptionStory;

  @NotNull
  @Column(name="adoption_status")
  private String adoptionStatus;

  @NotNull
  @ManyToOne
  @JoinColumn(name="type_id", nullable=false)
  private CreatureTypes creatureTypes;

  @Column(name="type_id", insertable = false, updatable = false)
  private Integer typeId;
}
