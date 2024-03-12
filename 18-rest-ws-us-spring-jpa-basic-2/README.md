# Spring security integration basics
## Agenda

* Include spring JPA dependency
* Configure database details in application.properties
* Migrate User record to class type as JPA requires default construct and getter/setter methods.
* Added data.sql with insert queries to auto populate database with dummy data.


## APIs
### Users API
	* Get all users	 		: 	GET 	/users 
	* Get one user			:	GET 	/users/{id}
	* Delete one user		:	GET 	/users/{id}
	* Save user				:	POST	/users
	
### JPA Users API
	* Get all users 		: 	GET 		/jpa/users 
	* Get one user			:	GET 		/jpa/users/{id}
	* Delete one user		:	DELETE 	/jpa/users/{id}
	* Save user				:	POST 		/jpa/users
	

## Disable auto type casting of date to time stamp
* application.properties : spring.jackson.serialization.write-dates-as-timestamps=false


