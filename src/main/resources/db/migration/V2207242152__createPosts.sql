CREATE TABLE posts (
    id serial,
    user_id int,
    content text NOT NULL,
    posted_at timestamp,
    post_type int,
    CONSTRAINT posts_id_pk PRIMARY KEY(id),
    CONSTRAINT users_id_fk FOREIGN KEY (user_id) REFERENCES users (id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);


