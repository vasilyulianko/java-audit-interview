# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table event_by_pedro (
  id                            integer,
  tenant                        integer,
  user_id                       integer,
  event_time                    datetime(6),
  operation                     varchar(255),
  user_role                     varchar(255),
  identifier                    integer,
  action                        varchar(255),
  entity                        varchar(255),
  entity_id                     integer,
  session_id                    varchar(255),
  details                       varchar(255)
);


# --- !Downs

drop table if exists event_by_pedro;

