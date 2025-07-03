# Petshop
Parcial TP3

Petshop App TP3 es una aplicación móvil nativa para Android desarrollada para PetLovers,
una empresa dedicada a la venta de productos para mascotas. 
Este proyecto marca el lanzamiento de su primera app pública, con el objetivo de digitalizar 
y potenciar su canal de ventas tanto para clientes particulares como para revendedores.
La aplicación permite a los usuarios registrarse y gestionar su perfil de acuerdo a su rol:
- Usuarios Finales: Navegan por categorías, arman un carrito, realizan compras y hacen seguimiento 
de sus pedidos.
- Revendedores: Acceden a una experiencia adaptada con precios mayoristas, historial de compras 
comerciales y beneficios exclusivos.
La interfaz de usuario se implementa a partir del diseño completo proporcionado en Figma por la 
empresa PetLovers, que actúa como guía visual de todas las pantallas y componentes.

Tecnologías Utilizadas:
- Kotlin: Lenguaje de programación principal.
- Jetpack Compose: Framework moderno para construir interfaces en Android de manera declarativa.
- Retrofit: Cliente HTTP para consumir la API REST que gestiona autenticación, registro y 
operaciones con usuarios.
- Hilt: Framework de inyección de dependencias que facilita la gestión y provisión de componentes 
y servicios dentro de la aplicación.
- MVVM: Patrón arquitectónico utilizado para separar la lógica de negocio y la UI.
- Material 3: Diseño visual moderno y adaptativo.

API y Consumo de Datos:
La app se comunica con una API REST externa para gestionar:
Registro y autenticación de usuarios.
Validación de credenciales durante el login.

Usuarios:
Usuarios de prueba disponibles para login:
    Usuario: kevinryan    Contraseña: kev02937@
    Usuario: kate_h       Contraseña: kfejk@*_
La validación de credenciales se realiza contra la API REST en tiempo real mediante Retrofit, 
mostrando mensajes de error.
Tras un login exitoso, se navega a la pantalla principal .

La aplicación consume la API pública FakeStoreAPI https://fakestoreapi.com/
API Endpoints
    Registro de Usuario     POST /users
    Login de Usuario        POST /auth/login

Equipo de Trabajo
    -Kevin Vuylsteke
    -Facundo Martinez
