# Sistema de Gestión para Empresa de Transporte Ferroviario

Este proyecto es una aplicación cliente-servidor multiusuario diseñada para gestionar las operaciones de una empresa de transporte ferroviario. La aplicación permite realizar operaciones relacionadas con estaciones, trenes, pasajeros y billetes desde el lado del servidor.  

## Funcionalidades del backend

### Para clientes de la compañía
1. **Búsqueda de trenes**:
   - Buscar trenes que pasen de una estación A a una estación B en un intervalo de tiempo dado.
2. **Consulta de horarios**:
   - Obtener el horario de los trenes para una estación específica.
3. **Compra de billetes**:
   - Posibilidad de comprar un billete siempre que:
     - Haya asientos disponibles.
     - El pasajero (nombre, apellido, y fecha de nacimiento) no esté ya registrado en el tren seleccionado.
     - Queden al menos 10 minutos para la salida del tren.

### Para empleados de la compañía
1. **Gestión de datos**:
   - Agregar nuevas estaciones y trenes.
2. **Consulta de pasajeros**:
   - Ver todos los pasajeros registrados en un tren específico.
3. **Consulta de trenes**:
   - Listar todos los trenes disponibles.

## Requisitos técnicos
1. Aplicación cliente-servidor con conexión en red.
2. Todos los datos se almacenan en el lado del servidor, y los clientes sincronizan los cambios tras cada operación.
3. Manejo de errores de hardware y software.

## Criterios de implementación
1. **Modularidad**:
   - Proyecto basado en Maven con módulos independientes para facilitar la construcción y despliegue.
2. **Base de datos**:
   - Conexión a una base de datos MySQL para almacenamiento persistente.
   - Entidades mapeadas a tablas mediante ORM.
3. **Acceso a datos**:
   - Gestión de entidades a través de DAO (Data Access Objects).
4. **Manejo de excepciones**:
   - Implementación de manejo de errores para asegurar la estabilidad.
5. **Logging**:
   - Sistema de registro habilitado para auditoría y depuración.
6. **Documentación técnica**:
   - Descripción detallada de la solución implementada.

## Estructura del proyecto
- **Módulos Maven**:
  - **Servidor**: Gestiona la base de datos, sincronización y lógica de negocio.
  - **Modelo**: Define las entidades del dominio y sus relaciones.
  - **DAO**: Implementación de acceso a datos.

## Tecnologías utilizadas
- **Lenguaje**: Java
- **Framework**: Spring
- **Base de datos**: MySQL
- **Herramientas de construcción**: Maven
- **Servidor de aplicaciones**: Compatible con cualquier AS (e.g., Tomcat, WildFly)

## Cómo ejecutar el proyecto
1. Clonar este repositorio.
2. Configurar las credenciales de MySQL en el archivo `application.properties`.
3. Construir y desplegar el proyecto con el siguiente comando:
   ```bash
   mvn clean install
