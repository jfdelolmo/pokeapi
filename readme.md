TODOs:
 - add gradle task to generate the docker image
 - Review readme

#POKEAPI 

Spring Boot application project with gradle, docker, docker-compose and h2database.

Provides three end-points to retrieve the top 5 pokemons depending it's weight, height or based experienced.

It uses the [java/kotlin wrapper library](https://github.com/PokeAPI/pokekotlin "https://github.com/PokeAPI/pokekotlin") to access to the Pokemon Api.

##Build 
To run the tests:
```
./gradlew test
```

To build the entire project:
```
./gradlew build 
```

##Docker instructions
```
docker build -t pokeapi .
```

```
docker run -p 8080:8080 pokeapi
```
##Docker-compose instructions
```
docker-compose up
```

```
docker-compose stop
```

## Usage

Once the application is boot up:

### Postman Collection
Import the src/test/resources/postman/pokeapi.json collection to Postman

### Command line

#### topFiveHeaviest
```
curl -X GET "http://localhost:8080/alea/pokeapi/top/five/red/heaviest" -H "accept: */*"
```
#### topFiveHighest
```
curl -X GET "http://localhost:8080/alea/pokeapi/top/five/red/highest" -H "accept: */*"
```

#### topFiveBaseExperienced
```
curl -X GET "http://localhost:8080/alea/pokeapi/top/five/red/experienced" -H "accept: */*"
```

## Database console
Access to the H2 database console: 
```
http://localhost:8080/pokedb/console
```
Check the configuration to access:

- JDBC URL: jdbc:h2:mem:pokedb
- User name: admin
- Password: admin
