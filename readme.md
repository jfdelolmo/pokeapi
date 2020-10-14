#POKEAPI 

Spring Boot application project with gradle, docker, docker-compose and h2database

Uses the client http://.... to access to the Pokemon Api

Provides the following end-points:

##Build 
To run the tests:
```bash
./gradlew test
```

To build the entire project:
```bash
./gradlew build 
```

# Docker instructions
##Docker
```bash
docker build -t pokeapi .
```

```bash
docker run -p 8080:8080 pokeapi
```
##Docker-compose
```bash
docker-compose up
```

```bash
docker-compose stop
```

## Examples

Once the application is boot up:

### topFiveHeaviest
```bash
curl -X GET "http://localhost:8080/alea/pokeapi/top/five/red/heaviest" -H "accept: */*"
```
### topFiveHighest
```bash
curl -X GET "http://localhost:8080/alea/pokeapi/top/five/red/highest" -H "accept: */*"
```

### topFiveBaseExperienced
```bash
curl -X GET "http://localhost:8080/alea/pokeapi/top/five/red/experienced" -H "accept: */*"
```
