import React from "react";
import "../styles/HomePage.css"; // Importar el archivo de estilos

const HomePage = () => {
  return (
    <div className="homepage-container">
      <h2>¡Bienvenido a nuestra aplicación!</h2>
      <p>
        ¡Hola! Bienvenido a nuestra plataforma de gestión. Desde aquí puedes
        registrar usuarios y solicitar créditos.
      </p>
      <div className="welcome-message">
        <p>Comienza explorando el registro de usuario o solicita un crédito.</p>
      </div>
    </div>
  );
};

export default HomePage;
