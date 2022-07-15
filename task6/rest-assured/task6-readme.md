## Task 6 - Automate API
Given the REST API: https://developers.giphy.com/docs/api/endpoint#search
And this call to retrieve a list of GIFs: http://api.giphy.com/v1/gifs/search?q=funny+dog&api_key=dc6zaTOxFJmzC
Your task is to extensively Automate that API endpoint with assertions using java programming language. 
You can use the provided api_key: it's a public key for testing out that API.


## RestAssured
This Project uses RestAssured and Junit

### Configuration
* In application.properties set the path where the report result will be placed.

### Dependency
1. Java
2. Maven
3. RestAssured & Junit

### libraries used
1. RestAssured
2. Junit
3. log4j

### Running the Tests
* Go to the taskfolder/projectfolder
* Then execute the following command:
```
mvn test -Dtest=AppSuiteTests
```

#### Results
A report like below will be generated (in report directory you can find the full results)

![Resport Result](https://github.com/stefanycos/rest-assured-junit-demo/blob/master/report/report-sample.png?raw=true)
For generating this report was used Extent Reporting Framework, for details see: https://extentreports.com/.
