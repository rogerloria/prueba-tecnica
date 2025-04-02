import { useState } from "react";
import "../styles/MainLayout.css";

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
                    <li><a href="#">Inicio</a></li>
                    <li><a href="#">Solicitar Crédito</a></li>
                </ul>
            </nav>

            {/* Contenido principal */}
            <main className="content">{children}</main>
        </div>
    );
};

export default MainLayout;
