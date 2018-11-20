# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table event_by_user_maire (
  id                            bigint auto_increment not null,
  tenant                        bigint,
  user_id                       bigint,
  event_time                    datetime(6),
  operation                     varchar(255),
  user_role                     varchar(255),
  identifier                    bigint,
  action                        varchar(255),
  entity                        varchar(255),
  entity_id                     bigint,
  session_id                    varchar(255),
  details                       longtext,
  constraint pk_event_by_user_maire primary key (id)
);


# --- !Downs

drop table if exists event_by_user_maire;

