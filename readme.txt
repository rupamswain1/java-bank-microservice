# to run the microservices app using docker follow below instructions

1. move to each folder i.e accounts, creditCards, loanApplication and springClouds and run
    mvn compile jib:dockerBuild
2. then move to docker-compose, move to default or qa or prod which ever is required and run
    docker compose up -d
3. which ever profile you choose (default, qa, prod) the application will fetch build info from the respective profile from github, which is located in springClouds/src/main/resources/config
if you change the configs in github to get the refreshed data call the /actuator/busrefresh endpoint of any of the services using a POST request. to automate it a webhook needs to be setup

Data base credentials will be fetched from the spring cloud/ config server, i we want to set the configs from git then add the properties to their respective folders

redis container for rate limiter
docker run -p 6379:6379 --name javaredis -d redis

Prometheus url:
http://localhost:9090/targets?search=