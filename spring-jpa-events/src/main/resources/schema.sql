create table users (
    id bigserial,
    login varchar(255),
    creation_time timestamp,
    last_update_time timestamp,
    created_by varchar(255),
    modified_by varchar(255),
    primary key (id)
);