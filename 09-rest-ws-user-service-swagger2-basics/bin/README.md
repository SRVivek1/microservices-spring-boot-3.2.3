#Agenda

* springdoc swagger setup
* Note: As of springfox 3.0.0 swagger doesn't support springboot 3.x
* Reference: https://springdoc.org/#features


# Users API
	* Get all users 	: 	GET /users 
	* Get one user		:	GET /users/{id}
	* Save user		:	POST /users
	

#Disable auto type casting of date to time stamp
* application.properties : spring.jackson.serialization.write-dates-as-timestamps=false