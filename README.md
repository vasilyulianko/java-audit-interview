# auditinterview - diogo
## Task description
Send the information to the audit service and store into the database.
Write a test to verify.

## MYSQL Details
Host: vsinterview.ckdxitur80we.eu-west-1.rds.amazonaws.com

## DATABASE Table
```SQL

CREATE TABLE event_by_diogo (
	id INT(11) AUTO_INCREMENT,
    tenant INT(11),
    user_id INT(11),
    event_time timestamp,
    operation varchar(255),
    user_role varchar(255),
    identifier INT(11),
    action varchar(255),
    entity varchar(255),
    entity_id INT(11),
    session_id varchar(255),
    details longtext,
    PRIMARY KEY (id)
);

```

## What was build
Demo rest api developed using Play framework and Java that receives a user event in Json format and stores into the MySQL database

## What you'll need
Java 1.8
  
[sbt](https://www.scala-sbt.org/download.html)

## Instructions
Import the project from GitHub

Run java-audit-interview app
```
sbt run
```

## Test the App
Now that the app is running, visit

http://localhost:9000 in order to see the landing page and api info

http://localhost:9000/v1/events in order to see a list of stored events