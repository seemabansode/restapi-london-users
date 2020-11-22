# restapi-london-users
REST API to return users in London and within 50 miles of London. 
Sping Boot application that calls an API at https://bpdts-test-app.herokuapp.com/, and returns people who are listed as either living in London, or whose current coordinates are within 50 miles of London.


## Software used

restapi-london-users is written in Java 11 using Spring Boot and uses Geodesic routines from GeographicLib library.

## Running the application locally

The source code of the application can be directly pulled into an IDE (e.g. IntelliJ, Eclipse) and run locally from inside there.

After the application is running, (assuming the application is running on localhost and port 8080).
Make a GET request to [http://localhost:8080/users-london](http://localhost:8080/users-london). 
This will return all users in London and whose latitude and longatude are within 50 miles of London.

## Working of the Application

The service is expected to call the API at given link using restTemplate and returns the list of all the users. 
The application returns the expected user list by calling /users all the users from the base API and by calling /users-london all the users whose latitude and longitudes are based in London and within 50 miles of London.
To determine users from London and within 50 miles of London, Inverse method from GeographicLib.
Inverse method solves the geodesic problems and returns the distance between two points given in Latitude and Longitude form in meters by using s12 parameter.
Distance is then converted into miles and compared with 50. If the distance is less that or equal to 50 miles and return the result accordingly as expected.

 

