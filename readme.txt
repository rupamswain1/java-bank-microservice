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

keycloak command:
docker run -p 7080:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.2.4 start-dev

set client in keycloak:
1. go to http://localhost:7080/admin/master/console/#/
2. click on 'clients' and click on 'create client'
3. enter client ID : test-ms
4. name : test ms keycloak
5. in "Capability config" select "Service accounts roles"
Set the roles:
1. click on "Realm Roles"
2. click on "Create Role"
3. enter role name as "ACCOUNTS" or "LOAN" or "CARDS" and description
4. Go to your clients
5. Go to Service Accounts Role
6. Click on "Assign Role"
7. use filter and assign the created role

