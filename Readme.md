# BIG NOTE

this is an example of "One Micro Service"

In realworld, one action of user may call many many microservices, for example, Purchasing things may call "Product service", "Customer Service", "Payment Service" and "BlaBlaBla Service" (depends on how small it have been designed and how many services needed to be called to complete the action) – go to the bottom of this page for more detail and read my slideshare

So, I hope this project will be helpful for people who is getting start to build a micro service by Spring and use MongoDB

and anybody who have tried this project will be able to apply or start their own micro service projects by their own :)

Let's learn together!

# "Hello, World" Micro Service & MongoDB

Language: Java

Framework: Spring

Tool: STS

Database: MongoDB

Dependency Mangement Tool: Maven

this project is extended from https://github.com/AimePGM/HelloWorldJavaMicroService

# How to run on Sprint Tool Suite

## MongoDB

download and install: https://www.mongodb.org/

open Terminal (or whatever to use command line)

open the connection of MongoDB for this project

```
mongod --dbpath ~/your/directory/to/this/project/HelloWorldMicroServiceWithMongoDB/data
```

then it will build something needed in ~/data folder for MongoDB and MongDB will be ready at port 27017 (default)

NOTE: if you need to change to the other port, use the following command line

```
mongod --dbpath ~/your/directory/to/this/project/HelloWorldMicroServiceWithMongoDB/data --port [PORT_NUMBER]
```

example, 

```
mongod --dbpath ~/your/directory/to/this/project/HelloWorldMicroServiceWithMongoDB/data --port 27018
```

## STS

Run it on Spring Tool Suite (STS) is the easiest way to go

download and install STS

https://spring.io

Open STS and go to

```
File -> Import -> General -> Existing Projects into work space -> [Select the directory and there it is :D ]
```

If the port isn't fixed, it will run on default port 8080

To fix the port, go to "run configuration" and add property server.port -> value = port_number, for example server.port 8085 

then open this link in the web browser

```
http://localhost:8085/newName?name=whatever
```

then 'whatever' name will be stored in your MongoDB; database name: helloworld, collection: name

want to see the query of all record?

```
 http://localhost:8085/getAllData
```

there it is :)

# The way to have fun 

I believe you are able to learn what APIs this project have [HINT: Look at HelloWorldRest.java ans you will get it all!]

I planned to write a blog entry to explain about this project in detail but kinda busy this time, my apology

Anyway, for saving your time, try...

Request name     |	Type	| Parameter(s) | 	Response					|	Description					
-----------------|----------|--------------|--------------------------------|------------------------------
hellos           |	GET 	|  			   | 	 array of Hello Object		| query all record from database and return array of Hello object
helloByID/{id}|	GET     | id=String  | 		Hello Object 			| query by {name} from database and return a single object Hello 
helloByName/{name}|	GET     | name=String  | 		array of Hello Object 			| query all the data that has {name} and return an array of Hello object
hello/new    |	POST	| name=String|	added new name: {name}		| add more Hello people ;)
hello/edit		 |	PUT		| id=String, name=String | Changed name from {name from database} to {name} | query a single Hello object by id and change the name from database to {name}
hello/{id}/remove|	DELETE	| id=String	| removed: {id}	| delete a Hello person by id


## example

if you try

```
http://localhost:8080/hellos
```

it will show

```
[
	{
		id: "59e50a8b77c835e20f0aca1c",
		name: "Aime"
	},
	{
		id: "59e50a8b77c835e20f0aca1d",
		name: "James"
	}
]
```

you may try to add more by

```
http://localhost:8080/hello/new
```

with a request body key: name and value: Me (please specify the request to use application/x-www-form-urlencoded)

then it will say

```
added new name: Me
```

If you would like to get a single person data, then

```
http://localhost:8080/helloByID/59e50a8b77c835e20f0aca1c
```

will return

```
{
	id: "59e50a8b77c835e20f0aca1c",
	name: "Aime"
}
```

So, you can try other APIs provided above and enjoy adding/deleting/modifying the code ;) will be a lot of fun

# More detail about micro service

Micro service and Hello World with JAVA Spring Framework

http://www.slideshare.net/PankamolSrikaew/micro-service-56062328

Oh.. I will do an extension for this project :)

I hope you guys have fun
