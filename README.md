# Proyecto de Gestión de Aerolíneas "Avianca"

## Descripción

Este proyecto es una aplicación de gestión para aerolíneas, diseñada para permitir a los usuarios registrar, actualizar, eliminar y consultar datos relacionados con aviones, trayectos, aeropuertos, tarifas de vuelo, tipos de documentos y más. La aplicación incluye una interfaz de línea de comandos que facilita la interacción con el sistema.

## Autores

- Alejandro Silgado Bravo
- Angie Katherine Ardila Parra

## Características

- **Registro de Aviones**: Permite añadir nuevos aviones con información como matrícula, capacidad y fecha de fabricación.
- **Asignación de Tripulación**: Asigna empleados a trayectos específicos.
- **Consultas**: Ofrece funcionalidades para consultar aviones, trayectos, aeropuertos, tarifas de vuelo y tipos de documentos.
- **Actualización y Eliminación**: Permite actualizar y eliminar aviones, trayectos, aeropuertos, tarifas de vuelo y tipos de documentos.

## Requisitos

- Java 8 o superior
- Conexión a base de datos SQL (MySQL, PostgreSQL, etc.)

## Instalación

1. Clona este repositorio:
   ```sh
   git clone https://github.com/tu_usuario/nombre_del_repositorio.git
   ```

2. Navega al directorio del proyecto:
   ```sh
   cd nombre_del_repositorio
   ```

3. Compila el proyecto:
   ```sh
   javac -d bin src/**/*.java
   ```

4. Ejecuta la aplicación:
   ```sh
   java -cp bin administrador.application.appAdministrador
   ```

## Uso

1. Inicia la aplicación y selecciona una opción del menú:
   - **1**: Registrar Avión
   - **2**: Asignar Tripulación
   - **3**: Consultar Avión
   - (continúa con otras opciones según el menú mostrado)

2. Sigue las instrucciones en pantalla para ingresar los datos requeridos.

## Contribuciones

Si deseas contribuir a este proyecto, por favor sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una rama para tu característica (`git checkout -b feature/nueva-caracteristica`).
3. Realiza tus cambios y haz commit (`git commit -am 'Añadir nueva característica'`).
4. Empuja tus cambios a tu fork (`git push origin feature/nueva-caracteristica`).
5. Abre una solicitud de extracción en el repositorio original.

## Licencia

Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

