En la carpeta Diseño se encuentran los siguientes diagramas de diseño del sistema
	Despliegue.png: Diagrama de despliegue incluyendo clases, paquetes y relaciones.
	Datos.png: Modelado de los datos en la base de datos.

En la carpeta Unidades de despliegue se encuentran los siguientes archivos de despliegue generados a partir del código fuente.
	BackEndTareas.jar: Unidad de despliegue de la lógica de negocio de la aplicación.
	FrontEndTareas.war: Unidad de despliegue de la lógica de presentación de la aplicación.

En la carpeta BackEndTareas se encuentra el código fuente del back end de la aplicación.

En la carpeta FrontEndTareas se encuentra el código fuente del front end de la aplicación.

Tanto el back end como el front end fueron desarrollados en Java EE 7 y se comunican entre si por medio de servicios web SOAP.
El front end utiliza la tecnología JSF  para las vistas web.
Tanto el back end como el front end se probaron de manera local, mientras que la base de datos PostgreSQL se encuentra alojada
en Heroku.

Una demostración del funcionamiento de la aplicación se encuentra en el siguiente video:

Para probar la aplicación se puede ingresar sesión con cualquiera de los siguientes usuarios ya registrados en la base de datos.
	Usuario: felipe123		Contraseña: qazwsxedc
	Usuario: jimenez85		Contraseña: 122345
	Usuario: ingeniero67		Contraseña: password
Cada uno de los usuarios puede gestionar sus propias tareas independientemente de las tareas de los demás.
