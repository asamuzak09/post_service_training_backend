create table users
(
    id               serial
        constraint users_pk
            primary key,
    account_id       varchar not null,
    encrypt_password varchar not null,
    name             varchar,
    status_comment varchar,
    icon_image_url varchar,
    back_ground_image_url varchar
);

alter table users
    owner to postgres;

create unique index users_account_id_uindex
    on users (account_id);

create unique index users_id_uindex
    on users (id);