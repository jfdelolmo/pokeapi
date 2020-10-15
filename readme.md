# POKEAPI 

This application provides three end-points to retrieve the top 5 pokemons of the RED generation,
 depending it's weight, height or based experienced.

It uses the [java/kotlin wrapper library](https://github.com/PokeAPI/pokekotlin "https://github.com/PokeAPI/pokekotlin") to access to the Pokemon Api.

## Technology stack
- Spring Boot application
- H2 database
- Gradle build tool
- Docker & docker-compose
- Travis for continuous integration and AWS deployment

## Gradle tasks
To run the tests:
```
./gradlew test
```

To build the entire project:
```
./gradlew build 
```

To generate the image:
```
./gradlew buildDockerImage
```

To push the image to DockerHub:
```
./gradlew pushDockerImage
```

## Docker-compose instructions
To run the dockerized application with docker-compose:
```
docker-compose up
```
To run in background:
```
docker-compose up -d
```
To stop the dockerized application with docker-compose:
```
docker-compose stop
```

## How to try the application
### Local deployment
Boot up the application and access to the provided end-points.

#### Using Command line
*topFiveHeaviest*
```
curl -X GET "http://localhost:8080/alea/pokeapi/top/five/red/heaviest" -H "accept: */*"
```
*topFiveHighest*
```
curl -X GET "http://localhost:8080/alea/pokeapi/top/five/red/highest" -H "accept: */*"
```
*topFiveBaseExperienced*
```
curl -X GET "http://localhost:8080/alea/pokeapi/top/five/red/experienced" -H "accept: */*"
```
#### Postman Collection
Import the src/test/resources/postman/Pokemon.postman_collection.json collection and the
Local.postman_environment.json environment, then can be selected as **Local** from the environment 
dropdown in Postman.

### AWS deployment
The application is deployed in AWS, so can be accessed on-line.
####Using Command line
*topFiveHeaviest*
```
curl -X GET "http://pokeapiapp-env.eba-zu3w26k9.us-east-2.elasticbeanstalk.com/alea/pokeapi/top/five/red/heaviest" -H "accept: */*"
```
*topFiveHighest*
```
curl -X GET "http://pokeapiapp-env.eba-zu3w26k9.us-east-2.elasticbeanstalk.com/alea/pokeapi/top/five/red/highest" -H "accept: */*"
```
*topFiveBaseExperienced*
```
curl -X GET "http://pokeapiapp-env.eba-zu3w26k9.us-east-2.elasticbeanstalk.com/alea/pokeapi/top/five/red/experienced" -H "accept: */*"
```
#### Postman Collection
Import the src/test/resources/postman/Pokemon.postman_collection.json collection and the
AWS.postman_environment.json environment, then can be selected as **AWS** from the environment 
dropdown in Postman.

## Database console
Access to the H2 database console:
 
*Local deployment*
```
http://localhost:8080/pokedb/console
```

*AWS deployment*
```
http://pokeapiapp-env.eba-zu3w26k9.us-east-2.elasticbeanstalk.com/pokedb/console
```

Check the configuration to access:

- JDBC URL: jdbc:h2:mem:pokedb
- User name: admin
- Password: admin

----
[![Build Status](https://travis-ci.com/jfdelolmo/pokeapi.svg?branch=master)](https://travis-ci.com/jfdelolmo/pokeapi)
