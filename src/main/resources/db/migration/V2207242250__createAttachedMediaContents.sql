CREATE TABLE attached_media_contents (
id sequence,
post_id int NOT NULL,
url text,
mediaType int,
CONSTRAINT amc_id_pk PRIMARY KEY(id)
CONSTRAINT posts_id_fk FOREIGN KEY (post_id) REFERENCES posts (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

