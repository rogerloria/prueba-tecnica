import React, { useState } from "react";
import "../styles/CreditRequestForm.css"; // Estilos específicos del formulario
import { UsuarioService } from "../services/UsuarioService";

const UserRegistrationForm = () => {
    const [formData, setFormData] = useState({
        nombres: "",
        apellidos: "",
        correo: "",
        telefono: "",
        tipoIdentificacion: "",
        numeroIdentificacion: "",
        departamento: "",
        municipio: "",
        direccion: "",
        ingresosMensuales: "",
    });

    const [errors, setErrors] = useState({});
    const [message, setMessage] = useState(""); // Para mensajes de éxito o error

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value,
        });
    };

    const validateForm = () => {
        const newErrors = {};
        if (!formData.nombres) newErrors.nombres = "Este campo es obligatorio";
        if (!formData.apellidos) newErrors.apellidos = "Este campo es obligatorio";
        if (!formData.correo || !/\S+@\S+\.\S+/.test(formData.correo)) newErrors.correo = "Correo electrónico inválido";
        if (!formData.telefono || formData.telefono.length < 10) newErrors.telefono = "Número de teléfono inválido";
        if (!formData.tipoIdentificacion) newErrors.tipoIdentificacion = "Este campo es obligatorio";
        if (!formData.numeroIdentificacion) newErrors.numeroIdentificacion = "Este campo es obligatorio";
        if (!formData.departamento) newErrors.departamento = "Este campo es obligatorio";
        if (!formData.municipio) newErrors.municipio = "Este campo es obligatorio";
        if (!formData.direccion) newErrors.direccion = "Este campo es obligatorio";
        if (!formData.ingresosMensuales || isNaN(formData.ingresosMensuales)) newErrors.ingresosMensuales = "Debe ser un valor numérico";
        
        return newErrors;
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const validationErrors = validateForm();
        if (Object.keys(validationErrors).length === 0) {
            try {
                // Llamamos al servicio para registrar el usuario
                const response = await UsuarioService.registrarUsuario(formData);
                if (response.status === 200) {
                    setMessage("Usuario registrado con éxito");
                    // Limpiar el formulario después del registro
                    setFormData({
                        nombres: "",
                        apellidos: "",
                        correo: "",
                        telefono: "",
                        tipoIdentificacion: "",
                        numeroIdentificacion: "",
                        departamento: "",
                        municipio: "",
                        direccion: "",
                        ingresosMensuales: "",
                    });
                } else {
                    setMessage("Error al registrar el usuario. Intenta nuevamente.");
                }
            } catch (error) {
                setMessage("Hubo un error con el servidor. Intenta más tarde.");
            }
        } else {
            setErrors(validationErrors);
        }
    };

    return (
        <form onSubmit={handleSubmit} className="credit-request-form">
            <h2>Registro de Usuarios</h2>

            {/* Mensajes de éxito o error */}
            {message && <div className="message">{message}</div>}

            <div className="form-group">
                <label htmlFor="nombres">Nombres:</label>
                <input
                    type="text"
                    id="nombres"
                    name="nombres"
                    value={formData.nombres}
                    onChange={handleChange}
                    required
                />
                {errors.nombres && <span className="error">{errors.nombres}</span>}
            </div>

            <div className="form-group">
                <label htmlFor="apellidos">Apellidos:</label>
                <input
                    type="text"
                    id="apellidos"
                    name="apellidos"
                    value={formData.apellidos}
                    onChange={handleChange}
                    required
                />
                {errors.apellidos && <span className="error">{errors.apellidos}</span>}
            </div>

            <div className="form-group">
                <label htmlFor="correo">Correo electrónico:</label>
                <input
                    type="email"
                    id="correo"
                    name="correo"
                    value={formData.correo}
                    onChange={handleChange}
                    required
                />
                {errors.correo && <span className="error">{errors.correo}</span>}
            </div>

            <div className="form-group">
                <label htmlFor="telefono">Número de teléfono:</label>
                <input
                    type="tel"
                    id="telefono"
                    name="telefono"
                    value={formData.telefono}
                    onChange={handleChange}
                    required
                />
                {errors.telefono && <span className="error">{errors.telefono}</span>}
            </div>

            <div className="form-group">
                <label htmlFor="tipoIdentificacion">Tipo de identificación:</label>
                <input
                    type="text"
                    id="tipoIdentificacion"
                    name="tipoIdentificacion"
                    value={formData.tipoIdentificacion}
                    onChange={handleChange}
                    required
                />
                {errors.tipoIdentificacion && <span className="error">{errors.tipoIdentificacion}</span>}
            </div>

            <div className="form-group">
                <label htmlFor="numeroIdentificacion">Número de identificación:</label>
                <input
                    type="text"
                    id="numeroIdentificacion"
                    name="numeroIdentificacion"
                    value={formData.numeroIdentificacion}
                    onChange={handleChange}
                    required
                />
                {errors.numeroIdentificacion && <span className="error">{errors.numeroIdentificacion}</span>}
            </div>

            <div className="form-group">
                <label htmlFor="departamento">Departamento:</label>
                <input
                    type="text"
                    id="departamento"
                    name="departamento"
                    value={formData.departamento}
                    onChange={handleChange}
                    required
                />
                {errors.departamento && <span className="error">{errors.departamento}</span>}
            </div>

            <div className="form-group">
                <label htmlFor="municipio">Municipio:</label>
                <input
                    type="text"
                    id="municipio"
                    name="municipio"
                    value={formData.municipio}
                    onChange={handleChange}
                    required
                />
                {errors.municipio && <span className="error">{errors.municipio}</span>}
            </div>

            <div className="form-group">
                <label htmlFor="direccion">Dirección:</label>
                <input
                    type="text"
                    id="direccion"
                    name="direccion"
                    value={formData.direccion}
                    onChange={handleChange}
                    required
                />
                {errors.direccion && <span className="error">{errors.direccion}</span>}
            </div>

            <div className="form-group">
                <label htmlFor="ingresosMensuales">Ingresos mensuales:</label>
                <input
                    type="number"
                    id="ingresosMensuales"
                    name="ingresosMensuales"
                    value={formData.ingresosMensuales}
                    onChange={handleChange}
                    required
                />
                {errors.ingresosMensuales && <span className="error">{errors.ingresosMensuales}</span>}
            </div>

            <button type="submit">Registrar Usuario</button>
        </form>
    );
};

export default UserRegistrationForm;
