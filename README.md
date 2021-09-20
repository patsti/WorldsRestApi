# WorldsRestApi
Restful API with postgres backend, connected with WorldUI-project
This project is using a Postgres-db loaded with mysqls 'world.sql.gz'.

Requirement: Java8+,Postgres, pgAdmin 4 (usually included in postgres download)

## How to start (Windows):

Download / install Postgres (preferably with pgAdmin 4)

### Start Postgres (run the following from cmd):

  cd 'C:\Program Files\PostgreSQL\10\bin'
  
  pg_ctl start -D 'C:\Users\<USER>\PGData'
  
Start pgAdmin 4:

  create server
  
  create database called 'world'
  
  right-click the new database -> open "Query Tool"
  
  Copy/paste content of world.sql, press run.
  

### WorldsRestApi
Clone this project ('WorldsRestApi')

Open up in IntelliJ and press start.

Verify connection by entering one of the endpoints in the list below (Endpoints).

The result should be a serialized string.

### WorldUI
Clone 'WorldUI' (https://github.com/patsti/WorldUI.git)

Open project in IntelliJ.

Start by running the /patrik/worldui/StarterWorldUi.

Verify that it works by entering 'localhost:8081' in your browser. You should be redirected to 'localhost:8081/home', where you can navigate the app.


## Endpoints
* localhost:8080/api/init-game. This will generate a game-challenge and output a serialized version.
* localhost:8080/api/city. This will fetch all cities from DB, put it into a return object and serialize it.
* localhost:8080/api/countries. This will fetch all cities from DB, put it into a return object and serialize it.
* localhost:8080/api/countrylanguages. This will fetch all cities from DB, put it into a return object and serialize it.

