import React, { useState } from "react";

const NewCreatureForm = props => {
  const defaultForm = {
    name: "",
    phoneNumber: "",
    email: "",
    petName: "",
    petAge: "",
    petTypeId: "",
    petImgUrl: "",
    vaccinationStatus: ""
  };

  const [formState, setFormState] = useState(defaultForm);

  const clearForm = () => setFormState(defaultForm);

  const handleSubmit = event => {
    event.preventDefault();
    const formPayload = formState;
    props.addNewCreature(formPayload);
    setFormState(defaultForm);
  };

  const handleChange = event => {
    setFormState({
      ...formState,
      [event.currentTarget.id]: event.currentTarget.value
    });
  };

  return (
    <form className="new-creature-form" onSubmit={handleSubmit}>
      <h2>Surrender Your Creature</h2>
      <label>Applicant Name*:</label>
      <input
        name="name"
        id="name"
        type="text"
        value={formState.name}
        onChange={handleChange}
      />
      <label>Phone Number*:</label>
      <input
        name="phoneNumber"
        id="phoneNumber"
        type="text"
        value={formState.phoneNumber}
        onChange={handleChange}
      />
      <label>Email Address*:</label>
      <input
        name="email"
        id="email"
        type="text"
        value={formState.email}
        onChange={handleChange}
      />
      <label>Pet Name*:</label>
      <input
        name="petName"
        id="petName"
        type="text"
        value={formState.petName}
        onChange={handleChange}
      />
      <label>Pet Age*:</label>
      <input
        name="petAge"
        id="petAge"
        type="text"
        value={formState.petAge}
        onChange={handleChange}
      />
      <label>Pet Type*:</label>
      <select
        name="petType"
        id="petType"
        value={formState.petType}
        onChange={handleChange}
      >
        <option type="text" value="">
          -
        </option>
        <option type="text" value="1">
          Nyan Cat
        </option>
        <option type="text" value="2">
          Dragon
        </option>
        <option type="text" value="3">
          Chimera
        </option>
        <option type="text" value="4">
          Kelpi
        </option>
        <option type="text" value="5">
          Phoenix
        </option>
        <option type="text" value="6">
          Griffin
        </option>
        <option type="text" value="7">
          Merfolk
        </option>
      </select>
      <label>Pet Image URL*:</label>
      <input
        name="petImgUrl"
        id="petImgUrl"
        type="text"
        value={formState.petImgUrl}
        onChange={handleChange}
      />
      <label>Vaccination Status*:</label>
      <select
        name="vaccinationStatus"
        id="vaccinationStatus"
        value={formState.vaccinationStatus}
        onChange={handleChange}
      >
        <option type="text" value="">
          -
        </option>
        <option type="text" value="true">
          Yes!
        </option>
        <option type="text" value="false">
          Unfortunately, no.
        </option>
      </select>
      <div className="button-group">
        <input className="button" type="submit" value="Submit" />
        <button className="button" type="button" onClick={clearForm}>
          Clear
        </button>
      </div>
      <div>* All fields required.</div>
    </form>
  );
};

export default NewCreatureForm;
