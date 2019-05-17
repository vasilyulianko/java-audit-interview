# auditinterview
## Task description
Send the information to the audit service and store into the database.
Write a test to verify.

## MYSQL Details

Host: vsinterview.ckdxitur80we.eu-west-1.rds.amazonaws.com

## DATABASE Table

```SQL

CREATE TABLE audit_lucas (
	id INT(11) AUTO_INCREMENT,
    tenant INT(11),
    user_id INT(11),
    event_time timestamp,
    operation varchar(255),
    user_role varchar(255),
    identifier INT(11),
    action varchar(255),
    details longtext,
    PRIMARY KEY (id)
);

```
