# Project

In this project I use Spring Boot and Mysql DataBase

## Application starter process
```bash
for running this application we have tomcat server,
when we run application on server then we can use postman for 
sending the requests,
```
```bash
this application has a RestAPI's for Adding new record,Deleting record,Updating Record and
alse Have RestAPI for finding Actual (FinalValue) of product price
```
```bash
When we send the request from frontend (here postman) It comes front controller and 
front controller handle the request and accordingly needed It call the another layer
as  well ex. service,repository layer
and after that front controller also return the axpected output from backend to
front end, (In this application we passing data in JSON format)
```

