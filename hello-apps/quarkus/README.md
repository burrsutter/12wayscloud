# Quarkus Hello World

# Interactive dev mode

```
mvn quarkus:dev

curl localhost:8080

curl localhost:8080/health

curl localhost:8080/alive
```

# If you want a fat jar

note: quarkus.package.type=uber-jar in application.properties makes this work

```
mvn clean compile package
```

```
java -jar target/hello-1.0.0-runner.jar
```

But that is not the default for containers and not how the default Dockerfile from code.quarkus.io expects things

# Thin Jar for containers

```
mvn clean compile package
```

# Build container image
```
export IMAGE_VER=quarkus-demo:v1

docker build -f src/main/docker/Dockerfile.jvm -t burrsutter/$IMAGE_VER .

docker run -it -p 8080:8080 burrsutter/$IMAGE_VER
```

# publish container image

```
docker login docker.io
docker tag burrsutter/$IMAGE_VER docker.io/burrsutter/$IMAGE_VER
docker push docker.io/burrsutter/$IMAGE_VER
```

open https://hub.docker.com/r/burrsutter/quarkus-demo/tags
