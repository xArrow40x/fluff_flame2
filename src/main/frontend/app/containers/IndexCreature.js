import React, { useState, useEffect } from "react";
import fetchData from "../functions/fetchData";
import AllCreaturesTile from "../components/AllCreaturesTile";

const IndexCreature = props => {
  const [creatures, setCreatures] = useState([]);
  const type = props.match.params.type;
  const apiEndpoint = `/api/v1/creature_types/${type}`;
  const fetchCreatures = () => fetchData(apiEndpoint, setCreatures);
  useEffect(fetchCreatures, []);

  const available = creatures.filter(creature => creature.adoptionStatus === "available")

  const mapCreatures = available.map(creature => {
    return(
    <AllCreaturesTile
      key={creature.id}
      imgUrl={creature.imgUrl}
      name={creature.name}
      age={creature.age}
      vacStatus={creature.vaccinationStatus}
      type={creature.creatureTypes.type}
      creatureId={creature.id}
    />)
  });

  return (
    <div>
      <h2 className="text-center">Find the {type} of your dreams!</h2>
      <div className="row small-up-1 medium-up-2 large-up-3">
        {mapCreatures}
      </div>
    </div>
  );
};

export default IndexCreature;
