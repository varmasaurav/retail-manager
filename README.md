# retail-manager rest service
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

You will see the following message after a successful start up.
 ```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.4.0.RELEASE)


Application has started successfully with server running at http://localhost:8080/retail
```


# Test

The application somes with unit and integration tests for the rest end points. Use the following command to run tests.

```
gradle test
```

Besides, it also comes with gradle's `jacoco` plugin to see the code coverage. To check code coverage run the following command

```
gradle test jacocoTestReport
```

Navigate and open `build/reports/coverage/index.html` to see the coverage








