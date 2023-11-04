# Spring Boot Hello World

# Interactive dev mode

```
mvn spring-boot:run

curl localhost:8080

curl localhost:8080/health

curl localhost:8080/alive
```

# Create fat jar

```
mvn clean compile package
```

```
java -jar target/hello-1.0.0.jar
```

# Build container image
```
export IMAGE_VER=boot-demo:v1

docker build -f Dockerfile -t burrsutter/$IMAGE_VER .

docker run -it -p 8080:8080 burrsutter/$IMAGE_VER
```

# publish container image

```
docker login docker.io
docker tag burrsutter/$IMAGE_VER docker.io/burrsutter/$IMAGE_VER
docker push docker.io/burrsutter/$IMAGE_VER
```

open https://hub.docker.com/r/burrsutter/boot-demo/tags
