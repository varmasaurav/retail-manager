# retail-manager
This rest web service is built with spring boot

## Dependencies

- Gradle 2.3
- Java 8

## Build

This is restful service with an embedded tomcat. Hence, a WAR file may not be required. A JAR can be built which can be deployed/run in server. Since it is gradle based java application use the following to package it in a jar.

```
gradle build
```
To build without running tests

```
gradle build -x test
```

On successful build the jar can be found at `build/libs/` path.

## Run

Running the application is as easy as building and a one step process. Once you have the jar it can be run with the following command.

```
java -jar path/to/jar/db-retail-manager-0.1.0.jar
```
During development you might want to run the application with jar, the following command will be useful to run without jar.

```
gradle run
```

You will see the following message after a successful start up.
 ```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.0.RELEASE)


Application has started successfully with server running at http://localhost:8080
```


## Test

The application somes with unit and integration tests for the rest end points. Use the following command to run tests.

```
gradle test
```

Besides, it also comes with gradle's `jacoco` plugin to see the code coverage. To check code coverage run the following command

```
gradle test jacocoTestReport
```

Navigate and open `build/reports/coverage/index.html` to see the coverage

## Server Side API
The retail-manager service uses Google's GeoCoding API to locate a shop and exposes following rest APIs to add a shop and get the nearest shop. Here are they -

### Add Shop

This api adds a shop to the in-memory database.

```
URI            - /shop/add
REQUEST BODY   - {"shopName" : "Test Shop","shopAddress" : {"number": "1600 Amphitheatre Parkway Mountain View, CA","postCode" : 94043}}
HTTP METHOD    - POST
HTTP RESPONSE  - 201 OK
RESPONSE BODY  - {"successful": true}
```
e.g - http://localhost:8080/retail/add-shop

### Get Nearest Shop

This api gets the nearest shop to the location (latitude, longtitude) passed in the request parameter.

```
URI            - /shop/nearest
REQUEST PARAMS - customerLatitude, customerLongitude
HTTP METHOD    - GET
HTTP RESPONSE  - 200 OK
RESPONSE BODY  - {"shopName" : "Test Shop","shopAddress" : {"number": "1234","postCode" : 600078}, "shopLatitude": "78.903", "shopLongitude" : "81.09"}

```

e.g - http://localhost:8080/shop/nearest?customerLatitude=56.90678428&customerLongitude=67.78942




