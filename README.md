# WilsonLine 
Proyecto realizado para clase utilizando todas las tecnologías dadas posibles. :airplane:

# Instalación
Principalmente la instalación es de la base de datos, en el proyecto está la carpeta "*wilsonline_db*" donde están todos los ficheros para crear tablas, vistas e inserción de datos, pero antes de nada, es necesario crear la base de datos, para ello ejecutamos esta linea en el MySQL:
```
create database flight_reservations
```
Además hay que crear los Pool de conexiones para que se pueda conectar la Factoría del proyecto con la base de datos, en este caso, supondremos que eres un alumno o profesor que está mirando nuestro proyecto y tienes la misma maquina de Oracle donde tenemos instalado MySQL Workbench, si no es así, deberás poner tu conexión a tu base de datos.
Bien, ahora tenemos que ir a la carpeta donde se ubica el GlassFish que normalmente está en `C:\Program Files\glassfish-4.1.1\glassfish\bin`, sino donde tu lo hayas instalado, y ejecutamos estos dos scripts para crear el Pool
```
asadmin create-jdbc-connection-pool --datasourceclassname=com.mysql.jdbc.jdbc2.optional.MysqlDataSource --restype=javax.sql.DataSource --property=user=2dawa:password=2dawA2!06:url="jdbc\:mysql\://localhost\:3306/flight_reservations" FlightReservationsPool
```
```
asadmin create-jdbc-resource --connectionpoolid FlightReservationsPool jdbc/flight_reservations
```

Teniendo ya esto hecho y bien configurado, podrás utilizar y probar nuestro proyecto *WilsonLine* :sparkles:


# Datos
- Curso escolar 2016-17
- 2º CSFP Desarrollo de Aplicaciones Web A (2ºDAWA)
- Modulo Desarrollo Web en Entorno Cliente (DEW)
- Tutora Albérica

# Miembros
Miembro | Participación  | Twitter
--------|----------------|---------
Javier Gracia Gonzalez | Base de datos | [@javigracia](https://twitter.com/javigracia)
Cristina Peón Padilla | Servidor | [@CristiDeveloper](https://twitter.com/CristiDeveloper)
Michael Reyes Seiffert | Cliente | [@mreysei](https://twitter.com/mreysei)

¡Puedes ver más detalladamente lo que ha hecho cada miembro en [Trello](https://trello.com/b/1HOBOqtP)!
Cualquier duda, puedes contactarnos por *mensaje privado* en Twitter. :heart_eyes:
