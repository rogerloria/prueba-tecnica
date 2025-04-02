import { Link } from "react-router-dom";  // Usamos Link de React Router para la navegación
import { useState } from "react";
import "../styles/MainLayout.css"; // Los estilos no se tocan

const MainLayout = ({ children }) => {
  const [isOpen, setIsOpen] = useState(false);

  return (
    <div className="layout">
      {/* Sidebar */}
      <nav className={`sidebar ${isOpen ? "open" : ""}`}>
        <button className="toggle-btn" onClick={() => setIsOpen(!isOpen)}>
          ☰
        </button>
        <ul>
        <li><Link to="/">Inicio</Link></li>
          <li><Link to="/registro">Registrar Usuario</Link></li>
          <li><Link to="/solicitar-credito">Solicitar Crédito</Link></li>
        </ul>
      </nav>

      {/* Contenido principal */}
      <main className="content">{children}</main>
    </div>
  );
};

export default MainLayout;
