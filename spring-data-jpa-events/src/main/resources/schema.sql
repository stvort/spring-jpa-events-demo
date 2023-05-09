create table developers (
    id bigserial,
    level int default 0,
    full_name varchar(255),
    primary key (id)
);

create table users (
    id bigserial,
    login varchar(255),
    primary key (id)
);