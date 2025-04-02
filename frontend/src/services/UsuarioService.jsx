// UsuarioService.js
import AuthService from './AuthService';
import axios from 'axios';

const API_URL = "http://localhost:8080/usuarios";

const UsuarioService = {
  registrarUsuario: async (usuarioData) => {
    try {
      // Verificar los encabezados antes de la solicitud
      const headers = AuthService.getAuthHeaders();
      console.log('Encabezados enviados:', headers);  // Log de los encabezados

      const response = await axios.post(API_URL, usuarioData, { headers });
      console.log('Respuesta del servidor:', response.data);  // Log de la respuesta del servidor
      return response.data;
    } catch (error) {
      console.error("Error al registrar usuario:", error);
      throw new Error("Hubo un error al registrar el usuario");
    }
  },
};

export default UsuarioService;
