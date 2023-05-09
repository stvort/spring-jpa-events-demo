create table users (
    id bigserial,
    login varchar(255),
    creation_time timestamp,
    last_update_time timestamp,
    primary key (id)
);