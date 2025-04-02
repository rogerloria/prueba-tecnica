import axios from "axios";

// Definir la URL del backend
const API_URL = "http://localhost:8080/solicitudes"; // La URL para el registro de usuarios

// Crear el servicio
const SolicitudService = {
  // Método para registrar usuario
  async registrarSolicitud(solicitudData) {
    try {
      const response = await axios.post(API_URL, solicitudData);
      return response.data; // Retorna la respuesta del servidor (puede ser un mensaje de éxito)
    } catch (error) {
      throw new Error("Hubo un error al registrar el usuario");
    }
  },
};

export default SolicitudService;
