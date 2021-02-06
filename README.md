### Requirement

##### 1. CRUD microservice
The objects are generic JSON objects which have an ID field, but can contain any other keys
##### 2. Productize your microservice 
dockerize your microservice, and expose on port 4000
setup your docker with proper production-grade parameters/setup/execution

##### Extra credits:
1. Support a swagger UI


### Assumption
We have to create a microservice which supports Create, Read, Update and Delete operations. 
It also exposes a swagger UI to test the operations and also get information about the behaviour of this service.

### In Scope
Creating and dockrizing microservice with CRUD operations, exposing it on 4000 port with docker port mapping.
For storing data we are using H2 in-memory database.

### Out of Scope
We are not considering Exceptions / errors for this demo application.

### How to build and run and test
#### 1. Build
First unzip the folder to a location where we can run the below command from root folder of this project (i.e /crud)
```
./mvnw clean package
```
The above command will create the jar file required for Docker to build the image

#### 2. Building docker image 
The below command will build the docker image
```html
docker build . -t crud:v1
```
#### 3. Running the Application
##### 1. we can run the application directly as a spring boot app as below
```html
java -jar target/crud-0.0.1-SNAPSHOT.jar
```
the application can be accessed with below URL 
```html
http://localhost:8088/swagger-ui.html#/
```

##### 2. we can also run the app as a Docker image as below
```html
docker run -p 4000:8088 crud:v1
```
if we are running the applcation as docker image the can access the app on below URL
```html
http://localhost:4000/swagger-ui.html#/
```

#### 4. Testing the Application
1. We can test the application by accessing the Swagger-UI
2. We can also test the allocation by running the test script which is provided with this application 
```html
Give execution access to the script
chmod +x test_script.sh

Run the test script after the app is up and running
./test_script.sh
```