En la carpeta Dise�o se encuentran los siguientes diagramas de dise�o del sistema
	Despliegue.png: Diagrama de despliegue incluyendo clases, paquetes y relaciones.
	Datos.png: Modelado de los datos en la base de datos.

En la carpeta Unidades de despliegue se encuentran los siguientes archivos de despliegue generados a partir del c�digo fuente.
	BackEndTareas.jar: Unidad de despliegue de la l�gica de negocio de la aplicaci�n.
	FrontEndTareas.war: Unidad de despliegue de la l�gica de presentaci�n de la aplicaci�n.

En la carpeta BackEndTareas se encuentra el c�digo fuente del back end de la aplicaci�n.

En la carpeta FrontEndTareas se encuentra el c�digo fuente del front end de la aplicaci�n.

Tanto el back end como el front end fueron desarrollados en Java EE 7 y se comunican entre si por medio de servicios web SOAP.
El front end utiliza la tecnolog�a JSF  para las vistas web.
Tanto el back end como el front end se probaron de manera local, mientras que la base de datos PostgreSQL se encuentra alojada
en Heroku.

Una demostraci�n del funcionamiento de la aplicaci�n se encuentra en el siguiente video:

Para probar la aplicaci�n se puede ingresar sesi�n con cualquiera de los siguientes usuarios ya registrados en la base de datos.
	Usuario: felipe123		Contrase�a: qazwsxedc
	Usuario: jimenez85		Contrase�a: 122345
	Usuario: ingeniero67		Contrase�a: password
Cada uno de los usuarios puede gestionar sus propias tareas independientemente de las tareas de los dem�s.
