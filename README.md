Prueba Técnica - Sistema de Solicitud de Crédito
Este proyecto es una prueba técnica que consiste en desarrollar un sistema para gestionar solicitudes de crédito.
La aplicación está construida con Java (Spring Boot) en el backend y ReactJS en el frontend, utilizando MongoDB como base de datos.

Requisitos previos
Antes de ejecutar la aplicación en tu equipo, asegúrate de tener instalados los siguientes programas:

Java 17

Node.js 18 o superior

MongoDB

Git

Si no deseas instalar MongoDB en tu equipo, puedes ejecutarlo con Docker.

Clonar el proyecto
Para descargar el código del proyecto, abre una terminal y ejecuta el siguiente comando:

git clone https://github.com/rogerloria/prueba-tecnica.git
cd prueba-tecnica
Ejecutar el backend (Spring Boot)
Ingresa a la carpeta del backend:

cd backend
Si usas Maven sin instalar en tu equipo, ejecuta:

mvnw clean install
Inicia la aplicación:

mvn spring-boot:run
Una vez en funcionamiento, la API estará disponible en:
http://localhost:8080

Ejecutar el frontend (React)
En una nueva terminal, ve a la carpeta del frontend:

cd frontend
Instala las dependencias del proyecto:

npm install
Inicia la aplicación:

npm run dev
La aplicación estará disponible en el navegador en:
http://localhost:5173

