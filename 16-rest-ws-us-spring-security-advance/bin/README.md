# Spring security integration basics
## Agenda

* Include spring security dependency
* Test with default user 'user' & generated password on console
* Configure static username and password in application.properties


## Users API
	* Get all users 	: 	GET /users 
	* Get one user		:	GET /users/{id}
	* Save user		:	POST /users
	

## Disable auto type casting of date to time stamp
* application.properties : spring.jackson.serialization.write-dates-as-timestamps=false