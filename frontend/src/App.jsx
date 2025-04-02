import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import MainLayout from "./layouts/MainLayout";
import UserRegistrationForm from "./components/UserRegistrationForm";
import CreditRequestForm from "./components/CreditRequestForm";
import HomePage from "./pages/HomePage";

const App = () => {
  return (
    <Router>
      <MainLayout>
        <Routes>
           {/* Ruta de Inicio */}
           <Route path="/" element={<HomePage />} />

          {/* Definimos las rutas y sus componentes */}
          <Route path="/registro" element={<UserRegistrationForm />} />
          <Route path="/solicitar-credito" element={<CreditRequestForm />} />
        </Routes>
      </MainLayout>
    </Router>
  );
};

export default App;
