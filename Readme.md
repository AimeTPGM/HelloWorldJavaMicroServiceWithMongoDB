# BIG NOTE

this is an example of "One Micro Service"

In realworld, one action of user may call many many microservices, for example, Purchasing things may call "Product service", "Customer Service", "Payment Service" and "BlaBlaBla Service" (depends on how small it have been designed and how many services needed to be called to complete the action) – go to the bottom of this page for more detail and read my slideshare

So, I hope this project will be helpful for people who is getting start to build a micro service by Spring and use MongoDB

and anybody who have tried this project will be able to apply or start their own micro service projects by their own :)

Let's learn together!

# "Hello World" Micro Service & MongoDB

Language: Java

Framework: Spring

Tool: STS, MongoDB

this project is extended from https://github.com/AimePGM/HelloWorldJavaMicroService

## How to run

### MongoDB

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

### STS

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

Request name     | parameter(s) | Description
-----------------|--------------|-------------------------------
newName          | name=String  				 | add new [name] to your database
hello            | id=String    				 | query by id from db and return "Hello, [name]!"
helloToAll       |             					 | query all records and says "Hello, [name]!"
helloToAllByName | name=String  				 | query all records those have "name"=[name] and says "Hello, [name]!"
getAllData       |              				 | return all records [{"id":[id],"name":[name]}]
removeById		 | id=String					 | remove a record by [id]
changeNameById   | id=String, changedName=String | query a record by [id] and change the name to [name]


## example

if you try

```
http://localhost:8085/newName?name=James
```

it will show

```
added new name: James
```

you may try to add more

```
http://localhost:8085/newName?name=Aime
http://localhost:8085/newName?name=Aime
http://localhost:8085/newName?name=Aime
http://localhost:8085/newName?name=Aime
http://localhost:8085/newName?name=Aime
http://localhost:8085/newName?name=Alpha
http://localhost:8085/newName?name=Beta
```

then

```
http://localhost:8085/getAllData
```

it will show something like this

```
[{"id":"56a8e0efd4c6b7ab47555ece","name":"James"},{"id":"56a8e10fd4c6b7ab47555ecf","name":"Aime"},{"id":"56a8e14ed4c6b7ab47555ed0","name":"Aime"},{"id":"56a8e150d4c6b7ab47555ed1","name":"Aime"},{"id":"56a8e151d4c6b7ab47555ed2","name":"Aime"},{"id":"56a8e152d4c6b7ab47555ed3","name":"Aime"},{"id":"56a8e7e2d4c68879aea3e96d","name":"Alpha"},{"id":"56a8e7e7d4c68879aea3e96e","name":"Beta"}]
```

Oh! how many "Aime" we have!? check!

```
http://localhost:8085/helloToAllByName?name=Aime
```

the return will be

```
5 people(s) named Aime
Hello, Aime!
Hello, Aime!
Hello, Aime!
Hello, Aime!
Hello, Aime!
```

Hmm.. want to change one of Aime? try!

```
http://localhost:8085/changeNameById?id=56a8e14ed4c6b7ab47555ed0&changedName=whatever
```

ha.. now id:56a8e14ed4c6b7ab47555ed0 will change the name to "whatever"

or want to remove one people?

```
http://localhost:8085/removeById?id=56a8e7e7d4c68879aea3e96e
```

Byebye Beta ...

(if you use getAllData, you may notice our "Beta" is gone)

# More detail about micro service

Micro service and Hello World with JAVA Spring Framework

http://www.slideshare.net/PankamolSrikaew/micro-service-56062328

Oh.. I will do an extension for this project :)

I hope you guys have fun
