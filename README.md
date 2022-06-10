# Countries Land Routes
##Description
This project exposes a RESTful endpoint which takes two country 
codes as path parameters and returns a route between them, if it exists.
##Requirments
- Java 11
- Maven
- Spring Boot
##Instructions
- Build project with 'mvn clean install'
- Start the application with 'mvn spring-boot:run'
- From Postman or with Curl access the API endpoint (e.g. http://localhost:8080/routing/CZE/ITA)
##Solution
- The goal of the solution is to be as clean and simple as possible.
- The Restful endpoint is created with Spring and is kept to a minimum.
- A CountryService loads country information, we are only interested in cca3 code and borders.
- A RoutingService uses a GraphUtil for doing the actual path computation.
- Because the way data is structured and because we are asked the path between two countries, this is a classic
graph problem of finding if there is one path between two nodes, and if it exists returning one of the paths.
We start from origin country and traverse the nodes via BFS, then at some point, we have to pass through the
destination country, otherways there is no path between the nodes.
##Improvements
- Add proper logging.
- Add junit tests.
- Improve algorithm.
