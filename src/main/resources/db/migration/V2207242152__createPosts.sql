CREATE TABLE posts (
id sequence,
user_id int NOT NULL,
post_id int NOT NULL,
content text NOT NULL,
imageUrls text,
videoUrls text,
postedAt timestamp,
postType int,
CONSTRAINT posts_id_pk PRIMARY KEY(id),
CONSTRAINT users_id_fk FOREIGN KEY (user_id) REFERENCES users (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);


