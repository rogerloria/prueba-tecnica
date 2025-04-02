// AuthService.js
const AuthService = {
    // Este método devuelve los encabezados que requieren las solicitudes
    getAuthHeaders() {
      return {
        'API_KEY': 'prueba-tecnica-llave-secreta',  
        'Content-Type': 'application/json',
      };
    },
  };
  
  export default AuthService;
  