# Renewable Energies Backend

![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven&logoColor=white)
![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?logo=openjdk&logoColor=white)
![MariaDB](https://img.shields.io/badge/MariaDB-003545?logo=mariadb&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?logo=springboot&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6DB33F?logo=springsecurity&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-6DB33F?logo=spring&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?logo=json-web-tokens&logoColor=white)
![Licencia GPL-3.0](https://img.shields.io/badge/licencia-GPL%20v3-blue)

Renewable Energy Backend se encarga de gestionar y exponer los datos relacionados con la producción y consumo de energías renovables a nivel global. A través de un conjunto de APIs RESTful construidas con Spring Boot, el sistema permite gestionar usuarios, ubicaciones y registros de energía, realizando operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las entidades clave.

La arquitectura del backend está diseñada para ser flexible, escalable y segura, proporcionando una plataforma robusta para interactuar con datos almacenados en una base de datos, accesibles mediante solicitudes HTTP. Además, se implementa autenticación basada en JWT para asegurar las operaciones sensibles.

### Componentes Clave del Backend
#### 1. Gestión de Usuarios

**Funcionalidad**: El sistema permite gestionar la información de los usuarios, incluyendo el registro, la autenticación mediante JWT, y la actualización de sus datos.

Operaciones CRUD:

- POST /user: Registrar un nuevo usuario.

- POST /user/login: Autenticación de un usuario mediante su nombre de usuario y contraseña, generando un token JWT.

- GET /user: Obtener todos los usuarios registrados.

- GET /user/id: Obtener un usuario específico mediante su ID.

- PUT /user/id: Actualizar la información del usuario.

- DELETE /user/id: Eliminar un usuario de la base de datos.


#### 2. Gestión de Ubicaciones

**Funcionalidad**: Administra las ubicaciones (países) donde se monitorean los datos de energía renovable.

Operaciones CRUD:

- POST /location: Crear una nueva ubicación (país).

- GET /location: Obtener una lista de todas las ubicaciones (países).

- GET /location/id: Obtener información detallada de una ubicación por su ID.

- PUT /location/id: Actualizar la información de una ubicación.

- DELETE /location/id: Eliminar una ubicación.

#### 3. Gestión de Producción de Energía

**Funcionalidad**: Permite registrar y gestionar los datos de producción de energía renovable en las diferentes ubicaciones.

Operaciones CRUD:

- POST /production: Registrar un nuevo valor de producción de energía.

- GET /production: Obtener todos los registros de producción de energía.

- GET /production/id: Obtener un registro específico de producción de energía.

- PUT /production/id: Actualizar un registro existente de producción de energía.

- DELETE /production/id: Eliminar un registro de producción de energía.

#### 4. Gestión de Consumo de Energía

**Funcionalidad**: Administra los datos relacionados con el consumo de energía renovable a nivel global.

Operaciones CRUD:

- POST /consumption: Registrar un nuevo valor de consumo de energía.

- GET /consumption: Obtener todos los registros de consumo de energía.

- GET /consumption/id: Obtener un registro específico de consumo de energía.

- PUT /consumption/id: Actualizar un registro de consumo de energía.

- DELETE /consumption/id: Eliminar un registro de consumo de energía.

#### 5. Consultas Avanzadas sobre Energía

**Funcionalidad**: Proporciona consultas avanzadas sobre los datos de producción y consumo de energía renovable, permitiendo filtrar los resultados por tipo de energía (solar, eólica, hidroeléctrica), país y año.

Operaciones CRUD:

- GET /energy: Consultar datos filtrados por tipo de energía y año (si se especifica). La respuesta es paginada.

- GET /energy/page/type: Consultar los datos de energía por página y tipo de energía.

- GET /energy/page/type/year: Consultar los datos de energía por página, tipo de energía y año.


### Tecnologías y Herramientas Utilizadas:
**Spring Boot**: Framework principal para desarrollar las APIs RESTful del backend, proporcionando una arquitectura robusta y fácil de mantener.

**Spring Security**: Se utiliza para gestionar la seguridad del sistema, implementando autenticación basada en JWT (JSON Web Tokens) para proteger las rutas y asegurar que solo los usuarios autenticados puedan realizar ciertas acciones.
    
**Spring Data JPA**: Para la persistencia de los datos en la base de datos, utilizando JPA (Java Persistence API), lo que facilita las operaciones de consulta y manipulación de datos.

**H2 Database / MySQL**: Se puede utilizar una base de datos en memoria (H2) para desarrollo o una base de datos relacional (MySQL) para producción, que almacena los datos de usuarios, ubicaciones, producción y consumo de energía.

**DTOs (Data Transfer Objects)**: Se emplean para transferir datos entre las capas de la aplicación de forma eficiente y segura. Ejemplos incluyen EnergyDTO para mostrar los registros de energía y UserLogin para los datos de autenticación.
    
**Maven**: Herramienta de gestión de dependencias y construcción del proyecto.

### Paginación y Filtrado:

Para garantizar un rendimiento adecuado y manejar grandes volúmenes de datos, las respuestas de las consultas se manejan mediante paginación. Esto significa que los resultados de las consultas sobre producción y consumo de energía se dividen en páginas, limitando la cantidad de datos procesados en una sola consulta.

### Seguridad y Autenticación

**JWT (JSON Web Token)**: El sistema implementa autenticación y autorización basada en JWT, un mecanismo popular y seguro para manejar la autenticación sin necesidad de mantener el estado entre el cliente y el servidor.

Spring Security se integra para gestionar los aspectos de seguridad, como la protección contra accesos no autorizados y la validación de las credenciales de los usuarios.

## Instalación
Para instalar y ejecutar el proyecto, sigue estos pasos:
```bash
# Clona el repositorio
git clone git@github.com:soydz/renewableEnergiesBackend.git

# Ingresar a la carpeta renewableEnergiesFrontend
cd renewableEnergiesFrontend
```

### Modifica el archivo ejemplo.properties
lo renombramos a application.properties

cambiamos lo siguiente:

- spring.datasource.url = la url de nuestra base de datos

- spring.datasource.username = el username de la base de datos

- spring.datasource.password = el password del usuario

- jwt.secret = ingresamos una clave secreta para la firma de token

Un ejemplo de como podria quedar el archivo:
```
spring.application.name = mysql-java
spring.datasource.url = jdbc:mysql://localhost:3306/miDB
spring.datasource.username = user
spring.datasource.password = root
spring.jpa.hibernate.ddl-auto = none
spring.jpa.properties.hibernate.format_sql = true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
jwt.secret=miClaveSecreta#$644
```
```bash
# Instalar dependencias
mvn install

# Ejecutar el proyecto
mvn spring-boot:run
```

```bash
# Accede a la aplicación en http://localhost:8080 usando los EndPoints
```


# Documentación API

Documentación detallada de los controladores a través de los enlaces.

#### Controladores:

- [UserController](#usercontroller)
- [LocationController](#locationcontroller)
- [ProductionEnergyController](#productionenergycontroller)
- [ConsumptionEnergyController](#consumptionenergycontroller)
- [EnergyDTOController](#energydtocontroller)
---

## UserController
Esta API permite gestionar los usuarios, incluyendo la creación, obtención, actualización, eliminación y autenticación.

### Base URL

La base URL para todas las rutas es: http://localhost:8080/user


## Endpoints

### 1. Crear un nuevo Usuario
**URL**: `/user`  
**Método HTTP**: `POST`

**Descripción**:  
Crea un nuevo usuario en la base de datos.

**Cuerpo de la solicitud**:

```json
{
  "username": "usuario123",
  "password": "password123",
  "email": "usuario123@example.com",
  "firstName": "Juan",
  "lastName": "Pérez"
}
```

Respuesta exitosa (201):
```json
{
  "username": "usuario123",
  "password": "password123",
  "email": "usuario123@example.com",
  "firstName": "Juan",
  "lastName": "Pérez"
}
```

Respuestas de error: 

409 Conflict
```json
{
  "message": "Usuario ya existe"
}
```

### 2. Iniciar sesión

**URL**: `/user/login`  
**Método HTTP**: `POST`

**Descripción**:
Autentica a un usuario y devuelve un token de acceso.

**Cuerpo de la solicitud**:
```json
{
  "username": "usuario123",
  "password": "password123"
}
```

Respuesta exitosa (200):
```json
{
  "token": "jwt_token_aqui"
}
```
Respuestas de error: 

401 Unauthorized
```json
{
  "message": "Credenciales inválidas"
}
```

### 3. Obtener todos los usuarios

**URL**: `/user/`  
**Método HTTP**: `GET`

**Descripción**:
Obtiene una lista de todos los usuarios registrados.

Respuesta exitosa (200):
```json
[
  {
    "username": "usuario123",
    "password": "password123",
    "email": "usuario123@example.com",
    "firstName": "Juan",
    "lastName": "Pérez"
  },
  {
    "username": "usuario456",
    "password": "password456",
    "email": "usuario456@example.com",
    "firstName": "Ana",
    "lastName": "García"
  }
]
```

### 4. Obtener un usuario por ID (nombre de usuario)

**URL**: `/user/id`  
**Método HTTP**: `Get`

**Descripción**:
Obtiene la información de un usuario específico por su nombre de usuario.

**Parámetros**: 

    id: El nombre de usuario del usuario a buscar.

Respuesta exitosa (200):
```json
{
  "username": "usuario123",
  "password": "password123",
  "email": "usuario123@example.com",
  "firstName": "Juan",
  "lastName": "Pérez"
}
```
Respuestas de error:

404 Not Found: Si no se encuentra el usuario con el nombre de usuario proporcionado.
```json
{
  "message": "Usuario no encontrado"
}
```

### 5. Actualizar un usuario

**URL**: `/user`  
**Método HTTP**: `PUT`

**Descripción**:
Actualiza la información de un usuario existente. El cuerpo de la solicitud debe contener los nuevos datos del usuario.

**Cuerpo de la solicitud**:
```json
{
  "username": "usuario123",
  "password": "newPassword123",
  "email": "usuario123_new@example.com",
  "firstName": "Juan",
  "lastName": "Pérez"
}
```
Respuesta exitosa (200):
```json
{
  "token": "jwt_token_aqui"
}
```
Respuestas de error:

400 Bad Request: Si los datos proporcionados son incorrectos.

404 Not Found: Si el usuario no existe.

### 6. Eliminar un usuario

**URL**: `/user/id`  
**Método HTTP**: `DELETE`

**Descripción**:
Elimina un usuario por su nombre de usuario.

**Parámetros**:

    id: El nombre de usuario del usuario que se va a eliminar.

Respuesta exitosa (204):

Respuestas de error: 

404 Not Found: Si el usuario no existe.
```json
{
  "message": "Usuario no encontrado"
}
```

### Seguridad

La API de autenticación (/login) utiliza JWT (JSON Web Tokens) para la autenticación. El token recibido después de un inicio de sesión exitoso debe ser incluido en las solicitudes que requieran autenticación mediante el encabezado Authorization.

Ejemplo de encabezado para solicitudes autenticadas:

Authorization: Bearer jwt_token_aqui


## LocationController

Esta API permite gestionar las ubicaciones, incluyendo la creación, obtención, actualización, eliminación y búsqueda de ubicaciones por nombre y año.

## Base URL

La base URL para todas las rutas es:

http://localhost:8080/location


## Endpoints

### 1. Crear una nueva Ubicación
**URL**: `/location`  
**Método HTTP**: `POST`

**Descripción**:  
Crea una nueva ubicación en la base de datos.

**Cuerpo de la solicitud**:

```json
{
  "name": "Ubicación A",
  "year": 2023
}
```
Respuesta exitosa (201):
```json

{
  "id": 1,
  "name": "Ubicación A",
  "year": 2023
}
```
Respuestas de error: 

409 Conflict: La ubicación ya existe o hay un conflicto en los datos.
```json
{
  "message": "Ubicación ya existente o conflicto en los datos"
}
```
### 2. Obtener todas las ubicaciones

**URL**: `/location`  
**Método HTTP**: `GET`

**Descripción**:
Obtiene una lista de todas las ubicaciones registradas.

Respuesta exitosa (200):
```json
[
  {
    "id": 1,
    "name": "Ubicación A",
    "year": 2023
  },
  {
    "id": 2,
    "name": "Ubicación B",
    "year": 2022
  }
]
```

### 3. Obtener una ubicación por ID

**URL**: `/location/id`  
**Método HTTP**: `GET`

**Descripción**:
Obtiene la información de una ubicación específica por su ID.

**Parámetros**:

    id: El ID de la ubicación a buscar.

Respuesta exitosa (200):
```json
{
  "id": 1,
  "name": "Ubicación A",
  "year": 2023
}
```

Respuestas de error:

404 Not Found: Si no se encuentra la ubicación con el ID proporcionado.
```json
{
  "message": "Ubicación no encontrada"
}
```

### 4. Actualizar una ubicación

**URL**: `/location/id`  
**Método HTTP**: `PUT`

**Descripción**:
Actualiza los datos de una ubicación existente.

**Parámetros**:

    id: El ID de la ubicación a actualizar.

**Cuerpo de la solicitud**:
```json
{
  "name": "Ubicación Actualizada",
  "year": 2024
}
```

Respuesta exitosa (200):
```json
{
  "id": 1,
  "name": "Ubicación Actualizada",
  "year": 2024
}
```

Respuestas de error:

400 Bad Request: Si los datos proporcionados no son válidos.

404 Not Found: Si no se encuentra la ubicación con el ID proporcionado.

### 5. Eliminar una ubicación

**URL**: `/location/id`  
**Método HTTP**: `DELETE`

**Descripción**:
Elimina una ubicación por su ID.

**Parámetros**:

    id: El ID de la ubicación que se va a eliminar.

Respuesta exitosa (204):

Respuestas de error:

404 Not Found: Si no se encuentra la ubicación con el ID proporcionado.
```json
{
  "message": "Ubicación no encontrada"
}
```

### 6. Buscar ubicaciones por nombre y año

**URL**: `/location/id/year`  
**Método HTTP**: `GET`

**Descripción**:
Busca una ubicación por su nombre y año.

**Parámetros**:

    name: El nombre de la ubicación a buscar.
    year: El año de la ubicación a buscar.

Respuesta exitosa (200):
```json
{
  "id": 1,
  "name": "Ubicación A",
  "year": 2023
}
```

Respuestas de error:

404 Not Found: Si no se encuentra ninguna ubicación que coincida con el nombre y año proporcionados.
```json
{
  "message": "Ubicación no encontrada"
}
```

## ProductionEnergyController

Esta API permite gestionar la producción de energía, incluyendo la creación, obtención, actualización y eliminación de los registros de producción de energía.

## Base URL

La base URL para todas las rutas es:

http://localhost:8080/production


## Endpoints

### 1. Crear un nuevo registro de Producción de Energía
**URL**: `/production`  
**Método HTTP**: `POST`

**Descripción**:  
Crea un nuevo registro de producción de energía. El cuerpo de la solicitud debe incluir los datos necesarios para la producción de energía.

**Cuerpo de la solicitud**:

```json
{
  "locationId": 1,
  "value": 120.5
}
```
Respuesta exitosa (201):
```json
{
  "id": 1,
  "locationId": 1,
  "value": 120.5
}
```
Respuestas de error:

409 Conflict: Si ya existe un registro de producción con los mismos datos o hay un conflicto en los datos.
```json
{
  "message": "Conflicto al crear el registro de producción"
}
```
### 2. Obtener todos los registros de Producción de Energía

**URL**: `/production`  
**Método HTTP**: `GET`

**Descripción**:
Obtiene una lista de todos los registros de producción de energía.

Respuesta exitosa (200):
```json
[
  {
    "id": 1,
    "locationId": 1,
    "value": 120.5
  },
  {
    "id": 2,
    "locationId": 2,
    "value": 135.0
  }
]
```
### 3. Obtener un registro de Producción de Energía por ID

**URL**: `/production/id`  
**Método HTTP**: `GET`

**Descripción**:
Obtiene un registro específico de producción de energía por su ID.

**Parámetros**:

    id: El ID del registro de producción de energía.

Respuesta exitosa (200):
```json
{
  "id": 1,
  "locationId": 1,
  "value": 120.5
}
```
Respuestas de error:

404 Not Found: Si no se encuentra el registro de producción con el ID proporcionado.
```json
{
  "message": "Registro de producción no encontrado"
}
```

### 4. Actualizar un registro de Producción de Energía

**URL**: `/production/id`  
**Método HTTP**: `PUT`

**Descripción**:
Actualiza los datos de un registro de producción de energía existente.

**Parámetros**:

    id: El ID del registro de producción de energía que se va a actualizar.

**Cuerpo de la solicitud**:
```json
{
  "value": 130.0
}
```

Respuesta exitosa (200):
```json
{
  "id": 1,
  "locationId": 1,
  "value": 130.0
}
```

Respuestas de error:

400 Bad Request: Si los datos proporcionados no son válidos.

404 Not Found: Si no se encuentra el registro de producción con el ID proporcionado.

### 5. Eliminar un registro de Producción de Energía

**URL**: `/production/id`  
**Método HTTP**: `DELETE`

**Descripción**:
Elimina un registro de producción de energía por su ID.

**Parámetros**:

    id: El ID del registro de producción que se va a eliminar.

Respuesta exitosa (204):

Respuestas de error:

404 Not Found: Si no se encuentra el registro con el ID proporcionado.
```json
{
  "message": "Registro de producción no encontrado"
}
```

## ConsumptionEnergyController

Esta es la documentación de los endpoints para gestionar los registros de consumo de energía en la API del backend de **Renewable Energies**.

## Base URL

La base URL para todas las rutas es:

http://localhost:8080/consumption


## Endpoints

### 1. Crear un nuevo registro de Consumo de Energía
**URL**: `/consumption`  
**Método HTTP**: `POST`

**Descripción**:  
Crea un nuevo registro de consumo de energía.

**Cuerpo de la solicitud**:

```json
{
  "locationId": 1,
  "value": 100.5
}
```
    locationId: El ID de la ubicación donde se registró el consumo de energía.
    value: El valor de consumo de energía (en kWh, por ejemplo).

Respuesta exitosa (201):
```json
{
  "id": 1,
  "locationId": 1,
  "value": 100.5
}
```
Respuestas de error:

409 Conflict: Si ya existe un registro de consumo con los mismos datos o hay un conflicto en los datos.
```json
{
  "message": "Conflicto al crear el registro de consumo"
}
```

### 2. Obtener todos los registros de Consumo de Energía

**URL**: `/consumption`  
**Método HTTP**: `GET`

**Descripción**:
Obtiene una lista de todos los registros de consumo de energía.

Respuesta exitosa (200):
```json
[
  {
    "id": 1,
    "locationId": 1,
    "value": 100.5
  },
  {
    "id": 2,
    "locationId": 2,
    "value": 115.0
  }
]
```
### 3. Obtener un registro de Consumo de Energía por ID

**URL**: `/consumption/id`  
**Método HTTP**: `GET`

**Descripción**:
Obtiene un registro específico de consumo de energía por su ID.

**Parámetros**:

    id: El ID del registro de consumo de energía a buscar.

Respuesta exitosa (200):
```json
{
  "id": 1,
  "locationId": 1,
  "value": 100.5
}
```
Respuestas de error:

404 Not Found: Si no se encuentra el registro de consumo con el ID proporcionado.
```json
{
  "message": "Registro de consumo no encontrado"
}
```

### 4. Actualizar un registro de Consumo de Energía

**URL**: `/consumption/id`  
**Método HTTP**: `PUT`

**Descripción**:
Actualiza un registro de consumo de energía existente.

**Parámetros**:

    id: El ID del registro de consumo de energía a actualizar.

**Cuerpo de la solicitud**:
```json
{
  "value": 120.0
}
```

    value: El nuevo valor de consumo de energía (en kWh, por ejemplo).

Respuesta exitosa (200):
```json
{
  "id": 1,
  "locationId": 1,
  "value": 120.0
}
```

Respuestas de error:

400 Bad Request: Si los datos proporcionados no son válidos.

404 Not Found: Si no se encuentra el registro de consumo con el ID proporcionado.

### 5. Eliminar un registro de Consumo de Energía

**URL**: `/consumption/id`  
**Método HTTP**: `DELETE`

**Descripción**:
Elimina un registro de consumo de energía por su ID.

**Parámetros**:

    id: El ID del registro de consumo de energía a eliminar.

Respuesta exitosa (204):

Respuestas de error:

404 Not Found: Si no se encuentra el registro con el ID proporcionado.
```json
{
  "message": "Registro de consumo no encontrado"
}
```

## EnergyDTOController

Esta es la documentación de los endpoints para gestionar la información de energía en la API del backend de **Renewable Energies**.

## Base URL

La base URL para todas las rutas es:

http://localhost:8080/energy


## Endpoints

### 1. Obtener datos de energía por tipo y año
**URL**: `/energy`  
**Método HTTP**: `GET`

**Descripción**:  
Obtiene una lista de datos de energía filtrados por tipo de energía y año. Si el año es `0`, no se filtra por año.

**Parámetros de consulta**:
- `page`: El número de la página que se desea obtener (paginación).
- `typeEnergy`: El tipo de energía (por ejemplo, solar, eólica, etc.).
- `year`: El año para filtrar los datos de energía (si `year` es `0`, no se realiza el filtro por año).

**Ejemplo de solicitud**:

GET /energy?page=1&typeEnergy=SOLAR&year=2023


**Respuesta exitosa (200)**:

```json
{
  "content": [
    {
      "id": 1,
      "typeEnergy": "SOLAR",
      "year": 2020,
      "value": 150.5
    },
    {
      "id": 2,
      "typeEnergy": "SOLAR",
      "year": 2020,
      "value": 130.0
    }
  ],
  "totalPages": 5,
  "totalElements": 50,
  "size": 10,
  "number": 1,
  "numberOfElements": 2,
  "first": false,
  "last": false,
  "empty": false
}
```

Respuestas de error:

400 Bad Request: Si los parámetros son inválidos o faltan.

### 2. Obtener datos de energía por página

**URL**: `/energy/page`  
**Método HTTP**: `GET`

**Descripción**:
Obtiene una lista de datos de energía para una página específica, sin aplicar ningún filtro por tipo o año.

**Parámetros**:

    page: El número de la página que se desea obtener.

**Ejemplo de solicitud**:

GET /energy/1

Respuesta exitosa (200):
```json
{
  "content": [
    {
      "id": 1,
      "typeEnergy": "SOLAR",
      "year": 2020,
      "value": 150.5
    },
    {
      "id": 2,
      "typeEnergy": "EOLICA",
      "year": 2020,
      "value": 200.0
    }
  ],
  "totalPages": 5,
  "totalElements": 50,
  "size": 10,
  "number": 1,
  "numberOfElements": 2,
  "first": false,
  "last": false,
  "empty": false
}
```
### 3. Obtener datos de energía por tipo de energía

**URL**: `/energy/page/type`  
**Método HTTP**: `GET`

**Descripción**:
Obtiene una lista de datos de energía filtrados por tipo de energía en una página específica.

**Parámetros**:

    page: El número de la página que se desea obtener.
    type: El tipo de energía (por ejemplo, solar, eólica, etc.).

Ejemplo de solicitud:

GET /energy/1/SOLAR

Respuesta exitosa (200):
```json
{
  "content": [
    {
      "id": 1,
      "typeEnergy": "SOLAR",
      "year": 2020,
      "value": 150.5
    },
    {
      "id": 2,
      "typeEnergy": "SOLAR",
      "year": 2020,
      "value": 130.0
    }
  ],
  "totalPages": 5,
  "totalElements": 50,
  "size": 10,
  "number": 1,
  "numberOfElements": 2,
  "first": false,
  "last": false,
  "empty": false
}
```

### 4. Obtener datos de energía por tipo y año

**URL**: `/energy/page/type/year`  
**Método HTTP**: `GET`

**Descripción**:
Obtiene una lista de datos de energía filtrados por tipo y año en una página específica.

**Parámetros**:

    page: El número de la página que se desea obtener.
    type: El tipo de energía (por ejemplo, solar, eólica, etc.).
    year: El año para filtrar los datos de energía.

Ejemplo de solicitud:

GET /energy/1/SOLAR/2019

Respuesta exitosa (200):
```json
{
  "content": [
    {
      "id": 1,
      "typeEnergy": "SOLAR",
      "year": 2019,
      "value": 150.5
    },
    {
      "id": 2,
      "typeEnergy": "SOLAR",
      "year": 2019,
      "value": 130.0
    }
  ],
  "totalPages": 5,
  "totalElements": 50,
  "size": 10,
  "number": 1,
  "numberOfElements": 2,
  "first": false,
  "last": false,
  "empty": false
}
```

## Licencia

Este proyecto está bajo la licencia [GPL-3.0] - ver el archivo [LICENSE](./LICENSE) para más detalles.