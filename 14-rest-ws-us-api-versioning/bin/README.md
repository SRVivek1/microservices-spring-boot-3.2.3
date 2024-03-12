# Agenda

* API Versioning

## Versioning mechanism:
	* URI Versioning
		* Used by Twitter.
		* ** Configuration **

		``` 
		@GetMapping(path = "v1/person")
		@GetMapping(path = "v2/person")
		```
    
	* Request Variable/Parameter versioning
		* Amazon
		* ** Configuration **
    
		```
		@GetMapping(path = "/person/param", params = "version=1")
		@GetMapping(path = "/person/param", params = "version=2")
		```
			
	* HTTP Custom Header versioning
		* Used by Mircosoft
		* ** Configuration **

   		 ```
		@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
		@GetMapping(path = "/person/header", headers = "X-API-VERSION=2") 
		```
				
	* MIME type versioning
		* Also know as "content negotiation" or "Accept header".
		* Used by GitHub.
		* ** Configuration **

		```
		@GetMapping(path = "/person/produces", produces = "application/vsr.company.app-v1+json")
		@GetMapping(path = "/person/produces", produces = "application/vsr.company.app-v2+json")
		```

## Factors
* URI Pollution
	* Both URI & Request parameter version will create a new URI for new API URIs.
	* Supports caching as each API URI is unique.
	
* Misuse of HTTP headers
	* HTTP custom header and MIME type versioning approach.
	* HTTP Headers were not meant to be used for versioning.
	* No new URI is required for a new version requester need to send the version info in HTTP header.
	* Caching can't be supported as same URI is used for all versions.

* Caching
	* Check if we have caching requirement.
	
* API Documentation
	* Check which kind of documentation support we need.
	
## Note: 
* There's no perfect solution.
* Based on the need we need to take the decision for versioning approach.


## Jackson properties
### Disable auto type casting of date to time stamp
* application.properties : spring.jackson.serialization.write-dates-as-timestamps=false
