# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table auditlucas (
  id                            integer auto_increment not null,
  tenant                        integer,
  user_id                       integer,
  event_time                    datetime(6),
  operation                     varchar(255),
  user_role                     varchar(255),
  identifier                    integer,
  action                        varchar(255),
  details                       varchar(255),
  constraint pk_auditlucas primary key (id)
);


# --- !Downs

drop table if exists auditlucas;

