# Petshop
Parcial TP3

Petshop App TP3 es una aplicación móvil nativa para Android desarrollada para PetLovers, una empresa
especializada en la venta de productos para mascotas.
Este proyecto representa el lanzamiento de su primera aplicación pública, con el objetivo de digitalizar 
y optimizar su canal de ventas, tanto para clientes finales como para revendedores.


Tecnologías Utilizadas:
-Kotlin             Lenguaje principal.
-Jetpack Compose    UI declarativa moderna para Android.
-Retrofit           Cliente HTTP para consumo de API REST.
-Hilt               Inyección de dependencias.
-MVVM               Arquitectura para separar UI y lógica de negocio.
-Material 3         Estilo visual moderno.
-Room               Base de datos local para persistencia de datos offline.
-Firebase           Plataforma de backend utilizada para Firestore como base de datos en la nube, 
autenticación y otros servicios escalables.


API y Consumo de Datos:
La aplicación se comunica con Firebase como backend para gestionar:
Registro y autenticación de usuarios.
Validación de credenciales durante el inicio de sesión en tiempo real.

Los usuarios pueden crear su propia cuenta directamente desde la aplicación, y las credenciales 
se verifican utilizando Firebase Authentication.

Usuario de prueba disponible:
    Usuario: kevin@hotmail.com    Contraseña: kevin1234@
En caso de credenciales incorrectas, se muestran mensajes de error al usuario.
Tras un inicio de sesión exitoso, se navega automáticamente a la pantalla principal.


La aplicación consume la API pública DummyJSON disponible en: https://dummyjson.com/
API Endpoints
GET /carts/1

Equipo de Trabajo
    -Kevin Vuylsteke
