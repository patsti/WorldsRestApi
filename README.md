# WorldsRestApi
Restful API with postgres backend, connected with WorldUI-project
This project is using a Postgres-db loaded with mysqls 'world.sql.gz'.

##Endpoints
* localhost:8080/api/init-game. This will generate a game-challenge and output a serialized version.
* localhost:8080/api/city. This will fetch all cities from DB, put it into a return object and serialize it.
* localhost:8080/api/countries. This will fetch all cities from DB, put it into a return object and serialize it.
* localhost:8080/api/countrylanguages. This will fetch all cities from DB, put it into a return object and serialize it.

