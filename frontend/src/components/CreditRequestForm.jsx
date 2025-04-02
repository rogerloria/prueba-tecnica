import React, { useState } from "react";
import "../styles/UserRegistrationForm.css"; // Usamos los mismos estilos

const CreditRequestForm = ({ onSubmit }) => {
  const [formData, setFormData] = useState({
    usuarioId: "",
    fechaSolicitud: "",
    estado: "pendiente", // Valor predeterminado
  });

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    onSubmit(formData);
  };

  return (
    <form className="user-registration-form" onSubmit={handleSubmit}> 
      <h2>Solicitud de Crédito</h2>
      <label htmlFor="usuarioId">ID de Usuario</label>
      <input
        type="text"
        name="usuarioId"
        value={formData.usuarioId}
        onChange={handleChange}
        required
      />

      <label htmlFor="fechaSolicitud">Fecha de Solicitud</label>
      <input
        type="date"
        name="fechaSolicitud"
        value={formData.fechaSolicitud}
        onChange={handleChange}
        required
      />
      
      <div className="form-button-container">
        <button type="submit">Enviar Solicitud</button>
      </div>
    </form>
  );
};

export default CreditRequestForm;
