#Agenda

* Actuator service
* Spring boot Hal Expolrer added to monitor application
* Hal Browser can be accessed on context path '/' or 'http://localhost:8080/explorer/index.html#uri=/'
* API Monitoring JSON doc - http://localhost:8080/actuator

* Reference: https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html

# Users API
	* Get all users 	: 	GET /users 
	* Get one user		:	GET /users/{id}
	* Save user		:	POST /users
	

#Disable auto type casting of date to time stamp
* application.properties : spring.jackson.serialization.write-dates-as-timestamps=false