package com.launchacademy.grouprework.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="creature_types")
public class CreatureTypes {
  @Id
  @SequenceGenerator(name="creature_types_generator", sequenceName="creature_types_id_seq", allocationSize = 1)
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="creature_types_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotNull
  @Column(name="type")
  private String type ;

  @NotNull
  @Column(name="description")
  private String description;

  @NotNull
  @Column(name="img_url")
  private String imgUrlType ;

//  @OneToMany(mappedBy="creatureTypes")
//  private List<Creature> creatures = new ArrayList<Creature>();
}